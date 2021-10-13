/**
 * 
 */


import { getMessaging } from "firebase/messaging";

const messaging = getMessaging();


//Add the public key generated from the console here.
messaging.getToken({vapidKey: "BIliZxHxMxkxSabUFZ_EvmBiWIuLCqJs2EC-JLJeSJ_ISRYRIbkqDuxoKATPn3F54GXCLr2s6XrtXARPNuUPV60"});