package oop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//Imports Football Class that implements
public class PremierLeagueManager implements LeagueManager {
	//Instance Variables for the ManagerClass along with the Arraylists
	Scanner input = new Scanner(System.in);
	private ArrayList<FootballClub> leagueClubs = new ArrayList<>();
	private ArrayList<Match> matchArrayList = new ArrayList<>();
	String clubName;
	String location;
	String clubId;
	int day;
	int month;
	int year;

	// Add FootballClub Method implemented by the LeagueManager Class
	@Override
	public void addClub() throws IOException {
		System.out.println("1 - Add to Football Club ");
		System.out.println("2 - Add to School Football Club ");
		System.out.println("3 - Add to University Football Club ");
		System.out.println("--------------------------------------------");
		System.out.print("Enter The Number : ");
		while (!input.hasNextInt()) {   //Check Input is Number         //Reference Stack overflow
			System.out.println("Invalid Input! You can Enter above Choices only");
			System.out.print("Please re Enter the Number : ");
			input.next();
		}
		int option = input.nextInt();

		switch (option) { //Create # Switch Cases For add Clubs
			case 1:
				System.out.println("");
				System.out.print("Enter The Club Name : ");
				clubName = input.next();
				if (!clubName.matches("[a-zA-Z_]+")) {      //Check Input is Alphabet Letters  //Reference Stack Overflow
					System.out.println("You Can Input Letters only!");
					System.out.println();
					addClub();
				} else {
					for (int i = 0; i < leagueClubs.size(); i++) {
						if (leagueClubs.get(i).getClubName().equals(clubName)) {    //Check Name is in Arraylist
							System.out.println("Already the Name is Available! ");
							System.out.println();
							addClub();
						}
					}
					System.out.print("Enter the Club ID (Numbers only) : ");
					clubId = input.next();
					if (!clubId.matches("[0-9]+")) { //Check Input is Number         //Reference Stack overflow
						System.out.println("You can input only Numbers!");
						System.out.println();
						addClub();
					}

					System.out.print("Enter the Club Location : ");
					location = input.next();
					if (!location.matches("[a-zA-Z_]+")) {   //Check Input is Alphabet Letters  //Reference Stack Overflow
						System.out.println("Location Must be in Letters");
						System.out.println();
						addClub();
					}

					System.out.println("Club Join Date");
					calender();     //Call Calender Method

					Date date1 = new Date(day, month, year);
					FootballClub club = new FootballClub(clubName, clubId, location, date1);
					this.leagueClubs.add(club);
					writeAndSave("playframe\\Club.txt");       //Call WriteAndSave Method for Save the Details
				}
				break;

			case 2:                 //Two Cases for Future implementation
				System.out.println("Now You cant add SchoolClubs ");
				addClub();
			case 3:
				System.out.println("Now You Cant Add University Clubs ");
				addClub();
		}
	}

	// Delete FootballClub Method implemented by the LeagueManager Class
	@Override
	public void deleteClub() throws IOException {
		System.out.print("Insert the Club Name : ");
		clubName = input.next();
		if (!clubName.matches("[a-zA-Z_]+")) {  //Check
			System.out.println("Please re Enter the Name Must be in Letters!");
			deleteClub();
		} else {
			int count = 0;
			for (int i = 0; i < leagueClubs.size(); i++) {
				if (leagueClubs.get(i).getClubName().equals(clubName)) {
					System.out.println("* " + leagueClubs.get(i).getClubName() + " Club is Removed from the League Manager *");
					leagueClubs.remove(i);
					i = leagueClubs.size();
					count = 1;
				}
			}
			if (count == 0) {
				System.out.println("* " + clubName + " Club is not available in the League Manager *");
			}
			writeAndSave("playframe\\Club.txt");
		}
	}

