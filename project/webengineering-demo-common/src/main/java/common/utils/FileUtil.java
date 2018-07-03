package common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FileUtil {
	public static String getDocumentByURL(String urlString) {
		StringBuffer document = document = new StringBuffer();
		try {
			
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			while((line = reader.readLine())!= null) {
				document.append(line+"/n");
			}
			reader.close();
		}catch (MalformedURLException e) {
			System.out.println("Unable to connect to URL:" + urlString);
		} catch (IOException e) {
			System.out.println("IOException when connecting to URL:" + urlString);
		}
		return document.toString();
	}
}
