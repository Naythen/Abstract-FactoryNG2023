package tiers;

import lethalCompany.Flashlight;
import lethalCompany.LethalCompany;
import lethalCompany.WalkieTalkie;
import lethalCompany.Weapon;

public class LethalTier extends LethalCompany {
	@Override
	public Flashlight createFlashlight() {
		return new LethalFlashlight();
	}

	@Override
	public Weapon createWeapon() {
		return new LethalWeapon();
	}

	@Override
	public WalkieTalkie createWalkieTalkie() {
		return new LethalWalkieTalkie();
	}
}
