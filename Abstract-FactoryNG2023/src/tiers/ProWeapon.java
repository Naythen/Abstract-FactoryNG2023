package tiers;

import lethalCompany.Weapon;

//Concrete component for pro tier of the component 'Weapon'

public class ProWeapon implements Weapon{

	private final static double cost = 50;

	public void assemble() {
		System.out.println("ProWeapon assembled!");
		
	}

	@Override
	public double getCost() {
		return cost;
	}

}
