package com.sss.MasterController;

public class Events {
	private static String[] event;
	private static String[] eventDef;
	public Events() {
		event = new String[5];
		eventDef = new String[5];
		event[0] = "Enemy Health Gain";
		eventDef[0] = "Give any ship near the teams ship an X amount of health to mess with your team.";
		event[1] = "Solar Storm";
		eventDef[1] = "Randomly generate a Solar Store to inflict damage apon the team ship.";
		event[2] = "Meteor Shower";
		eventDef[2] = "Spawn a storm of meteors to hurtle towards the team ship, the will probably have to dodge or destroy them.";
		event[3] = "Black Hole";
		eventDef[3] = "Create a black hole that expands exponentialy and will have an X amount of pull force. The higher the pull force, the more difficult it will be to avoid.";
		event[4] = "Worm Hole";
		eventDef[4] = "Create a worm hole that expands exponentialy. This worm hole can send the team ship to a random location in the galaxy and will close after exit.";
	}
	public String getEvent(int i) {
		return event[i];
	}
	public String getDef(int i) {
		return eventDef[i];
	}
}