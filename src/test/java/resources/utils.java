package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class utils {

	public static RequestSpecification req ; // Static is that the next time the System will consider that the req is null ,, with we don't want ... 
	
	public RequestSpecification requestSpecification() throws IOException { 
		
		RestAssured.baseURI="https://rahulshettyacademy.com"; 
		
		if(req==null)
		{
PrintStream log = new PrintStream(new FileOutputStream("logging.txt")); 

     req = new RequestSpecBuilder().setBaseUri(getGlobalValue()).addQueryParam("key", "qaclick123")
    		 .addFilter(RequestLoggingFilter.logRequestTo(log))
    		 .addFilter(ResponseLoggingFilter.logResponseTo(log))
	.setContentType(ContentType.JSON).build();
     
		return req; 
		
		}
		return req;
	}
	
	
	public static String  getGlobalValue() throws IOException {
		
		Properties prop = new Properties(); 
		
	FileInputStream fis = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\APIFramework\\src\\test\\java\\resources\\global.properties"); 
	prop.load(fis);
	return prop.getProperty("baseURI");
	
	
	}
	
	public String getJsonPath(Response response  , String Key) {
		
		   String resp = response.asString();
		   JsonPath  js = new JsonPath(resp);
		 return (js.get(Key).toString()) ; 
		 
		   

		
		
	}
	
	
	
	
	
	
}
