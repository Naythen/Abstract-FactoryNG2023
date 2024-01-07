package tiers;

import lethalCompany.Flashlight;

//Concrete component for noob tier of the component 'Flashlight'

public class NoobFlashlight implements Flashlight{
	private final static double cost = 16;

	@Override
	public void assemble() {
		System.out.println("NoobFlashlight assembled!");
	}

	@Override
	public double getCost() {
		return cost;
	}
	
}

