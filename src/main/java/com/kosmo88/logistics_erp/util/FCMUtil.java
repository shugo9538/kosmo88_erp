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
    public void sendFCM(String tokenId, String title, String content) {
        FirebaseOptions options;
        try {
            options = FirebaseOptions.builder().setCredentials(GoogleCredentials.getApplicationDefault())
                    .setDatabaseUrl("https://kosmo88erp-38a3c.firebaseio.com/").build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
            
            
            String registrationToken = tokenId;
            
//            Message msg = Message.builder().setAndroidConfig(AndroidConfig.builder()
//                    .setTtl(3600 * 1000)
//                    .setPriority(AndroidConfig.Priority.NORMAL)
//                    .setNotification(AndroidNotification.builder()
//                            .setTag(title)
//                            .setBody(content)
//                            .setIcon("stock_ticker_update")
//                            .setColor("#f45342")
//                            .build())
//                    .build())
//                    .setToken(registrationToken)
//                    .build();
            

            // See documentation on defining a message payload.
            Message message = Message.builder()
                .putData("score", "850")
                .putData("time", "2:45")
                .setToken(registrationToken)
                .build();

            // Send a message to the device corresponding to the provided
            // registration token.
            String response = FirebaseMessaging.getInstance().send(message);
            // Response is a message ID string.
            System.out.println("Successfully sent message: " + response);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        

    }
    
    
    // FCM 발송
//    public void ApprovalRequestAlert(String tokenId, String title, String content)   {
    public static void sendFcm(String content, String tokenPath)   {
        //  메세지 성공여부
    	 String tokenId = "cM39uxMuQ_OAG9iTnxiJWu:APA91bGU2e6qocrIJyWewYHg_KCPvN8a4eC7PtYvn6cb5QDFtGX9GtQRj0iBS-i8OUgc8cVK_g6iensGEHzNN3vMa85nMahUMaZsrhy6xOTnD2YSE1BgfG2mZk_MJ23aaoqC0Q74wodr";
         String title = "KU ERP Kosmo Ultimate ERP";
         
         try {    
        	 
        	 
             // json 파일 경로 입력
//             FileInputStream refreshToken = new FileInputStream("C:\\dev88\\workspace\\kosmo88_erp\\src\\main\\webapp\\resources\\purchase\\json\\kosmo88erp-38a3c-firebase-adminsdk-927z7-f61b2ca066.json");
             FileInputStream refreshToken = new FileInputStream(tokenPath);
             
             FirebaseOptions options = new FirebaseOptions.Builder()
                     .setCredentials(GoogleCredentials.fromStream(refreshToken))
                     .setDatabaseUrl("https://kosmo88erp-38a3c.firebaseio.com")
                     .build();
             
             //Firebase 처음 호출시에만 initializing 처리
             if(FirebaseApp.getApps().isEmpty()) { 
                 FirebaseApp.initializeApp(options);
             }
             //String requestToken = 안드로이드 토큰 입력;
             String requestToken = tokenId;

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
                     .setToken(requestToken)
                     .build();

             // 메세지를 FirebaseMessaging에 보내기
             String response = FirebaseMessaging.getInstance().send(msg);
         }catch(Exception e){
             e.printStackTrace();
         }
     }
}
