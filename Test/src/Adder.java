import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import com.google.gson.Gson;
public class Adder extends Thread{
	
	
	
	public static List<String> GetURLs( String url, String key ) {
			System.out.println("Идет получение URL");
		  
		  List<String> spis = new ArrayList<String>();
		for(int i = 0; i < Main.globArr.length();i++)
		{
			spis.add(Main.globArr.getJSONObject(i).get(key).toString());
		}
		return spis;
		}
	public static List<String> GetOBJ( String url, String key ) {
		System.out.println("Идет получение объекта");
		JSONObject arr = new JSONObject();
		  arr  = Main.jsonGetRequestObject(url);
		  List<String> spis = new ArrayList<String>();
		for(int i = 0; i < arr.length();i++)
		{
			spis.add(Main.jsonGetRequestObject(url).get(key).toString());
		}
		return spis;
		}
	public static List<Cameras> collector()
	{
		
		List<Cameras> arr1 = new ArrayList<Cameras>();
		
		for(int i = 0;i < Main.globArr.length() ;i++)
		{
			arr1.add(new Cameras(Main.globArr.getJSONObject(i).get("id").toString(), 
					GetOBJ(GetURLs("http://www.mocky.io/v2/5c51b9dd3400003252129fb5", "sourceDataUrl").get(i), "urlType").get(0), 
					GetOBJ(GetURLs("http://www.mocky.io/v2/5c51b9dd3400003252129fb5", "sourceDataUrl").get(i), "videoUrl").get(1), 
					GetOBJ(GetURLs("http://www.mocky.io/v2/5c51b9dd3400003252129fb5", "tokenDataUrl").get(i), "value").get(0),  
					GetOBJ(GetURLs("http://www.mocky.io/v2/5c51b9dd3400003252129fb5", "tokenDataUrl").get(i), "ttl").get(1) ));
		}
		
		return arr1;
		
	}
	public static String creator(List<Cameras> a)
	{
		System.out.println("Конвертация в джосн");
		Gson gson = new Gson();
		 String jsonCartList = gson.toJson(a);
		 return jsonCartList;
	}
	
	
}
