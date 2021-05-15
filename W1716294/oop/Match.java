package oop;

import java.io.Serializable;

//The Match Class
public class Match implements Serializable {
//Instance Variables For Match Class
	private String homeTeam;
    	private String awayTeam;
    	private int homeGoal;
    	private int awayGoal;
    	private Date date;

//Getter and Setter Methods for the Match Class
    	public String getHomeTeam() {
        	return homeTeam;
    		}

    	public void setHomeTeam(String homeTeam) {
        	this.homeTeam = homeTeam;
    		}

    	public String getAwayTeam() {
        	return awayTeam;
    		}

    	public void setAwayTeam(String awayTeam) {
        	this.awayTeam = awayTeam;
    		}

    	public int getHomeGoal() {
        	return homeGoal;
    		}

    	public void setHomeGoal(int homeGoal) {
        	this.homeGoal = homeGoal;
    		}

    	public int getAwayGoal() {
        	return awayGoal;
    		}

    	public void setAwayGoal(int awayBGoal) {
        	this.awayGoal = awayBGoal;
    		}

    	public Date getDate() {
        	return date;
    		}

    	public void setDate(Date date) {
        	this.date = date;
    		}
}