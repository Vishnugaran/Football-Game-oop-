package oop;

//The SchoolFootballClub Class
public class SchoolFootballClub {
//Instance Variables for SchoolFootballClub
    private String schoolName;
    private String schoolDivision;

    //Public constructor for SchoolFootballClub
    public SchoolFootballClub(String schoolName, String schoolDivision) {
        this.schoolName = schoolName;
        this.schoolDivision = schoolDivision;
    }

    //Getter and Setter methods for SchoolFootballClub

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolDivision() {
        return schoolDivision;
    }

    public void setSchoolDivision(String schoolDivision) {
        this.schoolDivision = schoolDivision;
    }

    @Override
    public String toString() {
        return "SchoolFootballClub{" +
                "schoolName='" + schoolName + '\'' +
                ", schoolDivision='" + schoolDivision + '\'' +
                '}';
    }
}
