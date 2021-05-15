package oop;

//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.io.EOFException;
//import java.io.IOException;
//import java.util.Scanner;

public class Main{
//    @Override
//     public void start(Stage primaryStage) throws Exception {
//        Stage homeStage = new Stage();
//        homeStage.setTitle("Premier League");
//        homeStage.setResizable(false);
//
//        Stage stage = new Stage();
//        stage.setTitle("FootBall Clubs");
//
//        Button btn1 = new Button("Print Club List");
//        Button btn2 = new Button("Match List");
//        Button btn3 = new Button("Random Match");
//        Button btn4 = new Button("Search Match");
//        Button btn5 = new Button("Exit");
//
//        btn1.setPrefSize(110, 35);
//        btn2.setPrefSize(110, 35);
//        btn3.setPrefSize(110, 35);
//        btn4.setPrefSize(110,35);
//        btn5.setPrefSize(110, 35);
//
//        btn1.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #222f3e; -fx-background-radius: 20");
//        btn2.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #222f3e; -fx-background-radius: 20");
//        btn3.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #222f3e; -fx-background-radius: 20");
//        btn4.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #222f3e; -fx-background-radius: 20");
//        btn5.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #d63031; -fx-background-radius: 20");
//
//        VBox homeVbox = new VBox();
//        homeVbox.setSpacing(5);
//        homeVbox.setLayoutX(50);
//        homeVbox.setLayoutY(100);
//        homeVbox.getChildren().addAll(btn1,btn2,btn3,btn4,btn5);
//
//        //print premier league  Table
//        Button button = new Button("  Point Sort  ");
//        button.setLayoutX(10);
//        button.setLayoutY(410);
//
//        Button button1 = new Button("  Win Sort  ");
//        button1.setLayoutX(160);
//        button1.setLayoutY(410);
//
//        Button button2 = new Button("  Goal Sort  ");
//        button2.setLayoutX(310);
//        button2.setLayoutY(410);
//
//        button.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: midnightblue; -fx-background-radius: 20");
//        button1.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: midnightblue; -fx-background-radius: 20");
//        button2.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: midnightblue; -fx-background-radius: 20");
//
//        TableColumn<FootballClub,String> column1 = new TableColumn<>("ClubName");
//        TableColumn<FootballClub,String> column2 = new TableColumn<>("Club ID");
//        TableColumn<FootballClub, Date> column3 = new TableColumn<>("Join Date");
//        TableColumn<FootballClub,Integer> column4 = new TableColumn<>("M.Played");
//        TableColumn<FootballClub,Integer> column5 = new TableColumn<>("M.Wins");
//        TableColumn<FootballClub,Integer> column6 = new TableColumn<>("M.Lose");
//        TableColumn<FootballClub,Integer> column7 = new TableColumn<>("M.Ties");
//        TableColumn<FootballClub,Integer> column8 = new TableColumn<>("M.Goals");
//        TableColumn<FootballClub,Integer> column9 = new TableColumn<>("Points");
//        column1.setCellValueFactory(new PropertyValueFactory<>("clubName"));
//        column2.setCellValueFactory(new PropertyValueFactory<>("clubId"));
//        column3.setCellValueFactory(new PropertyValueFactory<>("joinDate"));
//        column4.setCellValueFactory(new PropertyValueFactory<>("matchesPlayed"));
//        column5.setCellValueFactory(new PropertyValueFactory<>("matchWins"));
//        column6.setCellValueFactory(new PropertyValueFactory<>("matchLose"));
//        column7.setCellValueFactory(new PropertyValueFactory<>("matchTies"));
//        column8.setCellValueFactory(new PropertyValueFactory<>("goalScored"));
//        column9.setCellValueFactory(new PropertyValueFactory<>("Points"));
//
//
//        TableView<FootballClub> table = new TableView<>();
//        table.setItems(plm.display());
//        table.getColumns().addAll(column1,column2,column3,column4,column5,column6,column7,column8,column9);
//
//        button.setOnAction(event ->{
//            table.getItems().setAll(plm.pointsSort());
//        });
//
//        button1.setOnAction(event ->{
//            table.getItems().setAll(plm.winSort());
//        });
//        button2.setOnAction(event ->{
//            table.getItems().setAll(plm.GoalSort());
//        });
//
//
//        Pane pane = new Pane();
//        pane.getChildren().addAll(table,button,button1,button2);
//        Scene scene1 = new Scene(pane,715,450);
//
//        btn1.setOnAction(event -> {
//            stage.setScene(scene1);
//            stage.showAndWait();
//        });
//
//
//        //Match Table
//        Stage stage1 = new Stage();
//        stage1.setTitle("Match Table");
//
//        TableColumn<Match,String> col1 = new TableColumn<>("Home Team");
//        TableColumn<Match,String> col2 = new TableColumn<>("Away Team");
//        TableColumn<Match,Integer> col3 = new TableColumn<>("Home Goal");
//        TableColumn<Match,Integer> col4 = new TableColumn<>("Away Goal");
//        TableColumn<Match,Date> col5 = new TableColumn<>("Date");
//        col5.setMinWidth(200);
//        col1.setCellValueFactory(new PropertyValueFactory<>("homeTeam"));
//        col2.setCellValueFactory(new PropertyValueFactory<>("awayTeam"));
//        col3.setCellValueFactory(new PropertyValueFactory<>("homeGoal"));
//        col4.setCellValueFactory(new PropertyValueFactory<>("awayGoal"));
//        col5.setCellValueFactory(new PropertyValueFactory<>("date"));
//
//        TableView<Match> table1 = new TableView<>();
//        table1.setItems(plm.printMatchTable());
//        table1.getColumns().addAll(col1,col2,col3,col4,col5);
//
//
//        Pane pane1 = new Pane();
//        pane1.getChildren().addAll(table1);
//        Scene scene2 = new Scene(pane1,535,450);
//
//        btn2.setOnAction(event -> {
//            stage1.setScene(scene2);
//            stage1.showAndWait();
//        });
//
//      //Random MATCH
//        Stage stage2 = new Stage();
//        stage2.setTitle("Match Table");
//
//        Label homeTeam = new Label();
//        homeTeam.setLayoutY(50);
//        homeTeam.setLayoutX(75);
//
//        Label awayTeam = new Label();
//        awayTeam.setLayoutY(100);
//        awayTeam.setLayoutX(75);
//        Label homeGoal = new Label();
//        homeGoal.setLayoutY(150);
//        homeGoal.setLayoutX(75);
//        Label awayGoal = new Label();
//        awayGoal.setLayoutY(200);
//        awayGoal.setLayoutX(75);
//        Label matchDate = new Label();
//        matchDate.setLayoutY(250);
//        matchDate.setLayoutX(75);
//
//        homeTeam.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: green; -fx-background-radius: 10; -fx-padding:6px");
//        awayTeam.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: maroon; -fx-background-radius: 10; -fx-padding:6px");
//        homeGoal.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: green; -fx-background-radius: 10; -fx-padding:6px");
//        awayGoal.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: maroon; -fx-background-radius: 10; -fx-padding:6px");
//        matchDate.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: steelblue; -fx-background-radius: 10; -fx-padding:6px");
//
//
//        Pane pane2 = new Pane();
//        pane2.getChildren().addAll(homeTeam,awayTeam,homeGoal,awayGoal,matchDate);
//        Scene scene3  = new Scene(pane2,400,300);
//
//        btn3.setOnAction(event -> {
//            int homeTeam_1= (int)(Math.random() * 10) + 1;
//            int awayTeam_1 = (int)(Math.random() * 10) + 1;
//            int year = (int)(Math.random() * 11) + 2020;
//            int month = (int)(Math.random() * 12) + 1;
//            int day = (int)(Math.random() * 28) + 1;
//            FootballClub Club1 = plm.getRandomClub();
//            FootballClub Club2 = plm.getRandomClub();
//            while(Club1.getClubId() == Club2.getClubId()){
//                Club2 = plm.getRandomClub();
//            }
//            Match match = new Match();
//            match.setHomeTeam(Club1.getClubName());
//            match.setAwayTeam(Club2.getClubName());
//            match.setHomeGoal(homeTeam_1);
//            match.setAwayGoal(awayTeam_1);
//            Date date1 = new Date(day, month, year);
//            match.setDate(date1);
//            plm.addMatch(match);
//
//
//            if (homeTeam_1 > awayTeam_1){
//                Club1.setPoints(Club1.getPoints()+3);
//                Club1.setMatchWins(Club1.getMatchWins()+1);
//                Club2.setMatchLose(Club2.getMatchLose()+1);
//            }else if (homeTeam_1 < awayTeam_1){
//                Club2.setPoints(Club2.getPoints()+3);
//                Club2.setMatchWins(Club2.getMatchWins()+1);
//                Club1.setMatchLose(Club1.getMatchLose()+1);
//            }else {
//                Club1.setPoints(Club1.getPoints()+1);
//                Club2.setPoints(Club2.getPoints()+1);
//                Club1.setMatchTies(Club1.getMatchTies()+1);
//                Club2.setMatchTies(Club2.getMatchTies()+1);
//                try {
//                    plm.writeAndSave("Club.txt");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            try {
//                plm.writeMatchFile("MatchDetail.txt");
//                plm.writeAndSave("Club.txt");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//            homeTeam.setText("HomeTeam Name : "+Club1.getClubName());
//            awayTeam.setText("AwayTeam Name : "+Club2.getClubName());
//            homeGoal.setText("HomeTeam Goal : "+homeTeam_1);
//            awayGoal.setText("Away Goal : "+awayTeam_1);
//            Date dateOfMatch =new Date(day,month,year);
//            matchDate.setText("Match Date : "+dateOfMatch.toString());
//            stage2.setScene(scene3);
//            stage2.showAndWait();
//        });
//
//
//        Stage stage3 = new Stage();
//        stage3.setTitle("Match Search");
//
//        TextField d_tx1 = new TextField();
//        d_tx1.setLayoutX(175);
//        d_tx1.setLayoutY(50);
//        Label d_l1 = new Label("Enter Day");
//        d_l1.setLayoutX(60);
//        d_l1.setLayoutY(50);
//        TextField m_tx2 = new TextField();
//        m_tx2.setLayoutX(175);
//        m_tx2.setLayoutY(100);
//        Label m_l2 = new Label("Enter Month");
//        m_l2.setLayoutX(60);
//        m_l2.setLayoutY(100);
//        TextField y_tx3 = new TextField();
//        y_tx3.setLayoutX(175);
//        y_tx3.setLayoutY(150);
//        Label y_l3 = new Label("Enter Year");
//        y_l3.setLayoutX(60);
//        y_l3.setLayoutY(150);
//
//        Button bt1 = new Button("Search");
//        bt1.setLayoutX(130);
//        bt1.setLayoutY(220);
//
//        d_l1.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #222f3e; -fx-background-radius: 20; -fx-padding:6px");
//        m_l2.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #222f3e; -fx-background-radius: 20; -fx-padding:6px");
//        y_l3.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #222f3e; -fx-background-radius: 20; -fx-padding:6px");
//        bt1.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: grey; -fx-background-radius: 20; -fx-padding:6px");
//
//        Pane pane4 = new Pane();
//        pane4.getChildren().addAll(d_tx1,m_tx2,y_tx3,d_l1,m_l2,y_l3,bt1);
//        Scene scene4 = new Scene(pane4,535,300);
//
//        btn4.setOnAction(event -> {
//            stage3.setScene(scene4);
//            stage3.showAndWait();
//        });
//
//
//        bt1.setOnAction(event ->{
//            int day = Integer.parseInt(d_tx1.getText());
//            int month = Integer.parseInt(m_tx2.getText());
//            int year = Integer.parseInt(y_tx3.getText());
//
//            Date date = new Date(day,month,year);
//            for ( int i = 0; i<table1.getItems().size(); i++) {
//                table1.getItems().clear();
//            }
//            table1.setItems(plm.printMatchTable(date));
//            stage1.setScene(scene2);
//            stage1.showAndWait();
//
//        });
//
//        btn5.setOnAction(event -> {
//            homeStage.close();
//        });
//        Pane Pane2 = new Pane();
//        Pane2.getChildren().addAll(homeVbox);
//
//        homeStage.setScene(new Scene(Pane2, 500, 400));
//        homeStage.showAndWait();
//
//
//    }


