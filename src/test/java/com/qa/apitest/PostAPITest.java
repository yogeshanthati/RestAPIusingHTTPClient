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
import com.qa.util.TestUtil;

public class PostAPITest extends TestBase {
	
TestBase testbase;
String URI;



	@BeforeMethod
	public void setUp(){
		testbase= new TestBase();
		String URL=prop.getProperty("URL");
		String serviceURL=prop.getProperty("ServiceURL");
		//https://reqres.in/api/users
		 URI=URL+serviceURL;
	}
	
	
	@Test
	public void Post() throws ClientProtocolException, IOException {
		RestClient restclient=new RestClient();
		HashMap <String,String> headermap=new HashMap<String,String>();
		headermap.put("Content-Type", "application/json; charset=utf-8");
		//jackson API:
		ObjectMapper mapper=new ObjectMapper();
		Users users = new Users("morpheus", "leader");
		
		//converting java object to json
		mapper.writeValue(new File("./src/main/java/com/qa/data/user.json"), users);
		String jsonString=mapper.writeValueAsString(users);
	   //post request	
		 CloseableHttpResponse httpResponse=restclient.Post(URI,jsonString,headermap);
		 
		 int statuscode=httpResponse.getStatusLine().getStatusCode();
		 Assert.assertEquals(statuscode, status_code_201,"Status code is not 201 ");
		 
		 //status code 
		 System.out.println("status code----->"+statuscode);
		 String strResponse=EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
		 
		  System.out.println(strResponse);
		  JSONObject jsonResponse=new JSONObject(strResponse);
		  System.out.println(jsonResponse);
		  //json to java 
		  
		 Users usersResobj= mapper.readValue(strResponse, Users.class);
		 System.out.println(usersResobj.getId());
		 System.out.println(usersResobj.getCreatedAt());
		 System.out.println(users.getName());
		 System.out.println(users.getJob());
		
		//	Assert.assertTrue(users.getName().equals(usersResobj.getName()));
		//	Assert.assertTrue(users.getJob().equals(usersResobj.getJob()));
			
	
		  
		  
		
		 
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	}
}
