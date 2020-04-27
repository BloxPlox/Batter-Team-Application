/*
 * Title: Final Project
 * Date: 4-23-20
 * Author: James Nagy
 */

/* 
    BatterGUI Acronyms
    --------------------
    AB : at-bats
    R : runs scored
    H : base hits
    RBI : runs batted in
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

// import statements
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// batter class
// add updates here:
// James Nagy: 4-24-20 - added text fields, labels, and combo box for user input 
public class BatterGUI extends Application {
    
    private static final BatterFile FILE = new BatterFile();
    
    public String date;
    public TextField playerField;
    public TextField atBatsField;
    public TextField runsScoredField;
    public TextField baseHitsField;
    public TextField runsBattedInField;
    public TextField walksAllowedField;
    public TextField strikeOutField;
    public TextField putoutField;
    public TextField assistField;
    public TextField leftOnBaseField;
    
    private Label dateLabel;
    private Label playerLabel;
    private Label atBatsLabel;
    private Label runsScoredLabel;
    private Label baseHitsLabel;
    private Label runsBattedInLabel;
    private Label walksAllowedLabel;
    private Label strikeOutLabel;
    private Label putoutLabel;
    private Label assistLabel;
    private Label leftOnBaseLabel;
    
    @Override
    public void start(Stage primaryStage) {
        
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);   
        
        Scene scene = new Scene(grid, 500, 500);
        
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
        dateLabel = new Label();
        grid.add(dateLabel, 2, 0);
        
        // Create action event 
        EventHandler<ActionEvent> event = 
                  (ActionEvent e) -> {
                      dateLabel.setText(comboBox.getValue() + " selected");
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
        
        grid.add(new Label("H: (base hits)"), 0, 4);
        baseHitsField = new TextField();
        grid.add(baseHitsField, 1, 4);
        baseHitsLabel = new Label();
        grid.add(baseHitsLabel, 2, 4);
        
        grid.add(new Label("RBI: (runs batted in)"), 0, 5);
        runsBattedInField = new TextField();
        grid.add(runsBattedInField, 1, 5);
        runsBattedInLabel = new Label();
        grid.add(runsBattedInLabel, 2, 5);
        
        grid.add(new Label("BB: (walks allowed)"), 0, 6);
        walksAllowedField = new TextField();
        grid.add(walksAllowedField, 1, 6);
        walksAllowedLabel = new Label();
        grid.add(walksAllowedLabel, 2, 6);
        
        grid.add(new Label("SO: (strike out)"), 0, 7);
        strikeOutField = new TextField();
        grid.add(strikeOutField, 1, 7);
        strikeOutLabel = new Label();
        grid.add(strikeOutLabel, 2, 7);
        
        grid.add(new Label("PO: (putout)"), 0, 8);
        putoutField = new TextField();
        grid.add(putoutField, 1, 8);
        putoutLabel = new Label();
        grid.add(putoutLabel, 2, 8);
        
        grid.add(new Label("A: (assist)"), 0, 9);
        assistField = new TextField();
        grid.add(assistField, 1, 9);
        assistLabel = new Label();
        grid.add(assistLabel, 2, 9);
        
        grid.add(new Label("LOB: (left on base)"), 0, 10);
        leftOnBaseField = new TextField();
        grid.add(leftOnBaseField, 1, 10);
        leftOnBaseLabel = new Label();
        grid.add(leftOnBaseLabel, 2, 10);
        
        Button submitButton = new Button("Submit Player Stats");
        submitButton.setOnAction(e -> 
        {
            submitPSButtonClicked();           
        });
        
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().add(submitButton);       
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(buttonBox, 1, 11);
        
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
        runsBattedInLabel.setText(v.isPresent(runsBattedInField.getText(), "RBI") );
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
            runsBattedInLabel.getText().isEmpty() && 
            walksAllowedLabel.getText().isEmpty() && 
            strikeOutLabel.getText().isEmpty() && 
            putoutLabel.getText().isEmpty() && 
            assistLabel.getText().isEmpty() && 
            leftOnBaseLabel.getText().isEmpty() ) {
            
            // check if entries are numbers, except for name
            atBatsLabel.setText(v.isInteger(atBatsField.getText(), "AB") );
            runsScoredLabel.setText(v.isInteger(runsScoredField.getText(), "R") );
            baseHitsLabel.setText(v.isInteger(baseHitsField.getText(), "H") );
            runsBattedInLabel.setText(v.isInteger(runsBattedInField.getText(), "RBI") );
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
                runsBattedInLabel.getText().isEmpty() && 
                walksAllowedLabel.getText().isEmpty() && 
                strikeOutLabel.getText().isEmpty() && 
                putoutLabel.getText().isEmpty() && 
                assistLabel.getText().isEmpty() && 
                leftOnBaseLabel.getText().isEmpty() ) {
                
                // addBatter() method adds stats to file
                addBatter();
            }            
        }               
    }
    
    public void addBatter() {
        
        System.out.println("Date: " + date);
        
        String playerName = playerField.getText();
        System.out.println("Name: " + playerName);
               
        int atBats = Integer.parseInt(atBatsField.getText());
        System.out.println("At-Bats: " + atBats);
        
        int runsScored = Integer.parseInt(runsScoredField.getText());
        System.out.println("Runs Scored: " + runsScored);
        
        int baseHits = Integer.parseInt(baseHitsField.getText());
        System.out.println("Base Hits: " + baseHits);
        
        int runsBattedIn = Integer.parseInt(runsBattedInField.getText());
        System.out.println("Runs Batted In: " + runsBattedIn);
        
        int walksAllowed = Integer.parseInt(walksAllowedField.getText());
        System.out.println("Walks Allowed: " + walksAllowed);
        
        int strikeOut = Integer.parseInt(strikeOutField.getText());
        System.out.println("Strike Out: " + strikeOut);
        
        int putout = Integer.parseInt(putoutField.getText());
        System.out.println("Putout: " + putout);
        
        int assist = Integer.parseInt(assistField.getText());
        System.out.println("Assist: " + assist);
        
        int leftOnBase = Integer.parseInt(leftOnBaseField.getText());
        System.out.println("Assist: " + leftOnBase);
        
        Batter newBatter = new Batter(date, playerName, atBats, runsScored, 
                                      baseHits, runsBattedIn, walksAllowed, 
                                      strikeOut, putout, assist, leftOnBase);
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
