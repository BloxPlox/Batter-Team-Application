/*
 * Title: Final Project
 * Date: 4-23-20
 * Author: James Nagy
 */

/* 
    Batter Acronyms
    --------------------
    AB : at-bats
    R : runs scored
    H : base hits
    2B : doubles
    3B : triples
    HR : home runs
    HBP : hit by pitch
    RBI : runs batted in
    SF : sacrifice fly
    BB : walks allowed
    SO : strike out
    PO : putout
    A : assist
    LOB : left on base

    Pitcher Acronyms
    --------------------
    IP : innings pitched
    H : base hits
    R : runs scored
    ER : earned run
    BB : walks allowed
    SO : strike out
    AB : at-bats
    BF : batters faced
    NP : number of pitches
*/

// packages
package gui;

// import statements
import business.Validation;
import business.Batter;
import business.BatterReport;
import db.BatterFile;
import db.BatterReportTextFile;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

                                
/* -------------------------- Batter Class -------------------------------------
 Add updates here:

 James Nagy: 4-24-20 - added text fields, labels, and combo box for user input

 James Nagy: 4-26-20 - updated the submitPSButtonClicked() to validate user 
    input and added the addBatter() method to write the batter to a file

 James Nagy: 4-27-20 - added combo box for batter report and added the 
    submitReportButtonClicked() method

 James Nagy: 5-2-20 - added new fields for compatibility with the task that
    lists a report of batter statistics.

 James Nagy 5-4-20 - reworked the GUI, BatterFile, BatterReportTextFile, and
    BatterReport files have the entered data be written out to a file 
    identified by the date of the game. Added comments, fixed bugs, tried to
    make things more efficient. Also added all files to packages. 
----------------------------------------------------------------------------- */
public class BatterGUI extends Application {
    
    // variables
    private static BatterFile FILE = null;
    private static BatterReportTextFile FILE_REPORT = null;
    private String fileName = null;
    
    public static String date;
    public static String dateReport;
    public TextField playerField;
    public TextField atBatsField;
    public TextField runsScoredField;
    public TextField baseHitsField;
    public TextField doubleField;
    public TextField tripleField;
    public TextField homeRunField;
    public TextField hitByPitchField;
    public TextField runsBattedInField;
    public TextField sacrificeFlyField;
    public TextField walksAllowedField;
    public TextField strikeOutField;
    public TextField putoutField;
    public TextField assistField;
    public TextField leftOnBaseField;
       
    private Label playerLabel;
    private Label atBatsLabel;
    private Label runsScoredLabel;
    private Label baseHitsLabel;
    private Label doubleLabel;
    private Label tripleLabel;
    private Label homeRunLabel;
    private Label hitByPitchLabel;
    private Label runsBattedInLabel;
    private Label sacrificeFlyLabel;
    private Label walksAllowedLabel;
    private Label strikeOutLabel;
    private Label putoutLabel;
    private Label assistLabel;
    private Label leftOnBaseLabel;
    
    // returns the selected game date for the report to create/update
    public static String getReportGameDate() {
        return dateReport;
    }
    
    public void setReportGameDate(String dateReport) {
        this.dateReport = dateReport;
    }
    
    // returns the selected game date to create/update
    public static String getGameDate() {
        return date;
    }
    
    public void setGameDate(String date) {
        this.date = date;
    }
    
    @Override
    public void start(Stage primaryStage) {        
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);   
        
        // sets the size of the window
        Scene scene = new Scene(grid, 500, 700);
        
        // creates a drop down combo box with game dates
        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll("Feb 14, 2020",
                                   "Feb 15, 2020",
                                   "Feb 16, 2020",
                                   "Feb 22, 2020",
                                   "Mar 11, 2020");
        comboBox.getSelectionModel().select(0);       
        date = (String) comboBox.getValue();        
        
        grid.add(new Label("Date of Game:"), 0, 0);
        grid.add(comboBox, 1, 0);        
        
        // sets the selected game date 
        EventHandler<ActionEvent> event = 
                  (ActionEvent e) -> {                      
                      date = (String) comboBox.getValue(); 
        }; 
  
        // Set on action 
        comboBox.setOnAction(event);
        
        grid.add(new Label("Player's Name:"), 0, 1);
        playerField = new TextField();
        grid.add(playerField, 1, 1);
        playerLabel = new Label();
        grid.add(playerLabel, 2, 1);
        
        grid.add(new Label("AB: (at-bats)"), 0, 2);
        atBatsField = new TextField();
        grid.add(atBatsField, 1, 2);
        atBatsLabel = new Label();
        grid.add(atBatsLabel, 2, 2);
        
