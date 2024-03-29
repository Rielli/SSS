package com.sss.MasterController;

public class Enemies {
	private static String[] enemies;
	private static String[] enemiesDef;
	public Enemies() {
		enemies = new String[17];
		enemiesDef = new String[17];
		enemies[0] = "Cruiser";
		enemiesDef[0] = "nothing on the Cruiser yet.";
		enemies[1] = "Stealth Ship";
		enemiesDef[1] =  "nothing on the Stealth Ship yet.";
		enemies[2] = "Bomber";
		enemiesDef[2] =  "nothing on the Bomber yet.";
		enemies[3] = "Shuttle";
		enemiesDef[3] =  "nothing on the Shuttle yet.";
		enemies[4] = "Battle Cruiser";
		enemiesDef[4] =  "nothing on the Battle Cruiser yet.";
		enemies[5] = "Frigate";
		enemiesDef[5] =  "nothing on the Frigate yet.";
		enemies[6] = "Destroyer";
		enemiesDef[6] =  "nothing on the Destroyer yet.";
		enemies[7] = "Dreadnaught";
		enemiesDef[7] =  "nothing on the Dreadnaught yet.";
		enemies[8] = "Assault Ship";
		enemiesDef[8] =  "nothing on the Assualt Ship yet.";
		enemies[9] = "Intercepter";
		enemiesDef[9] =  "nothing on the Intercepter yet.";
		enemies[10] = "Recon Ship";
		enemiesDef[10] =  "nothing on the Recon Ship yet.";
		enemies[11] = "Command Ship";
		enemiesDef[11] =  "nothing on the Command Ship yet.";
		enemies[12] = "Battle Ship";
		enemiesDef[12] =  "nothing on the Battle Ship yet.";
		enemies[13] = "Transporter Ship";
		enemiesDef[13] =  "nothing on the Transporter Ship yet.";
		enemies[14] = "Heavy Assault Ship";
		enemiesDef[14] =  "nothing on the Heavy Assault Ship yet.";
		enemies[15] = "Hostile Space Station";
		enemiesDef[15] =  "nothing on the Hostile Space Station yet.";
		enemies[16] = "The Mothership";
		enemiesDef[16] =  "nothing on the Mothership yet.";
	}
	public String getEnemy(int i) {
		return enemies[i];
	}
	public String getDef(int i) {
		return enemiesDef[i];
	}
}