	// Display Specific FootballClub Method implemented by the LeagueManager Class
	@Override
	public void displayClub() {
		System.out.print("Insert club name: ");
		clubName = input.next();
		if (!clubName.matches("[a-zA-Z_]+")) {      //Check ClubName is alphabet
			System.out.println("{Please re Enter the Name Must be in Letters!}");
			displayClub();
		} else {
			int count = 0;
			for (int i = 0; i < leagueClubs.size(); i++) {      //Check ClubName is in Arraylist
				if (leagueClubs.get(i).getClubName().equals(clubName)) {
					System.out.println();
					System.out.println("Club " + leagueClubs.get(i).getClubName() + " | " + " join Date is : " + leagueClubs.get(i).getJoinDate());
					System.out.println();
					System.out.println(" -Matches Win     : " + leagueClubs.get(i).getMatchWins());
					System.out.println(" -Matches Lose    : " + leagueClubs.get(i).getMatchLose());
					System.out.println(" -Matches Ties    : " + leagueClubs.get(i).getMatchTies());
					System.out.println(" -Matches Goals   : " + leagueClubs.get(i).getGoalScored());
					System.out.println(" -Received Goals  : " + leagueClubs.get(i).getGoalReceived());
					System.out.println(" -Matches points  : " + leagueClubs.get(i).getPoints());
					System.out.println(" -Matches played  : " + leagueClubs.get(i).getMatchesPlayed());
					i = leagueClubs.size();
					count = 1;
				}
			}
			if (count == 0) {
				System.out.println("* " + clubName + " Club is not available in the League Manager *");
			}
		}
	}

	// Display All FootballClub Method implemented by the LeagueManager Class
	@Override
	public ArrayList<FootballClub> sort() {
        System.out.println("------------------------------PremierLeagueManager----------------------------");
         System.out.println();
	System.out.printf("%-10s %30s %10s %10s %10s %10s %10s %10s ","ClubName" , "M.P" , "M.W" , "M.L" , "M.T" , "Goals" , "M.R" , "M.P");
        System.out.println();
        Collections.sort(leagueClubs);
        for (FootballClub footballClub : leagueClubs) {
            System.out.printf("%-10s %30s %10s %10s %10s %10s %10s %10s ",footballClub.getClubName() , footballClub.getMatchesPlayed() , footballClub.getMatchWins() , footballClub.getMatchLose() , footballClub.getMatchTies() , footballClub.getGoalScored() , footballClub.getGoalReceived() , footballClub.getPoints());
            System.out.println();
        }
        return leagueClubs;
    }