        grid.add(new Label("R: (runs scored)"), 0, 3);
        runsScoredField = new TextField();
        grid.add(runsScoredField, 1, 3);
        runsScoredLabel = new Label();
        grid.add(runsScoredLabel, 2, 3);
        
        grid.add(new Label("H/1B: (base hits, singles)"), 0, 4);
        baseHitsField = new TextField();
        grid.add(baseHitsField, 1, 4);
        baseHitsLabel = new Label();
        grid.add(baseHitsLabel, 2, 4);
        
        grid.add(new Label("2B: (doubles)"), 0, 5);
        doubleField = new TextField();
        grid.add(doubleField, 1, 5);
        doubleLabel = new Label();
        grid.add(doubleLabel, 2, 5);
        
        grid.add(new Label("3B: (triples)"), 0, 6);
        tripleField = new TextField();
        grid.add(tripleField, 1, 6);
        tripleLabel = new Label();
        grid.add(tripleLabel, 2, 6);
        
        grid.add(new Label("HR: (home runs)"), 0, 7);
        homeRunField = new TextField();
        grid.add(homeRunField, 1, 7);
        homeRunLabel = new Label();
        grid.add(homeRunLabel, 2, 7);
        
        grid.add(new Label("HBP: (hit by pitch)"), 0, 8);
        hitByPitchField = new TextField();
        grid.add(hitByPitchField, 1, 8);
        hitByPitchLabel = new Label();
        grid.add(hitByPitchLabel, 2, 8);
        
        grid.add(new Label("RBI: (runs batted in)"), 0, 9);
        runsBattedInField = new TextField();
        grid.add(runsBattedInField, 1, 9);
        runsBattedInLabel = new Label();
        grid.add(runsBattedInLabel, 2, 9);
        
        grid.add(new Label("SF: (sacrifice fly)"), 0, 10);
        sacrificeFlyField = new TextField();
        grid.add(sacrificeFlyField, 1, 10);
        sacrificeFlyLabel = new Label();
        grid.add(sacrificeFlyLabel, 2, 10);
        
        grid.add(new Label("BB: (walks allowed)"), 0, 11);
        walksAllowedField = new TextField();
        grid.add(walksAllowedField, 1, 11);
        walksAllowedLabel = new Label();
        grid.add(walksAllowedLabel, 2, 11);
        
        grid.add(new Label("SO: (strike out)"), 0, 12);
        strikeOutField = new TextField();
        grid.add(strikeOutField, 1, 12);
        strikeOutLabel = new Label();
        grid.add(strikeOutLabel, 2, 12);
        
        grid.add(new Label("PO: (putout)"), 0, 13);
        putoutField = new TextField();
        grid.add(putoutField, 1, 13);
        putoutLabel = new Label();
        grid.add(putoutLabel, 2, 13);
        
        grid.add(new Label("A: (assist)"), 0, 14);
        assistField = new TextField();
        grid.add(assistField, 1, 14);
        assistLabel = new Label();
        grid.add(assistLabel, 2, 14);
        
        grid.add(new Label("LOB: (left on base)"), 0, 15);
        leftOnBaseField = new TextField();
        grid.add(leftOnBaseField, 1, 15);
        leftOnBaseLabel = new Label();
        grid.add(leftOnBaseLabel, 2, 15);
        
        Button submitButton = new Button("Submit Player Stats");
        submitButton.setOnAction(e -> 
        {
            submitPSButtonClicked();           
        });
        
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().add(submitButton);       
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(buttonBox, 1, 16);
        
        // Combo box for batter report
        ComboBox comboBox2 = new ComboBox();
        comboBox2.getItems().addAll("Feb 14, 2020",
                                   "Feb 15, 2020",
                                   "Feb 16, 2020",
                                   "Feb 22, 2020",
                                   "Mar 11, 2020");
        comboBox2.getSelectionModel().select(0);       
        dateReport = (String) comboBox2.getValue();
        
        grid.add(new Label("Select date:"), 0, 19);
        grid.add(comboBox2, 1, 19);        
        
        // sets the game date for the report
        EventHandler<ActionEvent> event2 = 
                  (ActionEvent e) -> {                    
                      dateReport = (String) comboBox2.getValue(); 
        }; 
  
        // Set on action 
        comboBox2.setOnAction(event2);
        
        Button reportButton = new Button("Create Player Report");
        reportButton.setOnAction(e -> 
        {
            submitReportButtonClicked();           
        });       
        
