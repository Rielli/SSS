package com.sss.MasterController;

public class InternalProblems {
	private static String[] internalproblem;
	private static String[] internalproblemDef;
	public InternalProblems() {
		internalproblem = new String[11];
		internalproblemDef = new String[11];
		internalproblem[0] = "force reload";
		internalproblemDef[0] = "force the gunner to reload causing a pause in the defense, possibly causing them to receive damage or be hit by an projectile.";
		internalproblem[1] = "temp shield removal";
		internalproblemDef[1] = "Temporarily remove the team ship sheild, causing damage dealt by enemies, meteors, ex.. to double the damage.";
		internalproblem[2] = "non-functioning controls";
		internalproblemDef[2] = "pick one of the 3 control stations and choose a specific control that he/she will no longer be able to use until a mini-game has been succesfully completed.";
		internalproblem[3] = "Core Meltdown";
		internalproblemDef[3] = "Cause a sudden burst in the nuclear core tempurature causing a meltdown. This will lead the enginear to a new mini-game.";
		internalproblem[4] = "Power Shortage";
		internalproblemDef[4] = "Cut the power to the whole ship, seting a huge taget to the enemies, also causing another mini-game to be completed to regain power.";
		internalproblem[5] = "Weapon Malfunction";
		internalproblemDef[5] = "Out of all the weapons the weapon controll station has, choose one to tempoarily be disabled/broken.";
		internalproblem[6] = "Screen Cracks";
		internalproblemDef[6] = "More of a visual Effect, give the spaceship window an X amount of cracks added, so make it more dificult to see.";
		internalproblem[7] = "Fuel leak";
		internalproblemDef[7] = "Leak fuel, causing team to be more effient on how they use recources, and cause a nesassary repair mini-game for the enginear.";
		internalproblem[8] = "Hyperjump failure";
		internalproblemDef[8] = "The next time the pilot tries to jump in Hyperdrive, give an error on screen and have a 2 minute cooldown time.";
		internalproblem[9] = "Life Support Failure";
		internalproblemDef[9] = "nothing on this idea yet.";
		internalproblem[10] = "Radiation leak";
		internalproblemDef[10] = "Cause a leak in the neclear core, giving team radiation damage, and causing temporary drift through space untill core has been repaired.";
	}
	public String getInternalProblem(int i) {
		return internalproblem[i];
	}
	public String getDef(int i) {
		return internalproblemDef[i];
	}
}