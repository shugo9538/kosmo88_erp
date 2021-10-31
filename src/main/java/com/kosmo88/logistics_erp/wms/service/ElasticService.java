package com.kosmo88.logistics_erp.wms.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetRequest;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.CountRequest;
import org.elasticsearch.client.core.CountResponse;
import org.elasticsearch.client.indices.AnalyzeRequest;
import org.elasticsearch.client.indices.AnalyzeResponse;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.wms.dao.ElasticDao;
import com.kosmo88.logistics_erp.wms.dao.WarehouseDao;
import com.kosmo88.logistics_erp.wms.dto.PurchaseAndSaleDto;
import com.kosmo88.logistics_erp.wms.dto.SalesDetailDto;
import com.kosmo88.logistics_erp.wms.dto.V_warehouseDto;

@Service
public class ElasticService {

	@Autowired
	WarehouseDao warehouseDao;
	@Autowired
	ElasticDao elasticDao;

	//일정 주기로 인덱싱이 필요하다.
	//Dash 화면을 띄울때마다 인뎅실할까 생각했는데 부하가 너무 커지지 않을까 하여 스레드로 반복 작업 처리
	//특정 시간마다 인덱싱하기 Timer 스레드클래스 이용
	@PostConstruct
	private void indexFrequently() {
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			
			int i = 0;
			@Override
			public void run() {
				indexPurchaseAndSale();
				indexSalesDetail();
				indexWarehouse();

				System.out.println("indexing 완료. " + i++ +" 회");
			}
		};
		//밀리세컨드 단위이므로 보기좋게 작성
		timer.schedule(timerTask, 0, 10*60*1000);
	}
	

	//mapping and settings
	public XContentBuilder getCommonIndexSettings() {
		XContentBuilder settings = null;
		try {
			settings = XContentFactory.jsonBuilder()
				.startObject()
					.field("number_of_shards",5)
					.field("number_of_replicas",1)
					
					.startObject("analysis")
						.startObject("tokenizer")
							.startObject("nori_tokenizer")
								.field("type","nori_tokenizer")
//								.field("decompound_mode","mixed")
								.field("decompound_mode","discard")
//								.field("user_dictionary","user_dictionary.txt")
							.endObject()
						.endObject()
						
						.startObject("analyzer")
							.startObject("nori_analyzer")
								.field("type","custom")
								.field("tokenizer","nori_tokenizer")
								.array("filter",new String[]{
									"nori_posfilter",
									"nori_readingform",
//									"yr_synonym_filter",
//									"yr_stop_filter"
									}
								)
							.endObject()
						.endObject()
						
						.startObject("filter")
							.startObject("nori_posfilter")
							//part of speech는 품사라는 뜻이다 
								.field("type","nori_part_of_speech")
								.array("stoptags",new String[] {
										"E","IC","J","MAG","MM","NA","NR","SC",
										"SE","SF","SH","SL","SN","SP","SSC","SSO",
										"SY","UNA","UNKNOWN","VA","VCN","VCP","VSV",
										"VV","VX","XPN","XR","XSA","XSN","XSV"
									}
								)
							.endObject()
							
//							.startObject("yr_synonym_filter")
//								.field("type","synonym")
//								.field("synonyms_path","synonymsFilter.txt")
//							.endObject()
//							
//							.startObject("yr_stop_filter")
//								.field("type","stop")
//								.field("stopwords_path","stopFilter.txt")
//							.endObject()
						.endObject()
					.endObject()
				.endObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return settings;
	}
	
	public XContentBuilder getWarehouseMapping() {
		XContentBuilder mapping = null;
		try {
		mapping = XContentFactory.jsonBuilder()
				.startObject()
					.startObject("properties")
						.startObject("id")
							.field("type", "keyword") 
						.endObject() 
						.startObject("name") 
							.field("type", "text") 
							.field("index_options", "docs") 
						.endObject() 
						.startObject("address") 
							.field("type", "text") 
							.field("index_options", "docs")
							.field("analyzer", "nori_analyzer")
						.endObject() 
						.startObject("section-count") 
							.field("type", "integer") 
						.endObject() 
						.startObject("stock-count") 
							.field("type", "integer") 
						.endObject() 
						.startObject("capacity-sum") 
							.field("type", "integer") 
						.endObject() 
						.startObject("count-sum") 
							.field("type", "integer") 
						.endObject() 
					.endObject()
				.endObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mapping;
	}
	
	public XContentBuilder getPurchaseAndSaleMapping() {
		XContentBuilder mapping = null;
		try {
		mapping = XContentFactory.jsonBuilder()
				.startObject()
					.startObject("properties")
						.startObject("item-id")
							.field("type", "keyword") 
						.endObject() 
						.startObject("item-name") 
							.field("type", "text") 
							.field("index_options", "docs") 
							.field("analyzer", "nori_analyzer")
						.endObject() 
						.startObject("quantity-purchase") 
							.field("type", "integer") 
						.endObject() 
						.startObject("quantity-sales") 
							.field("type", "integer") 
						.endObject() 
//						.startObject("@timestamp") 
//							.field("type", "date") 
//						.endObject() 
					.endObject()
				.endObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mapping;
	}

	public XContentBuilder getSalesDetailMapping() {
		XContentBuilder mapping = null;
		try {
		mapping = XContentFactory.jsonBuilder()
				.startObject()
					.startObject("properties")
						.startObject("request-id")
							.field("type", "keyword") 
						.endObject() 
						.startObject("begin-date") 
							.field("type", "date")
						.endObject() 
						.startObject("client-name") 
							.field("type", "keyword") 
//							.field("index_options", "docs") 
//							.field("analyzer", "nori_analyzer")
						.endObject() 
						.startObject("item-id") 
							.field("type", "integer") 
						.endObject() 
						.startObject("item-name") 
							.field("type", "keyword") 
//							.field("index_options", "docs") 
//							.field("analyzer", "nori_analyzer")
						.endObject() 
						.startObject("category") 
							.field("type", "keyword") 
	//						.field("index_options", "docs") 
//							.field("analyzer", "nori_analyzer")
						.endObject() 
						.startObject("quantity") 
							.field("type", "integer") 
						.endObject()
						.startObject("profit") 
							.field("type", "integer") 
						.endObject()
					.endObject()
				.endObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mapping;
	}
	
	public void indexWarehouse() {
		RestHighLevelClient client = getClient();

		try {
			List<V_warehouseDto> list = warehouseDao.selectWarehouseList();

			BulkRequest bulkRequest = new BulkRequest();

			int cnt = 0;
			for (V_warehouseDto dto : list) {
				IndexRequest indexRequest = new IndexRequest().index("warehouse")
					.id(String.valueOf(dto.getId()))
					.source(XContentFactory.jsonBuilder()
					.startObject()
						.field("name", dto.getName())
						.field("address", dto.getAddress())
						.field("section_count", dto.getSection_count())
						.field("stock_count", dto.getStock_count())
						.field("capacity_sum", dto.getCapacity_sum())
						.field("count_sum", dto.getCount_sum())
//						.field("cnt", cnt)
//						.field("@timestamp", LocalDateTime.now())
					.endObject());

				//upsert로 index 객체를 전달하여 중복되지 않은 값만 update할 수 있다
				UpdateRequest updateRequest = new UpdateRequest().index("warehouse")
					.id(String.valueOf(dto.getId()))
					.doc(XContentFactory.jsonBuilder()
					.startObject()
						.field("name", dto.getName())
						.field("address", dto.getAddress())
						.field("section_count", dto.getSection_count())
						.field("stock_count", dto.getStock_count())
						.field("capacity_sum", dto.getCapacity_sum())
						.field("count_sum", dto.getCount_sum())
//						.field("cnt", cnt)
//						.field("@timestamp", LocalDateTime.now())
					.endObject())
					.upsert(indexRequest);

				bulkRequest.add(updateRequest);
				cnt++;
			}

			//bulkRequest에는 다중 upsert 요청이 들어있다
			BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);

			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Object indexPurchaseAndSale() {
		RestHighLevelClient client = getClient();
		BulkResponse bulkResponse = null;

		try {
			List<PurchaseAndSaleDto> list = elasticDao.selectPurchaseAndSaleList();

			BulkRequest bulkRequest = new BulkRequest();

			int cnt = 0;
			for (PurchaseAndSaleDto dto : list) {
				IndexRequest indexRequest = new IndexRequest().index("purchase-and-sale")
					.id(String.valueOf(dto.getItem_id()))
					.source(XContentFactory.jsonBuilder()
					.startObject()
						.field("item-id", dto.getItem_id())
						.field("item-name", dto.getItem_name())
						.field("quantity-purchase",dto.getQuantity_purchase())
						.field("quantity-sales", dto.getQuantity_sales())
//						.field("@timestamp", LocalDateTime.now())
					.endObject());

				//upsert로 index 객체를 전달하여 중복되지 않은 값만 update할 수 있다
				UpdateRequest updateRequest = new UpdateRequest().index("purchase-and-sale")
					.id(String.valueOf(dto.getItem_id()))
					.doc(XContentFactory.jsonBuilder()
					.startObject()
						.field("item-id", dto.getItem_id())
						.field("item-name", dto.getItem_name())
						.field("quantity-purchase", dto.getQuantity_purchase())
						.field("quantity-sales", dto.getQuantity_sales())
//						.field("@timestamp", LocalDateTime.now())
					.endObject())
					.upsert(indexRequest);

				bulkRequest.add(updateRequest);
				cnt++;
			}

			//bulkRequest에는 다중 upsert 요청이 들어있다
			bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);

			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			return bulkResponse;
	}

	public Object indexSalesDetail() {
		RestHighLevelClient client = getClient();
		BulkResponse bulkResponse = null;

		try {
			List<SalesDetailDto> list = elasticDao.selectSalesDetailList();

			BulkRequest bulkRequest = new BulkRequest();

			int cnt = 0;
			for (SalesDetailDto dto : list) {
				IndexRequest indexRequest = new IndexRequest().index("sales-detail")
					.id(String.valueOf(dto.getItem_id()))
					.source(XContentFactory.jsonBuilder()
					.startObject()
						.field("request-id", dto.getItem_id())
						.field("begin-date", new Date(dto.getBegin_date().getTime()))
						.field("client-name", dto.getClient_name())
						.field("item-id", dto.getItem_id())
						.field("item-name", dto.getItem_name())
						.field("category", dto.getCategory())
						.field("quantity", dto.getQuantity())
						.field("profit", dto.getProfit())
					.endObject());

				//upsert로 index 객체를 전달하여 중복되지 않은 값만 update할 수 있다
				UpdateRequest updateRequest = new UpdateRequest().index("sales-detail")
					.id(String.valueOf(dto.getItem_id()))
					.doc(XContentFactory.jsonBuilder()
					.startObject()
						.field("request-id", dto.getItem_id())
//						.field("begin-date", dto.getBegin_date())
						.field("begin-date", new Date(dto.getBegin_date().getTime()))
						.field("client-name", dto.getClient_name())
						.field("item-id", dto.getItem_id())
						.field("item-name", dto.getItem_name())
						.field("category", dto.getCategory())
						.field("quantity", dto.getQuantity())
						.field("profit", dto.getProfit())
					.endObject())
					.upsert(indexRequest);

				bulkRequest.add(updateRequest);
				cnt++;
			}

			//bulkRequest에는 다중 upsert 요청이 들어있다
			bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);

			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			return bulkResponse;
	}

	
	private SearchSourceBuilder WarehouseSearchBuilder() {
		SearchSourceBuilder builder = new SearchSourceBuilder();
//		builder.query(QueryBuilders.moreLikeThisQuery(likeTexts, likeItems))
		return builder;
		
	}
	
	
	
//	
//	public XContentBuilder getAssetMapping() {
//		XContentBuilder mapping = null;
//		try {
//		mapping = XContentFactory.jsonBuilder()
//				.startObject()
//					.startObject("properties")
//						.startObject("id")
//							.field("type", "keyword") 
//						.endObject() 
//						.startObject("name") 
//							.field("type", "text") 
//							.field("index_options", "docs") 
//						.endObject() 
//						.startObject("address") 
//							.field("type", "text") 
//							.field("index_options", "docs")
//							.field("analyzer", "nori_analyzer")
//						.endObject() 
//						.startObject("section_count") 
//							.field("type", "integer") 
//						.endObject() 
//						.startObject("stock_count") 
//							.field("type", "integer") 
//						.endObject() 
//						.startObject("capacity_sum") 
//							.field("type", "integer") 
//						.endObject() 
//						.startObject("count_sum") 
//							.field("type", "integer") 
//						.endObject() 
//					.endObject()
//				.endObject();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return mapping;
//	}
	

	public RestHighLevelClient getClient() {
		RestHighLevelClient client = new RestHighLevelClient(
				RestClient.builder(new HttpHost("www.dulgi.xyz", 9200, "http")));
		return client;
	}
	

//	public void createWarehouseIndex() {
//		RestHighLevelClient client = getClient();
//
//		//test
//		//
//		try {
//			CreateIndexRequest createIndexReq = new CreateIndexRequest("warehouse")
////					.settings(Settings.builder())
//					.settings(getCommonIndexSettings())
//					.mapping(getWarehouseMapping());
//						
//			client.indices().create(createIndexReq, RequestOptions.DEFAULT);
//			client.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	public void createPurchaseAndSaleIndex() {
//		RestHighLevelClient client = getClient();
//	
//		try {
//			CreateIndexRequest createIndexReq = new CreateIndexRequest("purchase-and-sale")
//					.settings(getCommonIndexSettings())
//					.mapping(getPurchaseAndSaleMapping());
//						
//			client.indices().create(createIndexReq, RequestOptions.DEFAULT);
//			client.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	public void createIndex(String index, XContentBuilder settings, XContentBuilder mapping) {
		RestHighLevelClient client = getClient();
	
		try {
			CreateIndexRequest createIndexReq = new CreateIndexRequest(index)
//					.settings(getCommonIndexSettings())
//					.mapping(getPurchaseAndSaleMapping());
					.settings(settings)
					.mapping(mapping);
			client.indices().create(createIndexReq, RequestOptions.DEFAULT);
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
////	public Map<String, Object> getWarehouse() {
//	public MultiGetResponse getWarehouseIndex() {
//		BulkRequest bulkRequest = new BulkRequest();
//		RestHighLevelClient client = getClient();
//		GetResponse getResponse = null;
//		MultiGetResponse multiGetResponse = null;
//		CountRequest countRequest = new CountRequest().indices("warehouse");
//		AnalyzeRequest analyzeRequest = AnalyzeRequest.withIndexAnalyzer("warehouse", "nori_analyzer");
//		Map<String, Object> map = null;
////		List<V_warehouseDto> list = new ArrayList<V_warehouseDto>();
//		try {
////			int cnt = new IndexRequest("warehouse").;
//			CountResponse countResponse = client.count(countRequest, RequestOptions.DEFAULT);
//			System.out.println("documets count :" +countResponse.getCount());
//			//Multimap
//			MultiGetRequest multiGetRequest = new MultiGetRequest();
//			for (int i = 1; i<=countResponse.getCount(); i++) {
//			multiGetRequest.add("warehouse", String.valueOf(i));
//			}
//			multiGetResponse = client.mget(multiGetRequest, RequestOptions.DEFAULT);
////			map = multiGetResponse;
////					. getSourceAsMap();
//			//
////			GetRequest getRequest = new GetRequest("warehouse").id("1");
////			getResponse = client.get(getRequest, RequestOptions.DEFAULT);
////			map = getResponse.getSourceAsMap();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				client.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			
//		}
//		
////		return map;
//		return multiGetResponse;
//	}
	
	
//	public MultiGetResponse getPurchaseAndSaleIndex() {
	public MultiGetResponse getAllDoc(String index) {
		BulkRequest bulkRequest = new BulkRequest();
		RestHighLevelClient client = getClient();
		GetResponse getResponse = null;
		MultiGetResponse multiGetResponse = null;
		CountRequest countRequest = new CountRequest().indices(index);
		AnalyzeRequest analyzeRequest = null;
		try {
		analyzeRequest = AnalyzeRequest.withIndexAnalyzer(index, "nori_analyzer");
		} catch (Exception e) {
			System.out.println("alayzer이 없습니다");
		}
		Map<String, Object> map = null;
		try {
			CountResponse countResponse = client.count(countRequest, RequestOptions.DEFAULT);
			System.out.println("documets count :" +countResponse.getCount());
			MultiGetRequest multiGetRequest = new MultiGetRequest();
			for (int i = 1; i<=countResponse.getCount(); i++) {
			multiGetRequest.add(index, String.valueOf(i));
			}
			multiGetResponse = client.mget(multiGetRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return multiGetResponse;
	}
	
	
	public GetResponse getDoc(String index, String docNum) {
		RestHighLevelClient client = getClient();
		AnalyzeRequest analyzeRequest = AnalyzeRequest.withIndexAnalyzer(index, "nori_analyzer");
		GetRequest getRequest = new GetRequest(index, docNum);
		GetResponse getResponse = null;
		try {
			getResponse = client.get(getRequest, RequestOptions.DEFAULT);
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return getResponse;
	}
	
	
	public AnalyzeResponse analyze(String text) {
		AnalyzeRequest analyzeRequest = AnalyzeRequest.withIndexAnalyzer("warehouse", "nori_analyzer", text);
		RestHighLevelClient client = getClient();
		AnalyzeResponse analyzeResponse = null;
		try {
			analyzeResponse = client.indices().analyze(analyzeRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return analyzeResponse;
	}
	
	public SearchResponse search(String text) {
		SearchResponse response = null;
		RestHighLevelClient client = getClient();
//		SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.moreLikeThisQuery(text));
		SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchQuery("address", text));
		SearchRequest request = new SearchRequest().source(builder);
		try {
			response = client.search(request, RequestOptions.DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	
	public void deleteIndex(String index) {
		RestHighLevelClient client = getClient();
		DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(index);
		try {
			client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
