package oop;

import java.io.Serializable;

//Date Class
public class Date implements Serializable {
	private int day;
	private int month;
	private int year;

//The Public Constructor Date
	public Date(int day, int month, int year) {
        	this.day = day;
        	this.month = month;
        	this.year = year;
    		}

//Getter Setter Methods for the 3 Instance Variable
	public int getDay() {
        	return day;
    		}
 	public void setDay(int day) {
        	this.day = day;
    		}
	public int getMonth() {
		return day;
	}

	public void setMonth(int month) {
        	this.month = month;
    		}

    	public int getYear() {
        	return year;
    		}

	public void setYear(int year) {
        	this.year = year;
    		}

    	@Override
    	public String toString() {
        	return  + day +"/"+ month +"/"+ year ;
    		}
    	public boolean check(Date date){
        	return day == date.getDay() && month == date.getMonth() && year == date.getYear();
    		}
}

