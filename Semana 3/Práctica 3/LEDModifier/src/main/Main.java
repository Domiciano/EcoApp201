package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Main {

	public static void main(String... strings) {
		
		String led1="LOW",led2="LOW",led3="LOW",led4="LOW";
		
		while(true) {
			try {
				URL url = new URL("https://camara-4a96c.firebaseio.com/LEDS.json");
				HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestMethod("PUT");
				
				OutputStream os = connection.getOutputStream();
				
				led1 = isRandomPair()?"HIGH":"LOW";
				led2 = isRandomPair()?"HIGH":"LOW";
				led3 = isRandomPair()?"HIGH":"LOW";
				led4 = isRandomPair()?"HIGH":"LOW";
				
				os.write(("{\"led1\":\""+led1+"\", \"led2\":\""+led2+"\", \"led3\":\""+led3+"\",\"led4\":\""+led4+"\"}").getBytes());
				os.flush();
				os.close();
				
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			    String inputLine;
			    StringBuffer response = new StringBuffer();
	
			    while ((inputLine = in.readLine()) != null) {
			        response.append(inputLine);
			    }
			    in.close();
			    System.out.println(response);
			    
			    Thread.sleep(1000);
				
			}catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} 
		
		 
	}

	private static boolean isRandomPair() {
		boolean isPair = false;
		int random = (int)(1000*Math.random());
		return random%2==0;
	}

}
