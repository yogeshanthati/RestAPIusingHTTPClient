package com.qa.apitest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Users;

public class PutAPITest extends TestBase {
	
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
	public void Put() throws ClientProtocolException, IOException {
		RestClient restclient=new RestClient();
		HashMap <String,String> headermap=new HashMap<String,String>();
		headermap.put("Content-Type", "application/json; charset=utf-8");
		
		ObjectMapper mapper=new ObjectMapper();
		Users users = new Users("yogesh", "AutTester");
		
		
		//converting java object to json
		mapper.writeValue(new File("./src/main/java/com/qa/data/user.json"), users);
		String jsonString=mapper.writeValueAsString(users);
	
	//post request	
		
		 CloseableHttpResponse httpResponse=restclient.Put(URI,jsonString,headermap);
		 int statuscode=httpResponse.getStatusLine().getStatusCode();
	
		Assert.assertEquals(statuscode, status_code_200,"Status code is not 200 ");
		 
		 //status code
		   System.out.println("status code----->"+statuscode);
		
		  String strResponse=EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
		  
		  JSONObject responseJson=new JSONObject(strResponse);
		  
		  System.out.println(responseJson);
		  
		  //json to java 
		 Users usersResobj= mapper.readValue(strResponse, Users.class);

	
			System.out.println(usersResobj.getUpdatedAt());
		  
		  
		
		 
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	}
}