	// Add Matches FootballClub Method implemented by the LeagueManager Class
	@Override
	public void AddMatch() throws IOException {
		String homeTeam;
		String awayTeam;
		int homeGoal;
		int awayGoal;

		boolean flag;
		do {
			System.out.print("Enter the HomeTeam :");
			homeTeam = input.nextLine();
			flag = check(homeTeam);       //Check Home Team in Arraylist
			if (!flag) {
				System.out.println();
			}
		} while (!flag);

		boolean flag1;
		do {
			System.out.print("Enter the AwayTeam :");
			awayTeam = input.nextLine();
			flag1 = check(awayTeam);       //Check Away Team in Arraylist
			if (!flag1) {
				System.out.println("AwayTeam is not available in the League Manager");
			}
		} while (!flag1);

		FootballClub club1 = getClub(homeTeam);
		FootballClub club2 = getClub(awayTeam);

		System.out.println("Match Date ");
		calender();

		do {
			System.out.print("Enter the Home Goal : ");
			while (!input.hasNextInt()) {        //Check HomeGoal is Number
				System.out.print("Goal Must be in Numbers : ");
				input.next();
			}
			homeGoal = input.nextInt();
			if (homeGoal < 0) {         //Check Goal is Positive
				System.out.println("Goals are Should be in positive Values! ");
			}

		} while (homeGoal < 0);

		do {
			System.out.print("Enter the away Goal : ");
			while (!input.hasNextInt()) {        //Check AwayGoal is Number
				System.out.print("Goal Must be in Numbers : ");
				input.next();
			}
			awayGoal = input.nextInt();
			if (awayGoal < 0) {         //Check Goal is Positive
				System.out.println("Goals are Should be in positive Values!");
			}

		} while (awayGoal < 0);


		Match match = new Match();
		match.setHomeTeam(homeTeam);
		match.setAwayTeam(awayTeam);
		match.setHomeGoal(homeGoal);
		match.setAwayGoal(awayGoal);
		Date date1 = new Date(day, month, year);
		match.setDate(date1);
		matchArrayList.add(match);

//Set scored,Received And played Matches
		club1.setGoalScored(club1.getGoalScored() + homeGoal);
		club2.setGoalScored(club2.getGoalScored() + awayGoal);
		club1.setGoalReceived(club1.getGoalReceived() + awayGoal);
		club2.setGoalReceived(club2.getGoalReceived() + homeGoal);
		club1.setMatchesPlayed(club1.getMatchesPlayed() + 1);
		club2.setMatchesPlayed(club2.getMatchesPlayed() + 1);

//Set points, Wins,lose And Ties
		if (homeGoal > awayGoal) {
			club1.setPoints(club1.getPoints() + 3);
			club1.setMatchWins(club1.getMatchWins() + 1);
			club2.setMatchLose(club2.getMatchLose() + 1);
		} else if (homeGoal < awayGoal) {
			club2.setPoints(club2.getPoints() + 3);
			club2.setMatchWins(club2.getMatchWins() + 1);
			club1.setMatchLose(club1.getMatchLose() + 1);
		} else {
			club1.setPoints(club1.getPoints() + 1);
			club2.setPoints(club2.getPoints() + 1);
			club1.setMatchTies(club1.getMatchTies() + 1);
			club2.setMatchTies(club2.getMatchTies() + 1);
		}
		writeAndSave("playframe\\Club.txt");
		writeMatchFile("playframe\\MatchDetail.txt");

	}

	// Write And Save FootballClub Method implemented by the LeagueManager Class
	public void writeAndSave(String fileName) throws IOException {
		FileOutputStream foStream = new FileOutputStream(fileName);
		ObjectOutputStream objOutStream = new ObjectOutputStream(foStream);

		for (FootballClub footballClub : leagueClubs) {
			objOutStream.writeObject(footballClub);
		}

		objOutStream.flush();
		foStream.close();
		objOutStream.close();
	}

// Retrieve FootballClub Method implemented by the LeagueManager Class
	public void retrieve(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fIStream = new FileInputStream(fileName);
        ObjectInputStream objInStream = new ObjectInputStream(fIStream);

        for(;;) {
            try {
                FootballClub club = (FootballClub) objInStream.readObject();
                leagueClubs.add(club);
            }
            catch (EOFException e) {
                break;
            }
        }
        fIStream.close();
        objInStream.close();
    }

// Write Match File FootballClub Method
		public void writeMatchFile (String fileName) throws IOException {

			FileOutputStream fOStream = new FileOutputStream(fileName);
			ObjectOutputStream objOutStream = new ObjectOutputStream(fOStream);

			for (Match match : matchArrayList) {
				objOutStream.writeObject(match);
			}
			objOutStream.flush();
			fOStream.close();
			objOutStream.close();
		}

// Retrieve Match  FootballClub Method
    public void matchRetrieve(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fInStream = new FileInputStream(fileName);
        ObjectInputStream objInStream = new ObjectInputStream(fInStream);
        for (;;) {
            try {
                Match match = (Match) objInStream.readObject();
                matchArrayList.add(match);
            } catch (EOFException e) {
                break;
            }
       }
       fInStream.close();
        objInStream.close();
	}

//
//    public ObservableList<FootballClub> display() {
//        ObservableList<FootballClub> tableList = FXCollections.observableArrayList();
//        for(FootballClub club : leagueClubs) {
//            tableList.add(club);
//        }
//        return  tableList;
//    }
//
//    public ObservableList<Match> printMatchTable() {
//        ObservableList<Match> tableListMatch = FXCollections.observableArrayList();
//        for(Match match : matchArrayList) {
//            tableListMatch.add(match);
//        }
//        return  tableListMatch;
//    }
//
//    public ObservableList<Match> printMatchTable(Date date) {
//        ObservableList<Match> MatchTable = FXCollections.observableArrayList();
//        for(Match match : matchArrayList){
//            if(match.getDate().check(date)) {
//                MatchTable.add(match);
//            }
//                MatchTable.add(match);
//        }
//        return  MatchTable;
//    }
//
    public FootballClub getRandomClub(){
        int max = leagueClubs.size() ;
        int clubIndex = (int)(Math.random() * max)+1;
        return leagueClubs.get(clubIndex - 1);
    }
//
//    public ArrayList<FootballClub> winSort(){
//        leagueClubs.sort(new Comparator<FootballClub>() {
//            @Override
//            public int compare(FootballClub o1, FootballClub o2) {
//                return o2.getMatchWins() - o1.getMatchWins();
//            }
//        });
//        return leagueClubs;
//    }
//
//    public ArrayList<FootballClub> pointsSort(){
//        leagueClubs.sort(new Comparator<FootballClub>() {
//            @Override
//            public int compare(FootballClub o1, FootballClub o2) {
//                return o2.getPoints() - o1.getPoints();
//            }
//        });
//        return leagueClubs;
//    }
//
//    public ArrayList<FootballClub> GoalSort(){
//        leagueClubs.sort(new Comparator<FootballClub>() {
//            @Override
//            public int compare(FootballClub o1, FootballClub o2) {
//                return o2.getGoalScored() - o1.getGoalScored();
//            }
//        });
//        return leagueClubs;
//    }


