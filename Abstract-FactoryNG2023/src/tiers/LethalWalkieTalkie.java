package tiers;

import lethalCompany.WalkieTalkie;

public class LethalWalkieTalkie implements WalkieTalkie{
	private final static double cost = 40;

	@Override
	public void assemble() {		
		System.out.println("LethalWalkieTalkie assembled!");

	}

	@Override
	public double getCost() {
		return cost;
	}

}
