package com.kosmo88.logistics_erp.util.elastic;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class Test {

	private void test() {
		//RestHighLevelClient는 RestClientBuiler 객체를 넣어 생성한다
		//RestClientBuilder 객체는 ttpHost 객체를 넣어서 생성한다
		// HttpHost 객체에는 host domain, port, 통신 방식이 들어간다
		RestHighLevelClient client = new RestHighLevelClient(
				RestClient.builder(new HttpHost("www.dulgi.xyz", 5601, "http")));

		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
