package tiers;

import lethalCompany.Flashlight;
import lethalCompany.LethalCompany;
import lethalCompany.WalkieTalkie;
import lethalCompany.Weapon;

//Concrete factory for pro tier of the components

public class ProTier extends LethalCompany{

	@Override
	public Flashlight createFlashlight() {
		return new ProFlashlight();
	}

	@Override
	public Weapon createWeapon() {
		return new ProWeapon();
	}

	@Override
	public WalkieTalkie createWalkieTalkie() {
		return new ProWalkieTalkie();
	}

}
