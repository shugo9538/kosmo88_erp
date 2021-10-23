package com.kosmo88.logistics_erp.util;

import java.io.FileInputStream;

import org.springframework.scheduling.annotation.Async;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;

public class FCMUtil {

	 @Async   // 비동기 어노테이션
	 public int send_FCM(String tokenId, String title, String content) {
		 //  메세지 성공여부
		 int successCnt = 0;
		 String viewPage = "";
	        try {    
	            //본인의 json 파일 경로 입력
	            FileInputStream refreshToken = new FileInputStream("C:\\dev88\\workspace\\kosmo88_erp\\src\\main\\webapp\\resources\\account\\json\\kosmo88erp-38a3c-firebase-adminsdk-927z7-f61b2ca066.json");
	            
	            FirebaseOptions options = new FirebaseOptions.Builder()
	                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
	                    .setDatabaseUrl("https://kosmo88erp-38a3c.firebaseio.com")
	                    .build();
	            
	            //Firebase 처음 호출시에만 initializing 처리
	            if(FirebaseApp.getApps().isEmpty()) { 
	                FirebaseApp.initializeApp(options);
	            }
	            
	            //String registrationToken = 안드로이드 토큰 입력;
	            String registrationToken = tokenId;

	            //message 작성
	            Message msg = Message.builder()
	                    .setAndroidConfig(AndroidConfig.builder()
	                        .setTtl(3600 * 1000) // 1 hour in milliseconds
	                        .setPriority(AndroidConfig.Priority.NORMAL)
	                        .setNotification(AndroidNotification.builder()
	                            .setTitle(title)
	                            .setBody(content)
	                            .setIcon("stock_ticker_update")
	                            .setColor("#f45342")
	                            .build())
	                        .build())
	                    .setToken(registrationToken)
	                    .build();

	            //메세지를 FirebaseMessaging 에 보내기
	            String response = FirebaseMessaging.getInstance().send(msg);
	            //결과 출력
	            
	            if (response != null) {
	            	successCnt = 1;
	            }else {
	            	successCnt= 0;
	            }
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        
	        return successCnt;
	 }

}
