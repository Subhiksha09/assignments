package com.capg.user;

import java.util.Scanner;

import com.capg.match.Match;
import com.capg.match.MatchBO;
import com.capg.player.Player;
import com.capg.player.PlayerBO;
import com.capg.team.Team;
import com.capg.team.TeamBO;

public class MatchAndTeamMain {
	
	
	public static void main(String[] args) {
		
		MatchBO matchBO= new MatchBO();
		PlayerBO playerBO= new PlayerBO();
		TeamBO teamBO= new TeamBO();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the player count "); 
		int players=sc.nextInt();
		sc.nextLine();
		Player[] playerList= new Player[players];
		
		for(int i=0; i < players; i++) {
			
			System.out.println("Enter player "+(i+1)+" details");
			playerList[i]=playerBO.createPlayer(sc.nextLine());
		}
		
		System.out.println("Enter Teamcount "); 
		int teams=sc.nextInt();
		sc.nextLine();
		Team[] teamList= new Team[teams];
		
		for(int i = 0; i < teams; i++) {
			System.out.println("Enter team details");
			teamList[i] = teamBO.createTeam(sc.nextLine(),playerList);
		}
		
		System.out.println("Enter the Match count "); 
		int matches = sc.nextInt();
		sc.nextLine();
		Match[] matchList= new Match[matches];
		
		for(int i = 0; i < matches; i++) {
			
			System.out.println("Enter match details");
			matchList[i]=matchBO.createMatch(sc.nextLine(), teamList);
		}
			System.out.println("Menu");
			System.out.println("1. Find Matches"); 
			System.out.println("2. Find Teams"); 
			
			switch(sc.nextInt()){
			
			case 1:
				System.out.println("Enter Team name");
				matchBO.findAllMatches(sc.next(), matchList);
				break;
				
			case 2: 
				System.out.println("Enter match date");
				matchBO.findTeam(sc.next(), matchList);
				break;
				
			default:
				System.out.println("Enter valid input");
			}
			
		
	}
}
