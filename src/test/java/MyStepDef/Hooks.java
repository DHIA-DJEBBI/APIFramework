package MyStepDef;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace") 
	
	public void beforeScenario() throws IOException
	{
		// Code that will give the Place ID ... 
		StepDefenition m = new StepDefenition(); 
		
		if (StepDefenition.place_id == null) {
			m.add_place_payload_with("Dhia", "Arabic", "Tunisia");
			m.user_calls_with_http_request("AddPlaceAPI", "POST");
			m.verify_place_id_created_maps_to_using("Dhia", "getPlaceAPI"); 		
		}
	}

}
