package model;

public class Farm implements Buildings{

	private int lvl;
	private int prodPwr;
	private int workForce;
	private int outPut;
	private int tmfCosts = 20;
	private double taxRate;
	private double taxableIncome = 50;
	private int upgrade = 2;
	private Buildings [][] location;
	private char type;
	
	public Farm() {
		this.setLvl(1);
		this.setProdPwr(2);
		this.setWorkForce(25);
		this.setOutPut(getProdPwr()*getWorkForce());
		this.setTaxRate(.02);
		this.setType('F');
	}
	
	public Farm(Buildings [][] use) {
		this.setLocation(use);
	}

	@Override
	public void increaseLvl(Resource resource) {
		if(resource.subtractResources(tmfCosts*upgrade, tmfCosts*upgrade, tmfCosts*2*upgrade, tmfCosts*upgrade));
		this.setLvl(this.getLvl() + 1);
		
	}

	@Override
	public void productionPwr() {
		this.setProdPwr(this.getProdPwr() + 1);
		
	}
	
	@Override
	public boolean buildIt(Resource resource) {
		return resource.subtractResources(tmfCosts, tmfCosts, tmfCosts*2, tmfCosts);
		
	}

	/////GETTERS AND SETTERS/////
	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public int getProdPwr() {
		return prodPwr;
	}

	public void setProdPwr(int prodPwr) {
		this.prodPwr = prodPwr;
	}

	public int getWorkForce() {
		return workForce;
	}

	public void setWorkForce(int workForce) {
		this.workForce = workForce;
	}

	public int getOutPut() {
		return outPut * this.getLvl();
	}

	public void setOutPut(int outPut) {
		this.outPut = outPut;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	@Override
	public double getTaxMoney(double taxRate) {
		return (taxableIncome*this.getLvl())*taxRate;
	}

	public Buildings [][] getLocation() {
		return location;
	}

	public void setLocation(Buildings [][] location) {
		this.location = location;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}
}