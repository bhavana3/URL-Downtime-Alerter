/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.SendMessages.messenger;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
/**
 *
 * @author bhavana
 */
public class messenger {
    
   public static final String ACCOUNT_SID = "AC71c9585bd6fe2a369c482e54ca65b962";
   public static final String AUTH_TOKEN = "abe34ee91d31da6ed157eda6f68a1116";
   
   private String URL;
   private int result;

   public String getURL() {
      return URL;
   }

   public void setURL(String URL) {
      this.URL = URL;
   }

   public int getResult() {
      return result;
   }

   public void setResult(int result) {
      this.result = result;
   }

   public void sendMessage() {
       
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      
    try {
        URL u = new URL (URL);
        HttpURLConnection huc =  ( HttpURLConnection )  u.openConnection (); 
        huc.setRequestMethod ("GET");  //OR  huc.setRequestMethod ("HEAD"); 
        huc.connect () ; 
        int code = huc.getResponseCode() ;
        result = code;
          Message message = Message.creator(
                    new com.twilio.type.PhoneNumber("+16823132373"),
                    new com.twilio.type.PhoneNumber("+12247013668"),
                    "The response code of retreived URL is : "+code)
                .create();

            System.out.println(message.getSid());
    }
    catch(Exception e) {
        e.printStackTrace();
    }
   }

   public void clear(){
      result = -1;
   }
    
}
