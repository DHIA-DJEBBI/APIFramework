package MyStepDef;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

// import org.testng.Assert;

import POJO.AddPlace;
import POJO.location;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIRessources;
import resources.TestDataBuild;
import resources.utils;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class StepDefenition extends utils {

	// Create Global variables 
	
	RequestSpecification res;
	ResponseSpecification respoSpec;
	 Response  response;
	 TestDataBuild data= new TestDataBuild();
	// String  PlaceID;
	JsonPath js ; 
	static String place_id; 
	
	 
	 
	 @Given("Add place Payload with {string} {string} {string}")
	 public void add_place_payload_with(String name, String language, String address) throws IOException {

	 //respoSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build(); 
		 
	 res= given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));
	
	}


	 
	
	 @When("user calls {string} with {string} http request")
	 public void user_calls_with_http_request( String resource , String method) {
	    // Write code here that turns the phrase above into concrete actions
		respoSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		APIRessources  resourcesAPI  = APIRessources.valueOf(resource);
		
		System.out.println(resourcesAPI.getRessource());
		
		if (method.equalsIgnoreCase("Post")) {
			
		   response = res.when()
					.post(resourcesAPI.getRessource())
					.then().spec(respoSpec).extract().response();
		}
		else if (method.equalsIgnoreCase("get")) 
		{response = res.when()
		.get(resourcesAPI.getRessource())
		.then().spec(respoSpec).extract().response();
		}
	
	}

	@Then("the API call is success with staus {int}")
	public void the_api_call_is_success_with_staus(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.getStatusCode() , 200);
		
	    
	}

	@Then("{string} in response is {string}")
	public void in_response_is(String keyValue, String expectedStatus) {
	    // Write code here that turns the phrase above into concrete actions
		
	  assertEquals ( getJsonPath(response, keyValue) , expectedStatus);

	  
	}
	
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String ExpectedName, String ressource) throws IOException {
		
	    // prepare request Spec
		
		 place_id = getJsonPath(response ,"place_id");
	    
		res= given().spec(requestSpecification()).queryParam("place_id", place_id); 
		
		user_calls_with_http_request(ressource , "GET");
		
		String ActualName = getJsonPath(response ,"name");
		
		Assert.assertEquals(ActualName ,ExpectedName );	
		
	}
	
	
	
	
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}
	
	
	
}





