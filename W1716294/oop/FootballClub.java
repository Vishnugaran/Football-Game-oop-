package oop;

import java.io.Serializable;

//A sub Class Football extending the Super Class SportsClub and has a Comparable <FootballClub> to print the FootballClub to Ascending Order
public class FootballClub extends SportsClub implements Comparable<FootballClub>,Serializable {
    	private int matchWins;		//Instance Variable For Football Class
    	private int matchLose;
    	private int matchTies;
    	private int goalReceived;
    	private int goalScored;
    	private int points;
    	private int matchesPlayed;


    	public FootballClub(String clubName, String clubId, String location, Date joinDate) {
        	super(clubName, clubId, location, joinDate);
    		}

//public Constructor for the football class along with the super Class SportsClub
    	public FootballClub(String clubName, String clubId, String location, Date joinDate, int matchWins, int matchLose, int matchTies, int goalReceived, int goalScored, int points, int matchesPlayed) {
        	super(clubName, clubId, location, joinDate);
        	this.matchWins = matchWins;
        	this.matchLose = matchLose;
        	this.matchTies = matchTies;
        	this.goalReceived = goalReceived;
        	this.goalScored = goalScored;
        	this.points = points;
        	this.matchesPlayed = matchesPlayed;
   		}

//Getter and setter Method For Instance Variables
    	public int getMatchWins() {
        	return matchWins;
    		}

   	public void setMatchWins(int matchWins) {
	        this.matchWins = matchWins;
    		}

    	public int getMatchLose() {
        	return matchLose;
    		}

 	public void setMatchLose(int matchLose) {
        	this.matchLose = matchLose;
    		}

    	public int getMatchTies() {
        	return matchTies;
    		}

    	public void setMatchTies(int matchTies) {
        	this.matchTies = matchTies;
    		}

    	public int getGoalReceived() {
        	return goalReceived;
    		}

    	public void setGoalReceived(int goalReceived) {
        	this.goalReceived = goalReceived;
    		}

	public int getGoalScored() {
        	return goalScored;
    		}

    	public void setGoalScored(int goalScored) {
        	this.goalScored = goalScored;
    		}

    	public int getPoints() {
        	return points;
    		}

    	public void setPoints(int points) {
        	this.points = points;
    		}

    	public int getMatchesPlayed() {
        	return matchesPlayed;
    		}

    	public void setMatchesPlayed(int matchesPlayed) {
        	this.matchesPlayed = matchesPlayed;
    		}

    @Override
    	public String toString() {
        	return super.toString()+ "Match Wins : " + matchWins + "| Match Lose : " + matchLose + "| Match Ties : " + matchTies + "| Goal Received : " + goalReceived +
                	"| Goal Scored : " + goalScored + "| Points : " + points + "| Matches Played : " + matchesPlayed;
    		}

    @Override
    public int compareTo(FootballClub o) {
        if (o.points == this.points)
            return o.getGoalScored() - this.getGoalScored();
        return o.points - this.points;

    }
}
