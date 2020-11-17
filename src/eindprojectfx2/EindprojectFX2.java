package eindprojectfx2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * De klasse EindProjectFX2 is de applicatieklasse van dit project.
 * De klasse initialiseert de pane en scene en instantieert een EindProject2.
 * @author Vermeulen
 * @version 1.0
 * @see EindProject2
 */
public class EindprojectFX2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
 		Pane root = new Pane(); 
		Scene scene = new Scene(root,1300,750);
		
		new EindProject2(root); //Aanroep klasse EindProject2
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Reflexion");
		primaryStage.show();
	}
	
    /**
     * De main methode is de methode waarin de applicatie wordt uitgevoerd.
     * @param args argumenten waarmee de applicatie wordt gestart.
     */
    public static void main(String[] args) {
		launch(args);

	}

}
