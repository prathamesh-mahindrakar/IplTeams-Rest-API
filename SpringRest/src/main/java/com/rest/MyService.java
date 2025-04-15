package com.rest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	
    @Autowired
    MyDAO myDAO;
	
    public List<IplTeams> getTeams23() throws ClassNotFoundException, SQLException {
    	List<IplTeams> list =  myDAO.getTeams();
		return list;
    }
    
    public String saveIplTeams(IplTeams iplTeams) throws ClassNotFoundException, SQLException {
    	String msgString =  myDAO.insertIplTeams(iplTeams);
    	return msgString;	
    }
    
    public String updateName(String captainName, String teamName) throws ClassNotFoundException, SQLException {
    	String msg =  myDAO.updateTeams(captainName, teamName);
    	return msg;
    }
    
    public String updateIpl(IplTeams iplTeams) throws ClassNotFoundException, SQLException {
    	String msg =  myDAO.updateAll(iplTeams);
    	return msg;
    }
    
    public String deleteTeam(String teamName) throws ClassNotFoundException, SQLException {
    	String msgString = myDAO.deleteTeams(teamName);
		return msgString;
    }
    
}
