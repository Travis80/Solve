package model;

public class CityResources {

	private City city;
	private double allTaxes;
	private int allTimber;
	private int allMetal;
	private int allFood;
	
	
	public CityResources(City city) {
		this.city = city;
		this.setAllTaxes(0.0);
		this.setAllFood(0);
		this.setAllMetal(0);
		this.setAllTimber(0);
	}
	//population taxes
	public void calTaxes() {
		this.setAllTaxes(0.0);
		for(CivilianBuilding cb : city.getCivBuild()) {
			this.addTaxes(cb.getTaxMoney(cb.getTaxRate()));
		}
		for(Foundry f : city.getFoundry()) {
			this.addTaxes(f.getTaxMoney(f.getTaxRate()));
		}
		for(TimberMill timb : city.getTimbermill()) {
			this.addTaxes(timb.getTaxMoney(timb.getTaxRate()));
		}
		for(Farm f : city.getFarm()) {
			this.addTaxes(f.getTaxMoney(f.getTaxRate()));
		}
	}
	//metal taxes
	public void calFoundBuildRes() {
		this.setAllMetal(0);
		for(Foundry f : city.getFoundry()) {
			this.addMetal(f.getOutPut());
		}
	}
	//wood taxes
	public void calTimbBuildRes() {
		this.setAllTimber(0);
		for(TimberMill timb : city.getTimbermill()) {
			this.addTimber(timb.getOutPut());
		}
	}
	//farm taxes
	public void calFarmBuildRes() {
		this.setAllFood(0);
		for(Farm f : city.getFarm()) {
			this.addFood(f.getOutPut());
		}
	}
	/////GETTERS AND SETTERS/////
	public double getAllTaxes() {
		calTaxes();
		return allTaxes;
	}
	public double setAllTaxes(double allTaxes) {
		return this.allTaxes = allTaxes;
	}
	public double addTaxes(double allTaxes) {
		return this.allTaxes += allTaxes;
	}
	public int getAllMetal() {
		calFoundBuildRes();
		return allMetal;
	}
	public int addMetal(int metal) {
		return this.allMetal += metal;
	}
	public void setAllMetal(int allMetal) {
		this.allMetal = allMetal;
	}
	public int getAllTimber() {
		calTimbBuildRes();
		return allTimber;
	}
	public int addTimber(int timber) {
		return this.allTimber += timber;
	}
	public void setAllTimber(int allTimber) {
		this.allTimber = allTimber;
	}
	public int getAllFood() {
		calFarmBuildRes();
		return allFood;
	}
	public int addFood(int food) {
		return this.allFood += food;
	}
	public void setAllFood(int allFood) {
		this.allFood = allFood;
	}
}