        HBox buttonBox2 = new HBox(10);
        buttonBox2.getChildren().add(reportButton);       
        buttonBox2.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(buttonBox2, 2, 19);
        
        primaryStage.setTitle("Batter Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void submitPSButtonClicked() {      
        
        // set error messages in labels
        Validation v = new Validation();
        
        // displays required field labels if empty
        playerLabel.setText(v.isPresent(playerField.getText(), "Player") );
        atBatsLabel.setText(v.isPresent(atBatsField.getText(), "AB") );
        runsScoredLabel.setText(v.isPresent(runsScoredField.getText(), "R") );
        baseHitsLabel.setText(v.isPresent(baseHitsField.getText(), "H") );
        doubleLabel.setText(v.isPresent(doubleField.getText(), "2B") );
        tripleLabel.setText(v.isPresent(tripleField.getText(), "3B") );
        homeRunLabel.setText(v.isPresent(homeRunField.getText(), "HR") );
        hitByPitchLabel.setText(v.isPresent(hitByPitchField.getText(), "HBP") );
        runsBattedInLabel.setText(v.isPresent(runsBattedInField.getText(), "RBI") );
        sacrificeFlyLabel.setText(v.isPresent(sacrificeFlyField.getText(), "SF") );
        walksAllowedLabel.setText(v.isPresent(walksAllowedField.getText(), "BB") );
        strikeOutLabel.setText(v.isPresent(strikeOutField.getText(), "SO") );
        putoutLabel.setText(v.isPresent(putoutField.getText(), "PO") );
        assistLabel.setText(v.isPresent(assistField.getText(), "A") );
        leftOnBaseLabel.setText(v.isPresent(leftOnBaseField.getText(), "LOB") );
        
        // check if all error labels are empty
        // if all fields have input, validate, then add info to batter file
        if (playerLabel.getText().isEmpty() && 
            atBatsLabel.getText().isEmpty() && 
            runsScoredLabel.getText().isEmpty() &&
            baseHitsLabel.getText().isEmpty() &&
            doubleLabel.getText().isEmpty() &&
            tripleLabel.getText().isEmpty() &&
            homeRunLabel.getText().isEmpty() &&
            hitByPitchLabel.getText().isEmpty() &&
            runsBattedInLabel.getText().isEmpty() &&
            sacrificeFlyLabel.getText().isEmpty() &&
            walksAllowedLabel.getText().isEmpty() && 
            strikeOutLabel.getText().isEmpty() && 
            putoutLabel.getText().isEmpty() && 
            assistLabel.getText().isEmpty() && 
            leftOnBaseLabel.getText().isEmpty() ) {
            
            // check if entries are numbers, except for name
            atBatsLabel.setText(v.isInteger(atBatsField.getText(), "AB") );
            runsScoredLabel.setText(v.isInteger(runsScoredField.getText(), "R") );
            baseHitsLabel.setText(v.isInteger(baseHitsField.getText(), "H") );
            doubleLabel.setText(v.isInteger(doubleField.getText(), "2B") );
            tripleLabel.setText(v.isInteger(tripleField.getText(), "3B") );
            homeRunLabel.setText(v.isInteger(homeRunField.getText(), "HR") );
            hitByPitchLabel.setText(v.isInteger(hitByPitchField.getText(), "HBP") );
            runsBattedInLabel.setText(v.isInteger(runsBattedInField.getText(), "RBI") );
            sacrificeFlyLabel.setText(v.isInteger(sacrificeFlyField.getText(), "SF") );
            walksAllowedLabel.setText(v.isInteger(walksAllowedField.getText(), "BB") );
            strikeOutLabel.setText(v.isInteger(strikeOutField.getText(), "SO") );
            putoutLabel.setText(v.isInteger(putoutField.getText(), "PO") );
            assistLabel.setText(v.isInteger(assistField.getText(), "A") );
            leftOnBaseLabel.setText(v.isInteger(leftOnBaseField.getText(), "LOB") );
            
            // check if all error labels are empty
            // if all fields have valid input, then add info to batter file
            if (atBatsLabel.getText().isEmpty() && 
                runsScoredLabel.getText().isEmpty() &&
                baseHitsLabel.getText().isEmpty() &&
                doubleLabel.getText().isEmpty() &&
                tripleLabel.getText().isEmpty() &&
                homeRunLabel.getText().isEmpty() &&
                hitByPitchLabel.getText().isEmpty() &&
                runsBattedInLabel.getText().isEmpty() &&
                sacrificeFlyLabel.getText().isEmpty() &&
                walksAllowedLabel.getText().isEmpty() && 
                strikeOutLabel.getText().isEmpty() && 
                putoutLabel.getText().isEmpty() && 
                assistLabel.getText().isEmpty() && 
                leftOnBaseLabel.getText().isEmpty() ) {
                
                // addBatter() method adds stats to file
                FILE = new BatterFile();
                addBatter();               
            }            
        }               
    }
    
