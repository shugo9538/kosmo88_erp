package com.kosmo88.logistics_erp.wms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.indices.AnalyzeResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo88.logistics_erp.wms.dao.ElasticDao;
import com.kosmo88.logistics_erp.wms.dto.PurchaseAndSaleDto;
import com.kosmo88.logistics_erp.wms.service.ElasticService;

@RequestMapping("/es")
@Controller
public class ElasticContoller {

	@Autowired
	ElasticService elasticService;



}

@RestController
@RequestMapping("/es")
class ElasticRestController {

	@Autowired
	ElasticDao elasticDao;
	@Autowired
	ElasticService elasticService;
	
	
//	//Create Index
//	@RequestMapping("/warehouse/create")
//	public void createIndex() {
//		elasticService.createWarehouseIndex();
//	}	
//	@RequestMapping("/purchase-and-sale/create")
//	public void createItemTaxStatusIndex() {
//		elasticService.createPurchaseAndSaleIndex();
//	}
	
	@RequestMapping("/{index}/create")
	public void createIndex(@PathVariable String index) {
		XContentBuilder mapping = null;
		switch(index) {
		case "purchase-and-sale":mapping = elasticService.getPurchaseAndSaleMapping();break;
		case "warehouse":mapping = elasticService.getWarehouseMapping();break;
		case "sales-detail":mapping = elasticService.getSalesDetailMapping();break;
		default:System.out.println("잘못된 index입니다");
		}
		elasticService.createIndex(index, elasticService.getCommonIndexSettings(), mapping);
	}
	
	@RequestMapping("/{index}/index")
	public void indexWarehouse(@PathVariable String index) {
		elasticService.indexWarehouse();
		switch(index) {
		case "purchase-and-sale" : elasticService.indexPurchaseAndSale();break;
		case "warehouse" : elasticService.indexWarehouse();break;
		case "sales-detail" : elasticService.indexSalesDetail();break;
		default:System.out.println("잘못된 index입니다");
		}
	}

	
//	@RequestMapping("/Warehouse/index")
//	public void indexWarehouse(HttpServletRequest req) {
//		elasticService.indexWarehouse();
//	}


	

	@RequestMapping("/purchase-and-sale/index")
	public void indexPurchaseAndSale(HttpServletRequest req) {
		elasticService.indexPurchaseAndSale();
	}

	



	
	@RequestMapping("/{index}/_doc/all")
	public MultiGetResponse getAllDoc(@PathVariable String index) {
		return elasticService.getAllDoc(index);
	}

	@RequestMapping("/{index}/_doc/{docNum}")
	public GetResponse getDoc(@PathVariable String index, @PathVariable String docNum) {
		return elasticService.getDoc(index, docNum);
	}

	
	@RequestMapping("/search")
	public SearchResponse search(HttpServletRequest req) {
//		String[] text = {"금천구"};
		String text = req.getParameterValues("text")[0];
		return elasticService.search(text);
	}
	
	@RequestMapping("/{index}/delete")
	public void deleteIndex(@PathVariable String index) {
		elasticService.deleteIndex(index);
		
	}
	
	//test
	@ResponseBody
	@RequestMapping("/analyze")
	public AnalyzeResponse analyze() {
		String text = "힘든 시간을 견뎌내다 보면 언젠가는 좋은 날도 오지 않겠니";
		return elasticService.analyze(text);
	}

}
