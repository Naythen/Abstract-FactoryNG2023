package tiers;

import lethalCompany.Weapon;

public class NoobWeapon implements Weapon{

	private final static double cost = 25;

	public void assemble() {
		System.out.println("NoobWeapon assembled!");
		
	}

	@Override
	public double getCost() {
		return cost;
	}

}
