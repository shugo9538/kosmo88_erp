/**
 * 
 */


// Initialize the Firebase app in the service worker by passing in
// your app's Firebase config object.
// https://firebase.google.com/docs/web/setup#config-object
const config = {
  apiKey: 'AIzaSyCe1v0Rx9mUvyMXJT3bsFH2va5r5Um2KKM',
  authDomain: 'kosmo88erp-38a3c.firebaseapp.com',
  databaseURL: 'https://kosmo88erp-38a3c.firebaseio.com',
  projectId: 'kosmo88erp-38a3c',
  storageBucket: 'kosmo88erp-38a3c.appspot.com',
  messagingSenderId: '640561878111'
};

//firebase.initializeApp(config);

const messaging= firebase.messaging();
messaging.requestPermission()
.then(function(){
	console.log("Have permission");
	return messaging.getToken();
})