    	static PremierLeagueManager plm = new PremierLeagueManager();
    	public static void main(String[] args) throws IOException {
       		try {
           	plm.matchRetrieve("playframe\\MatchDetail.txt");
           	plm.retrieve("playframe\\Club.txt");
       		} catch (EOFException | ClassNotFoundException e) {
         	   System.out.println("Files is Empty");
       		}
//Application.launch(args);
            int option;
            do {
		Scanner input = new Scanner(System.in);
                System.out.println("\t"+"\t"+"\t"+"\t"+"-----------------------------------------------");
                System.out.println("\t"+"\t"+"\t"+"\t"+"************ Premier League Manager **********");
                System.out.println("\t"+"\t"+"\t"+"\t"+"-----------------------------------------------");
                System.out.println("1 - Add New Club to League Manager");
                System.out.println("2 - Remove the existing Club from League Manager ");
                System.out.println("3 - Display Specific Club Statics from League Manager");
                System.out.println("4 - Display table for All Clubs");
                System.out.println("5 - Add Match Between Clubs");
                System.out.println("6 - Gui");
                System.out.println("--------------------------------------------");
                System.out.print("Enter The Number : ");
                while (!input.hasNextInt()) {       //Check Number Input
                    System.out.println("Invalid input");
                    System.out.print("Please re Enter The Number : ");
                    input.next();
                }

                option = input.nextInt();

                switch (option) {       //Switch Cases For Options
                    case 1:
                        plm.addClub();
                        break;
                    case 2:
                        plm.deleteClub();
                        break;
                    case 3:
                        plm.displayClub();
                        break;
                    case 4:
                        plm.sort();
                        break;
                    case 5:
                        plm.AddMatch();
                        break;
                    case 6:
                        Runtime rt = Runtime.getRuntime();
                        rt.exec("cmd.exe /c cd \""+"../W1716294/playframe"+"\" & start cmd.exe /k \"sbt run\"");
                        rt.exec("cmd.exe /c cd \""+"../W1716294/Angular"+"\" & start cmd.exe /k ng serve --open\"");;
                        break;
                    default:
                        System.out.println("---Invalid Input Try Again---");
                        main(args);
                }
            } while (option >= 1 && option <=6);

        }
}


