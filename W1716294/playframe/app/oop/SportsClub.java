package oop;

import java.io.Serializable;

//The Abstract Class SportsClub
public abstract class SportsClub implements Serializable {
//Instance Variable for Sports Class
   	private String clubName;
    	private String clubId;
    	private String location;
    	private Date joinDate;

		//The Public Constructor SportsClub
    	public SportsClub(String clubName, String clubId, String location, Date joinDate) {
        	this.clubName = clubName;
        	this.clubId = clubId;
        	this.location = location;
        	this.joinDate = joinDate;
    		}

//Getter and Setter Methods for the Instance Variable
	public String getClubName() {
        	return clubName;
    		}

	public void setClubName(String clubName) {
        	this.clubName = clubName;
    		}

	public String getClubId() {
        	return clubId;
    		}

    	public void setClubId(String clubId) {
        	this.clubId = clubId;
    		}

    	public String getLocation() {
        	return location;
    		}

    	public void setLocation(String location) {
        	this.location = location;
    		}

    	public Date getJoinDate() {
        	return joinDate;
    		}

    	public void setJoinDate(Date joinDate) {
        	this.joinDate = joinDate;
    		}

//To String Method To Print The Sports Club
    @Override
    public String toString() {
        return "ClubName : '" + clubName + '\'' + ", ClubId : '" + clubId + '\'' + ", Location : '" + location + '\'' + ", JoinDate : " + joinDate +"|";
    }
}