		public void calender () {   //Calender Method
			for (int i = 0; i <= 1; i++) {
				System.out.print(" -Enter Day (1-31) : ");
				while (!input.hasNextInt()) {  //check Date Is Number
					System.out.println("Your Input Day is Wrong! ");
					System.out.print("Day Must be in Numbers : ");
					input.next();
				}
				day = input.nextInt();
				if (day >= 1 && day <= 31) { //Check Date 1-31
					i = 1;
				} else {
					System.out.println("Please re Enter the Day Between 1-31");
					i = 0;
				}
			}


			for (int i = 0; i <= 1; i++) {
				System.out.print(" -Enter Month (1-12) : ");
				while (!input.hasNextInt()) {   //Check Month is Nmber
					System.out.println("Your Input Month is wrong!");
					System.out.print("Month Must be in Numbers : ");
					input.next();
				}
				month = input.nextInt();
				if (month >= 1 && month <= 12) {    //Check Month is 1-12
					i = 1;
				} else {
					System.out.println("Please re Enter the Month Between 1-12");
					i = 0;
				}
			}
			for (int i = 0; i <= 1; i++) {
				System.out.print(" -Enter Year (2000-2020) : ");
				while (!input.hasNextInt()) {   //Check Year is Number
					System.out.println("Your Input Year is wrong!");
					System.out.print("Year Must be in Numbers : ");
					input.next();
				}
				year = input.nextInt();
				if (year >= 2000 && year <= 2020) {     //Check Year 2000-2020
					i = 1;
				} else {
					System.out.println("Please re Enter the Year! year Should be in 4 Characters ");
					i = 0;
				}
			}
		}
		public FootballClub getClub (String name){
			FootballClub footballClub = null;
			for (FootballClub club : leagueClubs) {
				if (club.getClubName().equals(name)) {
					footballClub = club;
					break;
				}
			}
			return footballClub;
		}

    public void addMatch(Match match){
        matchArrayList.add(match);
    }

		public boolean check (String clubName){
			boolean flag = false;
			for (int i = 0; i < leagueClubs.size(); i++) {
				if (leagueClubs.get(i).getClubName().equals(clubName)) {
					flag = true;
					break;
				}
			}
			return flag;
		}
	}