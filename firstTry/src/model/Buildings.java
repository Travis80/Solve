package model;

public interface Buildings {
	
	//increases the building level to have more attributes
	//like increased production speed or population increase
	public void increaseLvl(Resource resource);
	
	//how many resources are produced per tick
	public void productionPwr();
	
	public boolean buildIt(Resource resource);
	
	public int getLvl();

	public void setLvl(int lvl);
	
	public double getTaxMoney(double taxRate);
	
	public char getType();
	
	public void setType(char type);
	
	public void setLocation(Buildings[][] buildings);
	
	public Buildings[][] getLocation();
}
