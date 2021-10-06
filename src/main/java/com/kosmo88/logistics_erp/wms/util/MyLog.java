package com.kosmo88.logistics_erp.wms.util;

import java.util.Map;

public class MyLog {

	public MyLog() {
	}
	
	public static void logParamMap(Map<String, String[]> paramMap) {
     	System.out.println("----파라미터 맵 정보---");
     	paramMap.entrySet().stream().forEach((e)->System.out.println("키 : " + e.getKey() + " 밸류 : " +e.getValue()[0]));
		
	}

}
