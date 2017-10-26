package model;

import java.util.*;

public class Resource {

	//this class stores all of the resource information
	private int timber;
	private int metal;
	private double money;
	private int food;
	private ArrayList<CityResources> cityresources;
	
	public Resource() {
		//timber metal, money, food
		this.setTimber(75);
		this.setMetal(75) ;
		this.setMoney(150);
		this.setFood(75);
		this.cityresources = new ArrayList<CityResources>();			
	}
	//parameters are costs
	public boolean subtractResources(int timber, int metal, double money, int food) {
		boolean m = false,t = false,f = false,o = false;
		if(money <= this.getMoney()&&metal <= this.getMetal()&&timber <= this.getTimber()&&food <= this.getFood()) {
			o = true;
			this.setMoney(this.getMoney()-money);
			m = true;
			this.setMetal(this.getMetal()-metal);
			t = true;
			this.setTimber(this.getTimber()-timber);
			f = true;
			this.setFood(this.getFood()-food);
		}
		return o && m && t && f;
	}
	
	public void addResources() {
		for (CityResources cr : this.cityresources) {
			this.setMetal(cr.getAllMetal()+this.getMetal());
			this.setFood(cr.getAllFood()+this.getFood());
			this.setMoney(cr.getAllTaxes()+this.getMoney());
			this.setTimber(cr.getAllTimber()+this.getTimber());
		}
	}
	
	public void addCityResource(CityResources cityresource) {
		this.cityresources.add(cityresource);
	}

	//////GETTERS AND SETTERS//////
	public int getTimber() {
		return timber;
	}

	public void setTimber(int timber) {
		this.timber = timber;
	}

	public int getMetal() {
		return metal;
	}

	public void setMetal(int metal) {
		this.metal = metal;
	}
	
	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
}