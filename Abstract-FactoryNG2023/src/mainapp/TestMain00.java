package mainapp;

import lethalCompany.Flashlight;
import lethalCompany.LethalCompany;
import lethalCompany.WalkieTalkie;
import lethalCompany.Weapon;
import tiers.LethalTier;
import tiers.NoobTier;
import tiers.ProTier;

public class TestMain00 {

	public static void main(String[] args) {
		LethalCompany noob = new NoobTier();
		Flashlight noobFlashlight = noob.createFlashlight();
		noobFlashlight.assemble();
		Weapon noobWeapon = noob.createWeapon();
		noobWeapon.assemble();
		WalkieTalkie noobWalkieTalkie = noob.createWalkieTalkie();
		noobWalkieTalkie.assemble();

		LethalCompany pro = new ProTier();
		Flashlight ProFlashlight = pro.createFlashlight();
		ProFlashlight.assemble();
		Weapon ProWeapon = pro.createWeapon();
		ProWeapon.assemble();
		WalkieTalkie ProWalkieTalkie = pro.createWalkieTalkie();
		ProWalkieTalkie.assemble();
		
		LethalCompany lethal = new LethalTier();
		Flashlight LethalFlashlight = lethal.createFlashlight();
		LethalFlashlight.assemble();
		Weapon LethalWeapon = lethal.createWeapon();
		LethalWeapon.assemble();
		WalkieTalkie LethalWalkieTalkie = lethal.createWalkieTalkie();
		LethalWalkieTalkie.assemble();
	}

}
