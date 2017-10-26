package model;

public class CivilianBuilding implements Buildings{

	private int lvl;
	private int population;	
	private int tmfCosts = 5;
	private double taxRate;
	private int upgrade = 2;
	private Buildings [][] location;
	private char type;
	
	public CivilianBuilding() {
		this.setLvl(1);
		this.setPopulation(50);
		this.setTaxRate(0.02);
		this.setType('C');
	}
	
	public CivilianBuilding(Buildings[][] cs) {
		this.setLocation(cs);
	}

	@Override
	public void increaseLvl(Resource resource) {
		if(resource.subtractResources(tmfCosts*upgrade, tmfCosts*upgrade, tmfCosts*2*upgrade, tmfCosts*upgrade));
			this.setLvl(this.getLvl() + 1);
	}

	@Override
	public void productionPwr() {
		return;
	}
	
	@Override
	public boolean buildIt(Resource resource) {
		return resource.subtractResources(tmfCosts, tmfCosts, tmfCosts*2, tmfCosts);
		
	}
	
	//////GETTERS AND SETTERS//////
	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population * getLvl();
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	@Override
	public double getTaxMoney(double taxRate) {
		return (this.getPopulation()*this.getLvl()) * taxRate;
	}

	public Buildings [][] getLocation() {
		return location;
	}

	public void setLocation(Buildings[][] buildings) {
		this.location = buildings;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}
}
