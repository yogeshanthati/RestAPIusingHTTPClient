package com.qa.apitest;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;

public class GetAPITest extends TestBase {

	TestBase testbase;
	       String URI;
	@BeforeMethod
	public void setUp(){
		testbase= new TestBase();
		String URL=prop.getProperty("URL");
		String serviceURL=prop.getProperty("ServiceURL");
		 URI=URL+serviceURL;
	}
	
	@Test
	public void Get() throws ClientProtocolException, IOException {
		RestClient restclient=new RestClient();
		HashMap <String,String> hashmap=new HashMap<String,String>();
		hashmap.put("Content-Type", "application/json; charset=utf-8");
		
	//  hashmap.put("username", "yogesh123");
	//	hashmap.put("passqword", "yogesh_123");Invalid entries
	//  hashmap.put("TokenKey", "yog123");
		
		//with headers
		CloseableHttpResponse httpResponse=restclient.Get(URI, hashmap);
		
	//without headers.
	//	CloseableHttpResponse httpResponse=restclient.get(URI);
		
		 int statuscode=httpResponse.getStatusLine().getStatusCode();
		 Assert.assertEquals(statuscode, status_code_200,"Status code is not 200 ");
		 
		 //status code
		   System.out.println("status code----->"+statuscode);
		  
		  String strResponse=EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
		  JSONObject responseJsonbj=new JSONObject(strResponse);
		  System.out.println(responseJsonbj);
		  //check the validation in.....>www.jsonlite.com
		  
		  //single json  value fetching:
		  String perpageValue=TestUtil.getValueByJPath(responseJsonbj, "/per_page");
		  System.out.println(perpageValue);
		  Assert.assertEquals(Integer.parseInt(perpageValue),6);
		  
		  //Array json value fetching:last_name
		  
		  String first_name_0=TestUtil.getValueByJPath(responseJsonbj, "/data[0]/first_name");
		  System.out.println(first_name_0);
		  String last_name_0=TestUtil.getValueByJPath(responseJsonbj, "/data[0]/last_name");
		  System.out.println(last_name_0);
		  
		  
		  String first_name_1=TestUtil.getValueByJPath(responseJsonbj, "/data[1]/first_name");
		  System.out.println(first_name_1);
		  String last_name_1=TestUtil.getValueByJPath(responseJsonbj, "/data[1]/last_name");
		  System.out.println(last_name_1);
		  
		  String first_name_2=TestUtil.getValueByJPath(responseJsonbj, "/data[2]/first_name");
		  System.out.println(first_name_2);
		  String last_name_2=TestUtil.getValueByJPath(responseJsonbj, "/data[2]/last_name");
		  System.out.println(last_name_2);
		  
		  String first_name_3=TestUtil.getValueByJPath(responseJsonbj, "/data[3]/first_name");
		  System.out.println(first_name_3);
		  String last_name_3=TestUtil.getValueByJPath(responseJsonbj, "/data[3]/last_name");
		  System.out.println(last_name_3);
		  
		  //fetch headers
		  Header[] headersArray =httpResponse.getAllHeaders(); 
		  
		  HashMap<String,String>headerMap= new HashMap<String,String>();
		  
		  for(Header header:headersArray) { 
			  headerMap.put(header.getName(),  header.getValue()); 
		  }
		  System.out.println("All the headers---->"+headerMap); 
	}
	
}
