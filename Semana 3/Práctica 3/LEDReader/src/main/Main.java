package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Main {

	public static void main(String... strings) {
			Main m = new Main();
	}
	
	public Main() {
		System.out.println( getToURL("https://camara-4a96c.firebaseio.com/LEDS.json") );
	}

	public String getToURL(String site) {
		try {
			URL url = new URL(site);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			String message = "";
			String line = "";
			while ((line = in.readLine()) != null) {
				message += line;
		    }
			in.close();
			return message;
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
}
