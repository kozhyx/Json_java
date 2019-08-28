import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class JTest {

	@Test
	void testArr() {
	
	String b = Main.jsonGetRequest("http://www.mocky.io/v2/5c51b9dd3400003252129fb5").toString();
	String c = String.valueOf(b.charAt(0));
	String d = "[";
	if(!c.equals(d))Assert.fail("Error");
	}
	
	@Test
	void testObj()
	{
		String b = Main.jsonGetRequestObject("http://www.mocky.io/v2/5c51b230340000094f129f5d").toString();
		String c = String.valueOf(b.charAt(0));
		String d = "{";
		if(!c.equals(d))Assert.fail("Error");
	}
	
	
	@Test
	void testGetURLs()
	{
		List<String> a = new ArrayList<String>();
		 Main.globArr = Main.jsonGetRequest("http://www.mocky.io/v2/5c51b9dd3400003252129fb5");
		a = Sclass.GetURLs("http://www.mocky.io/v2/5c51b9dd3400003252129fb5", "sourceDataUrl");
		if(a.size()>4)Assert.fail("Error");
	}
	
	@Test
	void testGetObjs()
	{
		List<String> a = new ArrayList<String>();
		 Main.globArr = Main.jsonGetRequest("http://www.mocky.io/v2/5c51b9dd3400003252129fb5");
		a = Sclass.GetOBJ("http://www.mocky.io/v2/5c51b230340000094f129f5d", "urlType");
		if(a.size()>2)Assert.fail("Error");
	}


}
