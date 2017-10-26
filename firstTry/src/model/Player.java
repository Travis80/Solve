package model;
//
//import java.util.*;

public class Player {

	private String name;
	//number of cities
	//buildings and population should be a property of cities
	//private ArrayList <City> city;
	private City city;
	private Resource resources;
	
	public Player(String name) {
		this.setName(name);
		//this.city = new ArrayList<City>();
		this.setResources(new Resource());
	}
	
	public void addCity(City city) {
		this.city = city;
		this.resources.addCityResource(city.getCityresources());
	}
	
	////////GETTERS AND SETTERS/////
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public City getCity() {
		return this.city;
	}

	public Resource getResources() {
		return resources;
	}

	public void setResources(Resource resources) {
		this.resources = resources;
	}
}
