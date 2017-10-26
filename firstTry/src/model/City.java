package model;

import java.util.*;

public class City {

	private String name;
	private int totalBuildings = 0;
	private ArrayList<CivilianBuilding> civBuild;
	private ArrayList<Foundry> foundry;
	private ArrayList<TimberMill> timbermill;
	private ArrayList<Farm> farm;
	private CityResources cityresources;
	private Buildings [][] citySize;
	private Farm garbage;
	
	//maybe change this to a building object
	//the idea for this is to get rid of the arrayLists and have a definite city size
	//so that everything is store in specific locations and can be accessed as such
	//through the findBuilding function I need to add. Nothing much should change except
	//fillSpot and and upGrade to account for a different array type
	
	public City(String name) {
		this.setName(name);
		this.civBuild = new ArrayList<CivilianBuilding>();
		this.foundry = new ArrayList<Foundry>();
		this.timbermill = new ArrayList<TimberMill>();
		this.farm = new ArrayList<Farm>();
		this.setCityresources(new CityResources(this));
		this.setCitySize(new Buildings[3][3]);
		set2zero();
	}
	
	public void upGrade(int x, int y, Resource resource) {
		Buildings [][] other = this.getCitySize();
		other[x][y].increaseLvl(resource);
	}
	
	public CivilianBuilding addCivBuilding(Resource resource) {
		CivilianBuilding civBuild = new CivilianBuilding();
		fillSpot(civBuild);
		if(civBuild.buildIt(resource)&&civBuild.getLocation()!=null) {
			this.civBuild.add(civBuild);
			totalBuildings++;
			return civBuild;
		}
		else {
			demoBuilding(civBuild);
			return null;
		}
	}
	
	public Foundry addFoundBuilding(Resource resource) {
		Foundry fdy = new Foundry();
		fillSpot(fdy);
		if(fdy.buildIt(resource)&&fdy.getLocation()!=null) {
			this.foundry.add(fdy);
			totalBuildings++;
			return fdy;
		}
		else {
			demoBuilding(fdy);
			return null;
		}
	}
	
	public TimberMill addTimbBuilding(Resource resource) {
		TimberMill timb = new TimberMill();
		fillSpot(timb);
		if(timb.buildIt(resource)&&timb.getLocation()!=null) {
			this.timbermill.add(timb);
			totalBuildings++;
			return timb;
		}
		else {
			demoBuilding(timb);
			return null;
		}
	}
	
	public Farm addFarmBuilding(Resource resource) {
		Farm farm = new Farm();
		fillSpot(farm);
		if(farm.buildIt(resource)&&farm.getLocation()!=null) {
			this.farm.add(farm);
			totalBuildings++;
			return farm;
		}
		else {
			demoBuilding(farm);
			return null;
		}
	}
	
	public Buildings [][] fillSpot(Buildings ch){
		Buildings [][] useme = this.getCitySize();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(useme[i][j] == garbage) {// need to fill the Buildings array with something
					useme[i][j] = ch;
					this.setCitySize(useme);
					ch.setLocation(useme);
					return useme;
				}
			}
		}
		return null;
	}
	
	public void set2zero() {
		Buildings [][] setToZero = this.getCitySize();
		this.garbage = new Farm();
		this.garbage.setType('N');
		for(int i = 0; i < 3;i++) {
			for(int j = 0; j < 3; j++) {
				setToZero[i][j] = this.garbage;
			}
		}
		this.setCitySize(setToZero);
	}
	
	////////GETTERS AND SETTERS/////////
	public ArrayList<CivilianBuilding> getCivBuild() {
		return civBuild;
	}

	public void setCivBuild(ArrayList<CivilianBuilding> civBuild) {
		this.civBuild = civBuild;
	}

	public ArrayList<Foundry> getFoundry() {
		return foundry;
	}

	public void setFoundry(ArrayList<Foundry> foundry) {
		this.foundry = foundry;
	}

	public ArrayList<TimberMill> getTimbermill() {
		return timbermill;
	}

	public void setTimbermill(ArrayList<TimberMill> timbermill) {
		this.timbermill = timbermill;
	}

	public ArrayList<Farm> getFarm() {
		return farm;
	}

	public void setFarm(ArrayList<Farm> farm) {
		this.farm = farm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void demoBuilding(Buildings building) {
		building = null;
	}

	public int getTotalBuildings() {
		return totalBuildings;
	}

	public void setTotalBuildings() {
		this.totalBuildings = totalBuildings+1;
	}

	public CityResources getCityresources() {
		return cityresources;
	}

	public void setCityresources(CityResources cityresources) {
		this.cityresources = cityresources;
	}

	public Buildings [][] getCitySize() {
		return citySize;
	}

	public void setCitySize(Buildings [][] citySize) {
		this.citySize = citySize;
	}
	
	public String intString() {
		Buildings [][] use = this.getCitySize();
		String line = "\n";
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				line += use[i][j].getType() + " ";
				}
			line += "\n";
			}
		return line;
		}
	}
