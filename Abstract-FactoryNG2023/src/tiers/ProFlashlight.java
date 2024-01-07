package tiers;

import lethalCompany.Flashlight;

//Concrete component for pro tier of the component 'Flashlight'

public class ProFlashlight implements Flashlight{
	private final static double cost = 36;

	@Override
	public void assemble() {
		System.out.println("ProFlashlight assembled!");
		
	}

	@Override
	public double getCost() {
		return cost;
	}
	
}
