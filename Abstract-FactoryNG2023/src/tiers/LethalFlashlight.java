package tiers;

import lethalCompany.Flashlight;

public class LethalFlashlight implements Flashlight{
	private final static double cost = 50;
	@Override
	public void assemble() {
		System.out.println("LethalFlashlight assembled!");
	}
	@Override
	public double getCost() {
		return cost;
	}
}
