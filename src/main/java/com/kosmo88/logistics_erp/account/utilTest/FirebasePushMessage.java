package com.kosmo88.logistics_erp.account.utilTest;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;

@Component
public class FirebasePushMessage {

	void init() {
		FileInputStream serviceAccount = null;
		try {
			serviceAccount = new FileInputStream("C:\\dev88\\workspace\\kosmo88_erp\\src\\main\\webapp\\resources\\account\\json\\kosmo88erp-38a3c-firebase-adminsdk-927z7-f61b2ca066.json");
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://kosmo88erp-38a3c.firebaseio.com").build();

			FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 특정기기에전송
		void sendMessage() {
			// The topic name can be optionally prefixed with "/topics/".
			String topic = "HighScores";

			
			// See documentation on defining a message payload.
			Message message = Message.builder()
				.putData("kosmo88erp~~~", "리승주리유라림지훈류치훈리재형")
			    .putData("알람아와아라~~~", "도대체 오느냐")
			    .putData("전표승인~~~", "받아라~~")
			    .setTopic(topic)
			    .build();
			
			// Send a message to the devices subscribed to the provided topic.
			String response = null;
			try {
				response = FirebaseMessaging.getInstance().send(message);
			} catch (FirebaseMessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Response is a message ID string.
			
			System.out.println("Successfully sent message: " + response);
		}
		

		public static void main(String[] args) {
			FirebasePushMessage fpm = new FirebasePushMessage();
			fpm.init();
			fpm.sendMessage();
		}
	}
	

