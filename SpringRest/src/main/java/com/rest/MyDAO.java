package com.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MyDAO {
    

    public List<IplTeams> getTeams() throws ClassNotFoundException, SQLException { // Fixed method name
    	
    	List<IplTeams> list = new ArrayList<>();
    	
    	Connection connection = DBConnect.getDBConn();
    	
    	Statement statement = connection.createStatement();
    	ResultSet rSet = statement.executeQuery("SELECT * FROM iplteams");
    	
    	while(rSet.next()) {
    		String teamName =  rSet.getString("teamsName");
    		int tropics =	rSet.getInt("tropics");
    		String teamOwner = rSet.getString("teamOwner");
    		String teamCaptain = rSet.getString("teamCaptain");
    		
    		IplTeams iplTeams = new IplTeams(teamName,tropics,teamOwner,teamCaptain);
    		list.add(iplTeams);
    	}
		return list;
	
    }
    
    public String insertIplTeams(IplTeams iplTeams) throws ClassNotFoundException, SQLException {
    	Connection connection =  DBConnect.getDBConn();
    	
    	PreparedStatement pStatement = connection.prepareStatement("INSERT INTO iplteams VALUES(?,?,?,?)");
    	
    	pStatement.setString(1, iplTeams.getTeamsName());
    	pStatement.setInt(2, iplTeams.getTropics());
    	pStatement.setString(3, iplTeams.getTeamOwner());
    	pStatement.setString(4, iplTeams.getTeamCaptain());

    	pStatement.executeUpdate();
    	
    	return "Data Added Successfully";	
    }
    
    public String updateTeams(String Captain, String TeamsName) throws ClassNotFoundException, SQLException {
    	
    	Connection connection = DBConnect.getDBConn();
    	PreparedStatement preparedStatement = connection.prepareStatement("UPDATE iplteams SET teamCaptain = ? WHERE teamsName = ?");
    	
    	preparedStatement.setString(1, Captain);
    	preparedStatement.setString(2, TeamsName);

    	preparedStatement.executeUpdate();
    	
    	return "Update Successfully";
    }
    
    public String updateAll(IplTeams iplTeams) throws ClassNotFoundException, SQLException {
    	
    	Connection connection = DBConnect.getDBConn();
    	PreparedStatement preparedStatement = connection.prepareStatement("UPDATE iplteams SET teamCaptain = ?,teamOwner= ?,tropics = ? WHERE teamsName = ?");
    	
    	preparedStatement.setString(1, iplTeams.getTeamCaptain());
    	preparedStatement.setString(2, iplTeams.getTeamOwner());
    	preparedStatement.setInt(3, iplTeams.getTropics());
    	preparedStatement.setString(4, iplTeams.getTeamsName());


    	preparedStatement.executeUpdate();
    	
    	return "Update Successfully";
    }
    
    
    public String deleteTeams(String teamsName) throws ClassNotFoundException, SQLException {
    	
    	Connection connection = DBConnect.getDBConn();
    	
    	PreparedStatement pStatement = connection.prepareStatement("DELETE FROM iplteams WHERE teamsName = ?");
    	pStatement.setString(1, teamsName);
    	
    	pStatement.executeUpdate();
    	
    	return "Delete Successfully";
    	
    }
    
    
    
}
