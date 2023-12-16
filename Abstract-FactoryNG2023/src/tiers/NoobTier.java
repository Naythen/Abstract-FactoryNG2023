package tiers;

import lethalCompany.Flashlight;
import lethalCompany.LethalCompany;
import lethalCompany.WalkieTalkie;
import lethalCompany.Weapon;

public class NoobTier extends LethalCompany{

	@Override
	public Flashlight createFlashlight() {
		return new NoobFlashlight();
	}

	@Override
	public Weapon createWeapon() {
		return new NoobWeapon();
	}

	@Override
	public WalkieTalkie createWalkieTalkie() {
		return new NoobWalkieTalkie();
	}

}
