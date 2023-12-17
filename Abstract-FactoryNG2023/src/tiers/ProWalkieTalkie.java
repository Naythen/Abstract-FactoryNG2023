package tiers;

import lethalCompany.WalkieTalkie;

public class ProWalkieTalkie implements WalkieTalkie{
	private final static double cost = 25;

	@Override
	public void assemble() {
		System.out.println("ProWalkieTalkie assembled!");
		
	}

	@Override
	public double getCost() {
		return cost;
	}

}
