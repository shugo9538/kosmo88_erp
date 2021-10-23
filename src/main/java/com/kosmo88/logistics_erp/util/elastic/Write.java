//package com.kosmo88.logistics_erp.util.elastic;
//
//import java.util.List;
//
//public class Write {
//
//	public void write(List<? extends T> items) {
//		if(item!=null) {
//			try {
//				List<TbTest01> list = items.stream().map(v->(TbTest01)v).collect(Collectors.toList());
//				RestHighLevelClient client = new RestHighLevelClient(RestClient. builder
//						(new HttpHost("www.dulgi.xyz", 5601, "http")));
//				BulkRequest bulkRequest = new BulkRequest();
//				
//				int cnt = 0;
//				for (Tbtest01 tbTest : list) {
//					System.out.println();
//					IndexRequest indesRequest = new IndexRequest();
//							indesRequest.index("testIndex");
//							indesRequest.id(tbTest01.getCol01());
//				}
//			}
//		}
//	}
//}
