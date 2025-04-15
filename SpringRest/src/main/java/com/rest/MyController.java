package com.rest;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyController {
	
	@Autowired
	MyService service;
	
	@GetMapping("/ipl")
	public List<IplTeams> getIPL() throws ClassNotFoundException, SQLException {
		List<IplTeams> iplTeams = service.getTeams23();
		return iplTeams;
	}
	
	@PostMapping("/ipl")
	public String insertTeams(@RequestBody IplTeams iplTeams) throws ClassNotFoundException, SQLException {
		String msg= service.saveIplTeams(iplTeams);
		return msg;
	}
	
	@PutMapping("/ipl/{captainName}/{TeamName}")
	public String updateCaptain(@PathVariable String captainName,@PathVariable String TeamName) throws ClassNotFoundException, SQLException {
		String msg = service.updateName(captainName, TeamName);
		
		return msg;	
	}
	
	@PutMapping("/ipl")
	public String updateAllTeams(@RequestBody IplTeams iplTeams) throws ClassNotFoundException, SQLException {
		String msg = service.updateIpl(iplTeams);
		
		return msg;	
	}
	
	@DeleteMapping("/ipl/{teamName}")
	public String deleteTeamByName(@PathVariable String teamName) throws ClassNotFoundException, SQLException {
		String msgString = 	service.deleteTeam(teamName);
		return msgString;
	}
	
}
