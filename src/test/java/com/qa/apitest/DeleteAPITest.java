package com.qa.apitest;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class DeleteAPITest extends TestBase {
	
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
public void Delete() throws ClientProtocolException, IOException {
	RestClient restclient=new RestClient();
	CloseableHttpResponse httpResponse=restclient.Delete(URI);
	
	 int statuscode=httpResponse.getStatusLine().getStatusCode();
	 Assert.assertEquals(statuscode, status_code_204,"Status code is not 204 ");
	 
	 //status code
	   System.out.println("status code----->"+statuscode);







}
}
