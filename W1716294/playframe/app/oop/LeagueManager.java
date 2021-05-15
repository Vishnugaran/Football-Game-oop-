package oop;

import java.io.IOException;
import java.util.ArrayList;

//Interface LeagueManager Contract To implements following Methods
public interface LeagueManager {
    void addClub() throws IOException;
    void deleteClub() throws IOException;
    void displayClub();
    void writeAndSave(String fileName) throws IOException;
    void retrieve(String fileName) throws IOException, ClassNotFoundException;
    void AddMatch() throws IOException;
    void calender();
    ArrayList<FootballClub> sort();
}