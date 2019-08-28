import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;


public class Main{
public static JSONArray globArr;


  public static void main(String[] args) {
	  globArr = new JSONArray();
	{
		  globArr = jsonGetRequest("http://www.mocky.io/v2/5c51b9dd3400003252129fb5");
		  System.out.println(Sclass.creator(Sclass.collector()));
	}
  }
  private static String streamToString(InputStream inputStream) {
	    @SuppressWarnings("resource")
		String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
	    return text;
	  }
  public static JSONArray jsonGetRequest(String urlQueryString) {
    String json = null;
    JSONArray jsonObj = null;
    try {
      URL url = new URL(urlQueryString);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setDoOutput(true);
      connection.setInstanceFollowRedirects(false);
      connection.setRequestMethod("GET");
      connection.setRequestProperty("Content-Type", "application/json");
      connection.setRequestProperty("charset", "utf-8");
      connection.connect();
      InputStream inStream = connection.getInputStream();
      json = streamToString(inStream);
      jsonObj = new JSONArray(json);
      connection.disconnect();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return jsonObj;
  }
  public static JSONObject jsonGetRequestObject(String urlQueryString) {
	    String json = null;
	    JSONObject jsonObj = null;
	    try {
	      URL url = new URL(urlQueryString);
	      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	      connection.setDoOutput(true);
	      connection.setInstanceFollowRedirects(false);
	      connection.setRequestMethod("GET");
	      connection.setRequestProperty("Content-Type", "application/json");
	      connection.setRequestProperty("charset", "utf-8");
	      connection.connect();
	      InputStream inStream = connection.getInputStream();
	      json = streamToString(inStream);
	      jsonObj = new JSONObject(json);
	    } catch (IOException ex) {
	      ex.printStackTrace();
	    }
	    return jsonObj;
	  }
 
  
  
  
 

}


