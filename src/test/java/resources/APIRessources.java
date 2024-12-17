package resources;
// APIRessources is a collection of constants and methods... 

public enum APIRessources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json"); 
	
	private String resource;

	APIRessources(String resource)
	{
		this.resource=resource; 
	}
	
	public String getRessource() {
		
		return resource;
		
	}

}
