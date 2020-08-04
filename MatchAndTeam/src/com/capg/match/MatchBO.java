package com.capg.match;

import com.capg.team.Team;

public class MatchBO {
	
	
	public Match createMatch(String data,Team[] teamList) {
		
		String[] matchInfo = data.split(",");
		Match match = new Match();
		match.setDate(matchInfo[0]);
		System.out.println(matchInfo[1]+" "+matchInfo[2]);
		
		Team team1 = findteam(matchInfo[1], teamList);
		Team team2 = findteam(matchInfo[2], teamList);

		match.setTeamone(team1);
		match.setTeamtwo(team2);
		match.setVenue(matchInfo[3]);
		return match;
		
	}
	
	public Team[] findTeam(String matchDate,Match[] matchList) {
		Team[] t =new Team[2];
		for(Match match : matchList) {
			
			if(match.getDate().equals(matchDate)) {
				t[0]=match.getTeamone();
				t[1]=match.getTeamtwo();
			
				return t;
			}
		}
		return t;
		
	}
	
	
	private Team findteam(String team, Team[] teamList) {
		
		for(Team t : teamList) {
			if(t.getName().equalsIgnoreCase(team)) {
				
				return t;
			}
		}
		
		return null;
		
	}

	
	
	public void findAllMatches(String teamName, Match[] matchList) {
		
		for(Match match : matchList) {
			if(match.getTeamone().getName().equalsIgnoreCase(teamName) || match.getTeamtwo().getName().equalsIgnoreCase(teamName)) {
				System.out.println(match);
				
			}
		}
	}
	
	

}