    public void submitReportButtonClicked() {
        
        
        /*  Formulas for calculating BA, TB, SLG & OBP
        ------------------------------------------------------------------------      
            Batting Average = Total number of hits / Total number of at bats       
        
            The total bases is calculated in the following way, where TB is the 
            total bases and 1B, 2B, 3B, and HR are the number of singles, 
            doubles, triples, and home runs, respectively. 
            TB = 1B + 2 × 2B + 3 × 3B + 4 × HR or
            [H + 2B + (2 × 3B) + (3 × HR)] or 
            [1B + (2 × 2B) + (3 × 3B) + (4 × HR)]
        
            Slugging Percentage (SLG) = Total Bases ÷ At Bats       
         
            On-base percentage is calculated using the following formula, 
            where H is Hits, BB is Bases on Balls (Walks), HBP is times Hit By a 
            Pitch, AB is At bats, and SF is Sacrifice Flies. 
            OBP = (H + BB + HBP) / (AB + BB + HBP + SF)
        ------------------------------------------------------------------------
        */
        
        // sets the game date so BatterFile.java can get the correct file to write to
        fileName = getReportGameDate();       
        setGameDate(fileName);
        
        FILE = new BatterFile();
        List<Batter> batters = FILE.getAll();
        FILE_REPORT = new BatterReportTextFile();      
        
        Batter b;
        StringBuilder sb = new StringBuilder();
        int batterID = 1;       
        
        for (int i = 0; i < batters.size(); i++) {
            
            b = batters.get(i);
            
            String playerName = b.getPlayerName();
            
            // calculate batting average
            double baseHits = b.getBaseHits();            
            double atBats = b.getAtBats();           
            double batAvg = baseHits / atBats;
            batAvg = (double) Math.round(batAvg * 1000) / 1000;           
            
            // calculate total bases
            double doubles = b.getDoubles();
            double triples = b.getTriples();
            double homeRuns = b.getHomeRuns();
            double totalBases = (baseHits + (2 * doubles) + (3 * triples) + (4 * homeRuns));
            totalBases = (double) Math.round(totalBases * 1000) / 1000;           
            
            // calculate slugging percentage
            double slugPer = totalBases / atBats;
            slugPer = (double) Math.round(slugPer * 1000) / 1000;            
            
            // calculate on-base percentage
            int walksAllowed = b.getWalksAllowed();
            int hitsByPitch = b.getHitByPitch();
            int sacrificeFly = b.getSacrificeFly();
            double basePer = (baseHits + walksAllowed + hitsByPitch) / (atBats + walksAllowed + hitsByPitch + sacrificeFly);
            basePer = (double) Math.round(basePer * 1000) / 1000;
            
            // if the set file name equals the chosen report date, do the following
            if (fileName.equals(dateReport)) {
                
                String playerNameReport = b.getPlayerName();
                int atBatsReport = b.getAtBats();
                int runsScoredReport = b.getRunsScored();
                int baseHitsReport = b.getBaseHits();
                int doublesReport = b.getDoubles();
                int triplesReport = b.getTriples();
                int homeRunsReport = b.getHomeRuns();
                int hitByPitchReport = b.getHitByPitch();
                int runsBattedInReport = b.getRunsBattedIn();
                int sacrificeFlyReport = b.getSacrificeFly();
                int walksAllowedReport = b.getWalksAllowed();
                int strikeOutReport = b.getStrikeOut();
                int putoutReport = b.getPutout();
                int assistReport = b.getAssist();
                int leftOnBaseReport = b.getLeftOnBase();
                
                String dateReport = getGameDate();
                setReportGameDate(dateReport);
                
                BatterReport br = new BatterReport(playerNameReport, atBatsReport, 
                                      runsScoredReport, baseHitsReport, doublesReport, triplesReport, 
                                      homeRunsReport, hitByPitchReport, runsBattedInReport, sacrificeFlyReport, 
                                      walksAllowedReport, strikeOutReport, putoutReport, assistReport, 
                                      leftOnBaseReport, batterID, playerName, batAvg, totalBases, 
                                      slugPer, basePer);
                
                sb.append(Integer.toString(batterID)).append(". ").
                   append("Player: ").append(b.getPlayerName()).append("\n").
                   append("\t" + "(AB): ").append(b.getAtBats()).append(" | ").
                   append("(R): ").append(b.getRunsScored()).append(" | ").
                   append("(H/1B): ").append(b.getBaseHits()).append(" | ").
                   append("(2B): ").append(b.getDoubles()).append(" | ").
                   append("(3B): ").append(b.getTriples()).append(" | ").
                   append("(HR): ").append(b.getHomeRuns()).append(" | ").
                   append("(HBP): ").append(b.getHitByPitch()).append(" | ").
                   append("(RBI): ").append(b.getRunsBattedIn()).append(" | ").
                   append("(SF): ").append(b.getSacrificeFly()).append(" | ").
                   append("(BB): ").append(b.getWalksAllowed()).append(" | ").
                   append("(SO): ").append(b.getStrikeOut()).append(" | ").
                   append("(PO): ").append(b.getPutout()).append(" | ").
                   append("(A): ").append(b.getAssist()).append(" | ").
                   append("(LOB): ").append(b.getLeftOnBase()).append("\n").
                   append("\t" + "Batting Average: ").append(batAvg).
                   append(" | Total Bases: ").append(totalBases).                
                   append(" | Slugging Percentage: ").append(slugPer).
                   append(" | On-Base Percentage: ").append(basePer).
                   append("\n");
                batterID++;
                
                // adds BatterReport Object to file               
                FILE_REPORT.add(br);                
            }                       
        }               
        
        // displays the generated report to the user
        Alert reportAlert = new Alert(Alert.AlertType.INFORMATION);
        reportAlert.setResizable(true);        
        reportAlert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        reportAlert.getDialogPane().setMinWidth(800);
        reportAlert.setTitle("Batter Report");
        reportAlert.setHeaderText("Batter Report for Game Date: " + dateReport);
        reportAlert.setContentText(sb.toString());      
        reportAlert.showAndWait();      
    }
    
