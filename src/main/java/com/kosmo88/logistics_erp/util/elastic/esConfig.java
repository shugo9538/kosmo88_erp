package com.kosmo88.logistics_erp.util.elastic;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class esConfig {

	private String hostName = "www.dulgi.xyz";
//	private String hostName = "http://www.dulgi.xyz";
	private Integer port = 9200;

	private String alterHostName = "www.dulgi.xyz";
	private Integer alterPort = 9300;
	
	@Bean
	public RestHighLevelClient getClient() {
		RestHighLevelClient client = new RestHighLevelClient(
				RestClient.builder(new HttpHost(hostName, port, "http"), new HttpHost(alterHostName, alterPort, "http")));
		return client;
	}

}
