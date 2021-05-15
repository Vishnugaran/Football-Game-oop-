package oop;

//The UniversityFootballClub Class
public class UniversityFootballClub {
//Instance Variable for UniversityFootballClub
    private String uniName;
    private String uniDivision;

//public Constructor for UniversityFootballClub
    	public UniversityFootballClub(String uniName, String uniDivision) {
        	this.uniName = uniName;
        	this.uniDivision = uniDivision;
    		}

//Getter and Setter methods for UniversityFootballClub
    	public String getUniName() {
        	return uniName;
    		}

 	public void setUniName(String uniName) {
        	this.uniName = uniName;
    		}

    	public String getUniDivision() {
        	return uniDivision;
    		}

    	public void setUniDivision(String uniDivision) {
        	this.uniDivision = uniDivision;
    		}

    	@Override
    	public String toString() {
			return "UniversityFootballClub{" + "uniName='" + uniName + '\'' + ", uniDivision='" + uniDivision;
    }
}
