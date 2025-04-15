package com.rest;

public class IplTeams {
	private String teamsName;
	private int tropics;
	private String teamOwner;
	private String teamCaptain;
	
	public IplTeams() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IplTeams(String teamsName, int tropics, String teamOwner, String teamCaptain) {
		super();
		this.teamsName = teamsName;
		this.tropics = tropics;
		this.teamOwner = teamOwner;
		this.teamCaptain = teamCaptain;
	}

	public String getTeamsName() {
		return teamsName;
	}

	public void setTeamsName(String teamsName) {
		this.teamsName = teamsName;
	}

	public int getTropics() {
		return tropics;
	}

	public void setTropics(int tropics) {
		this.tropics = tropics;
	}

	public String getTeamOwner() {
		return teamOwner;
	}

	public void setTeamOwner(String teamOwner) {
		this.teamOwner = teamOwner;
	}

	public String getTeamCaptain() {
		return teamCaptain;
	}

	public void setTeamCaptain(String teamCaptain) {
		this.teamCaptain = teamCaptain;
	}

	@Override
	public String toString() {
		return "IplTeams [teamsName=" + teamsName + ", tropics=" + tropics + ", teamOwner=" + teamOwner
				+ ", teamCaptain=" + teamCaptain + "]";
	}
	
	
	
	
}
