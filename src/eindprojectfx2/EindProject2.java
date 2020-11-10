/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eindprojectfx2;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author Vermeulen
 */
public class EindProject2 {
	Text tScore = new Text("Gemiddelde Score: ");
	Text tFouten = new Text("Fouten: ");
	Text tTijdGroen = new Text("Tijd Groen: ");
	Text tTijdRood = new Text("Tijd Rood: ");
	Text tTijdBlauw = new Text("Tijd Blauw: ");
	Text tTijdGeel = new Text("Tijd Geel: ");
        int spawnDelay = (int) (Math.random() * 120 + 61);
        int spawnTicker, score = 0;
        GraphicsContext gc;
        Canvas canvas = new Canvas(1050, 675);
	
	public EindProject2(Pane p) {
		Button bStartKnop = new Button("Start");
		Button bResetKnop = new Button("Reset");
		Button bGelKnop = new Button("Geluid: Aan");
		Button bGroenKnop = new Button("Groen");
		Button bRoodKnop = new Button("Rood");
		Button bBlauwKnop = new Button("Blauw");
		Button bGeelKnop = new Button("Geel");
		gc = canvas.getGraphicsContext2D();
                gc.strokeRect(1,1,1049,674);
                
		canvas.relocate(10, 10);
		bStartKnop.setPrefWidth(50);
		bResetKnop.setPrefWidth(50);
		bGelKnop.setPrefWidth(100);
		bGroenKnop.setPrefWidth(50);
		bRoodKnop.setPrefWidth(50);
		bBlauwKnop.setPrefWidth(50);
		bGeelKnop.setPrefWidth(50);
		tScore.relocate(1100, 100);
		tFouten.relocate(1100, 200);
		tTijdGroen.relocate(1100,300);
		tTijdRood.relocate(1100, 400);
		tTijdBlauw.relocate(1100, 500);
		tTijdGeel.relocate(1100,600);
		
		bStartKnop.relocate(10, 700);
		bResetKnop.relocate(80,700);
		bGelKnop.relocate(150, 700);
		bGroenKnop.relocate(300, 700);
		bRoodKnop.relocate(400, 700);
		bBlauwKnop.relocate(500, 700);
		bGeelKnop.relocate(600, 700);
		
		p.getChildren().addAll(canvas, bStartKnop, bResetKnop, bGelKnop, bGroenKnop, bRoodKnop, bBlauwKnop, bGeelKnop, tScore, tFouten, tTijdGroen, tTijdRood, tTijdBlauw, tTijdGeel);
				

		}
	
	
}
