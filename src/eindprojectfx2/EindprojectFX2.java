/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Vermeulen
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
	
	public static void main(String[] args) {
		launch(args);

	}

}
