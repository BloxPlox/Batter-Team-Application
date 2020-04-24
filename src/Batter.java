/*
 * Title: Final Project
 * Date: 4-23-20
 * Author: James Nagy
 */

// import statements
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// batter class
// add updates here:
// 
public class Batter extends Application {
    
    /* 
    Batter Acronyms
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
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Batter Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // main method
    // add updates here:
    //
    public static void main(String[] args) {
        launch(args);
    }
    
}
