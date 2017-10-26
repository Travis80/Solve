package controller;

import java.util.*;
import model.City;
import model.CivilianBuilding;
import model.Farm;
import model.Player;
import model.TimberMill;
import model.Foundry;

public class mainStart {

	public static void main(String[] args) {
		System.out.print("Enter your name: ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.print("Enter your first city name: ");
		String cityName = sc.nextLine();
		Player player = new Player(name);
		City city = new City(cityName);
		player.addCity(city);
		String feqs = "";
		for (int i = 1; i <= (player.getName().length()+city.getName().length()); i++) {
			feqs += "=";
		}
		System.out.println("Welcome "+player.getName()+" of "+city.getName()+", to unreal strategy game"
				+ " where you can build troops and resources!");
		System.out.println("==========="+feqs+"==========================="
				+ "=====================================");
		/**
		 * Beginning of game loop
		 */
		while(1 == 1) {
			System.out.println("You have:\n"
					+ player.getResources().getMetal() + " Metal " + player.getCity().getFoundry().size() + "\n"
					+ player.getResources().getTimber() + " Timber " + player.getCity().getTimbermill().size() + "\n"
					+ player.getResources().getFood() + " Food " + player.getCity().getFarm().size() + "\n"
					+ player.getResources().getMoney() + " Money\n");
			System.out.print("What would you like to do?\n1.) Add a building?\n2.) Show Layout?"
					+ "\n3.) Upgrade Building?"+ "\n4.) Quit?\n:");
			String pick = sc.nextLine();
			if(pick.equalsIgnoreCase("quit")) {
				break;
			}
			switch(pick) {
				case "quit":
					break;
				case "1":
					System.out.println("What type?\n1.) Civ\n2.) Foundry\n3.) Timber\n4.) Farm\n");
					String bld = sc.nextLine();
					switch(bld) {
						case "1":
							CivilianBuilding civ = city.addCivBuilding(player.getResources());
							if(civ == null) {
								System.out.println("Insufficient Resources or spaces!");
								break;
							}
							System.out.println("Civilian housing built at " + player.getCity().intString());
							break;
						case "2":
							Foundry foundry = city.addFoundBuilding(player.getResources());
							if(foundry == null) {
								System.out.println("Insufficient Resources or spaces!");
								break;
							}
							System.out.println("Foundry built at " + player.getCity().intString());
							break;
						case "3":
							TimberMill timb = city.addTimbBuilding(player.getResources());
							if(timb == null) {
								System.out.println("Insufficient Resources or spaces!");
								break;
							}
							System.out.println("Timber mill built at " + player.getCity().intString());
							break;
						case "4":
							Farm farm = city.addFarmBuilding(player.getResources());
							if(farm == null) {
								System.out.println("Insufficient Resources or spaces!");
								break;
							}
							System.out.println("Farm built at " + player.getCity().intString());
							break;
					}
					break;
				case "2":
					System.out.println(player.getCity().intString());
					break;
				case "3":
					System.out.println("Specify coordinates for upgrade in format x,y");
					String up = sc.nextLine();
					String [] ugh = up.split(",");
					int x = Integer.parseInt(ugh[0]);
					int y = Integer.parseInt(ugh[1]);
					player.getCity().upGrade(x, y, player.getResources());
					System.out.println("Successfully upgraded");
					break;
				default:
					System.out.println("Unacceptable command");
					break;
			}
			player.getResources().addResources();
		}
		sc.close();
	}
}