    public void addBatter() {
        
        // adds text fields to variables
        String playerName = playerField.getText();
        int atBats = Integer.parseInt(atBatsField.getText());
        int runsScored = Integer.parseInt(runsScoredField.getText());
        int baseHits = Integer.parseInt(baseHitsField.getText());
        int doubles = Integer.parseInt(doubleField.getText());
        int triples = Integer.parseInt(tripleField.getText());
        int homeRuns = Integer.parseInt(homeRunField.getText());
        int hitByPitch = Integer.parseInt(hitByPitchField.getText());
        int runsBattedIn = Integer.parseInt(runsBattedInField.getText());
        int sacrificeFly = Integer.parseInt(sacrificeFlyField.getText());
        int walksAllowed = Integer.parseInt(walksAllowedField.getText());
        int strikeOut = Integer.parseInt(strikeOutField.getText());
        int putout = Integer.parseInt(putoutField.getText());
        int assist = Integer.parseInt(assistField.getText());
        int leftOnBase = Integer.parseInt(leftOnBaseField.getText());
        
        // prints variables to console
        // uncomment for debugging
//        System.out.println("Date: " + date);
//        System.out.println("Name: " + playerName);
//        System.out.println("At-Bats: " + atBats);
//        System.out.println("Runs Scored: " + runsScored);
//        System.out.println("Base Hits: " + baseHits);
//        System.out.println("Doubles: " + doubles);
//        System.out.println("Triples: " + triples);
//        System.out.println("Home Runs: " + homeRuns);
//        System.out.println("Hit By Pitch: " + hitByPitch);
//        System.out.println("Runs Batted In: " + runsBattedIn);
//        System.out.println("Sacrifice Fly: " + sacrificeFly);
//        System.out.println("Walks Allowed: " + walksAllowed);
//        System.out.println("Strike Out: " + strikeOut);
//        System.out.println("Putout: " + putout);
//        System.out.println("Assist: " + assist);
//        System.out.println("Left on Base: " + leftOnBase);      
        
        Batter newBatter = new Batter(playerName, atBats, runsScored, 
                                      baseHits, doubles, triples, homeRuns, 
                                      hitByPitch, runsBattedIn, sacrificeFly, 
                                      walksAllowed, strikeOut, putout, assist, 
                                      leftOnBase);
        
        // adds newBatter Object to file
        FILE.add(newBatter);

        System.out.println("This entry has been saved.\n");
    }

    // main method
    // add updates here:
    //
    public static void main(String[] args) {
        launch(args);
    }   
}
