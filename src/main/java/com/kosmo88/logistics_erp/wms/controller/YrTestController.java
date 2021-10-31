package com.kosmo88.logistics_erp.wms.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosmo88.logistics_erp.util.FCMUtil;
import com.kosmo88.logistics_erp.wms.dao.WarehouseDao;
import com.kosmo88.logistics_erp.wms.dto.V_warehouseDto;

@Controller
@RequestMapping("/test")
public class YrTestController {
	@Autowired
	WarehouseDao warehouseDao;

	public YrTestController() {
	}

	@RequestMapping("/yrTest")
	public String testPage() {
		return "wms/testPage";
	}

	@RequestMapping("/yrTest2")
	public String testPage2() {
		return "wms/testPage2";
	}

	@ResponseBody
	@RequestMapping("/fcmTest")
	public void fcmtest(HttpServletRequest req) {
		FCMUtil.sendFcm("ㅊ ㅣ 훈님 뭐하세용", req.getServletContext().getRealPath("/WEB-INF/classes/fcm/fcmToken.json"));
	}

}
