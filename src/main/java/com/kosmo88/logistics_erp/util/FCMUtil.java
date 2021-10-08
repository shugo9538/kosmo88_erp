package com.kosmo88.logistics_erp.util;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;

public class FCMUtil {
    public void sendFCM(String tokenId, String title, String content) {
        FirebaseOptions options;
        try {
            options = FirebaseOptions.builder().setCredentials(GoogleCredentials.getApplicationDefault())
                    .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/").build();

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
            System.out.println("Successfully sent message: " + message);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
