package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	public Properties prop;
	public int status_code_200=200;
	public int status_code_201=201;
	public int status_code_204=204;
	public	int status_code_500=500;
	public	int status_code_404=404;
	
	
	
	public TestBase(){
		prop=new Properties();
		FileInputStream ip = null;
		try {
			ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
