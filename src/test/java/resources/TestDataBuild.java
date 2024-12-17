package resources;

import java.util.ArrayList;
import java.util.List;

import POJO.AddPlace;
import POJO.location;

public class TestDataBuild {
	
	public AddPlace addPlacePayload(String name, String language, String address) {
		 
		AddPlace p = new AddPlace(); 
        p.setAccuracy(50);
        p.setAddress(address);
        p.setLanguage(language);
        p.setWebsite("http://google.com");
        p.setName(name);
        p.setPhone_number("(+91) 983 893 3937");

        // Adding types
        List<String> myList = new ArrayList<>();
        myList.add("shoe park");
        myList.add("shop");
        p.setTypes(myList);

        // Setting location
        location l = new location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        
        return p;
	} 
	
	
	public String  deletePlacePayload(String PlaceID) {
		
		return "{\r\n  \"place_id\":\""+PlaceID+"\"\r\n}"; 
		
	}
	
	
	
	

}
