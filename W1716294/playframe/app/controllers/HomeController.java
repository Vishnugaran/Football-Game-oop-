package controllers;

import oop.Date;
import oop.FootballClub;
import oop.Match;
import oop.PremierLeagueManager;
import play.libs.Json;
import play.mvc.*;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    private ArrayList<FootballClub> leagueClubs = new ArrayList<>();
    private ArrayList<Match> matchArrayList = new ArrayList<>();
    static PremierLeagueManager plm = new PremierLeagueManager();

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    public Result sendClubs() throws IOException {
        leagueClubs.clear();
        FileInputStream fIStream = new FileInputStream("Club.txt");
        ObjectInputStream objInStream = new ObjectInputStream(fIStream);

        for (; ; ) {
            try {
                FootballClub club = (FootballClub) objInStream.readObject();
                leagueClubs.add(club);
            } catch (EOFException | ClassNotFoundException e) {
                break;
            }
        }
        fIStream.close();
        objInStream.close();

        return ok(Json.toJson(leagueClubs));
    }

    public Result sendMatchClubs() throws IOException {
        matchArrayList.clear();
        FileInputStream fileInputStream = new FileInputStream("MatchDetail.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        for (; ; ) {
            try {
                Match match = (Match) objectInputStream.readObject();
                matchArrayList.add(match);
            } catch (EOFException | ClassNotFoundException e) {
                break;
            }
        }
        fileInputStream.close();
        objectInputStream.close();

        return ok(Json.toJson(matchArrayList));
    }

        public Result random () throws IOException, ClassNotFoundException {
            plm.retrieve("Club.txt");
            int homeTeam_1 = (int) (Math.random() * 10) + 1;
            int awayTeam_1 = (int) (Math.random() * 10) + 1;
            int year = (int) (Math.random() * 11) + 2020;
            int month = (int) (Math.random() * 12) + 1;
            int day = (int) (Math.random() * 28) + 1;
            FootballClub Club1 = plm.getRandomClub();
            FootballClub Club2 = plm.getRandomClub();
            while (Club1.getClubId() == Club2.getClubId()) {
                Club2 = plm.getRandomClub();
            }
            Match match = new Match();
            match.setHomeTeam(Club1.getClubName());
            match.setAwayTeam(Club2.getClubName());
            match.setHomeGoal(homeTeam_1);
            match.setAwayGoal(awayTeam_1);
            Date date1 = new Date(day, month, year);
            match.setDate(date1);
            plm.addMatch(match);
            try {
                plm.writeMatchFile("MatchDetail.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (homeTeam_1 > awayTeam_1) {
                Club1.setPoints(Club1.getPoints() + 3);
                Club1.setMatchWins(Club1.getMatchWins() + 1);
                Club2.setMatchLose(Club2.getMatchLose() + 1);
            } else if (homeTeam_1 < awayTeam_1) {
                Club2.setPoints(Club2.getPoints() + 3);
                Club2.setMatchWins(Club2.getMatchWins() + 1);
                Club1.setMatchLose(Club1.getMatchLose() + 1);
            } else {
                Club1.setPoints(Club1.getPoints() + 1);
                Club2.setPoints(Club2.getPoints() + 1);
                Club1.setMatchTies(Club1.getMatchTies() + 1);
                Club2.setMatchTies(Club2.getMatchTies() + 1);
            }

            return ok(Json.toJson(match));
        }

    public Result points() {
        leagueClubs.sort(new Comparator<FootballClub>() {
            @Override
            public int compare(FootballClub o1, FootballClub o2) {
                return o2.getPoints() - o1.getPoints();
            }
        });
        return ok(Json.toJson(leagueClubs));
    }

    public Result wsort() {
        leagueClubs.sort(new Comparator<FootballClub>() {
            @Override
            public int compare(FootballClub o1, FootballClub o2) {
                return o2.getMatchWins() - o1.getMatchWins();
            }
        });
        return ok(Json.toJson(leagueClubs));
    }

    public Result gsort() {
        leagueClubs.sort(new Comparator<FootballClub>() {
            @Override
            public int compare(FootballClub o1, FootballClub o2) {
                return o2.getGoalScored() - o1.getGoalScored();
            }
        });
        return ok(Json.toJson(leagueClubs));
    }
}

