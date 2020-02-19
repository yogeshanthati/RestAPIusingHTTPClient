package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {

	//calling get method without  headers
	
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
	CloseableHttpClient httpclient=HttpClients.createDefault();
	HttpGet httpget=new HttpGet(url);
	CloseableHttpResponse httpresponse=httpclient.execute(httpget);
	return httpresponse;
	
}
	
	//calling get method with headers
	
	public CloseableHttpResponse Get(String url,HashMap<String,String> hashmap) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		
		for(Map.Entry<String, String> he:hashmap.entrySet()) {
			httpget.addHeader(he.getKey(), he.getValue());
			
		}
		
		CloseableHttpResponse httpresponse=httpclient.execute(httpget);
		
		return httpresponse;
		
	}
		
	
	//calling Post method with headers
	public CloseableHttpResponse Post(String url,String jsonString,HashMap<String,String> hashmap) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpPost httppost=new HttpPost(url);
		
		for(Map.Entry<String, String> he:hashmap.entrySet()) {
			httppost.addHeader(he.getKey(), he.getValue());
			
		}
		
		CloseableHttpResponse httpresponse=httpclient.execute(httppost);
		
		return httpresponse;
		
	}
	
public CloseableHttpResponse Put(String url,String jsonString,HashMap<String,String> hashmap) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpPut httpput=new HttpPut(url);
		
		for(Map.Entry<String, String> he:hashmap.entrySet()) {
			httpput.addHeader(he.getKey(), he.getValue());
			
		}
		
		CloseableHttpResponse httpresponse=httpclient.execute(httpput);
		
		return httpresponse;	
	}
	
	
public CloseableHttpResponse Delete(String url) throws ClientProtocolException, IOException {
	
CloseableHttpClient httpclient=HttpClients.createDefault();
HttpDelete httpdelete=new HttpDelete(url);
CloseableHttpResponse httpresponse=httpclient.execute(httpdelete);
return httpresponse;

}



	
}

 
 