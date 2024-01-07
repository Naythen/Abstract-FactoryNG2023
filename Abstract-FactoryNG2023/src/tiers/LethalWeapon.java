package tiers;

import lethalCompany.Weapon;

//Concrete component for lethal tier of the component 'Weapon'

public class LethalWeapon implements Weapon{

	private final static double cost = 100;

	public void assemble() {		
		System.out.println("LethalWeapon assembled!");

	}

	@Override
	public double getCost() {
		return cost;
	}

}
