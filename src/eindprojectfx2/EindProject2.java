package eindprojectfx2;

import java.util.ArrayList;
import java.util.Timer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * De klasse EindProject2 is de 'hoofdklasse' van dit project.
 * De klasse initialiseert alle schermobjecten en realiseert de functionaliteit van de knoppen
 * @author Vermeulen
 * @version 1.0
 * @see EindProjectFX2
 * @see Vierkant
 * @see Rechthoek
 * @see Driehoek
 * @see Cirkel
 */
public class EindProject2 {
        //initialisatie van de verschillende variabelen.

    /**
     *
     */
        public Timer timer;
        long start, finish;
        ArrayList<Integer> lScores;
	Text tScore = new Text("Gemiddelde Score: ");
	Text tFouten = new Text("Fouten: ");
	Text tTijdGroen = new Text("Score Groen: ");
	Text tTijdRood = new Text("Score Rood: ");
	Text tTijdBlauw = new Text("Score Blauw: ");
	Text tTijdGeel = new Text("Score Geel: ");
        int spawnDelay = (int) (Math.random() * 120 + 61),spawnTicker = 0, score = 0, errors = 0;
        boolean gameRunning = false, objectVisible = false;
        GraphicsContext gc;
        Canvas canvas = new Canvas(1050, 675);
        private Rechthoek rechthoek;
        private Cirkel cirkel;
        private Driehoek driehoek;
        private Vierkant vierkant;
	
        /**
         * Initieert het scherm en de invulling doormiddel van de verschillende knoppen en textvelden
         * @param p het Pane waarin de objecten moeten worden geplaatst
         */
        
	public EindProject2(Pane p) {
            lScores = new ArrayList<>();
            Button bStartKnop = new Button("Start");
            Button bResetKnop = new Button("Reset");
            Button bGroenKnop = new Button("Groen");
            Button bRoodKnop = new Button("Rood");
            Button bBlauwKnop = new Button("Blauw");
            Button bGeelKnop = new Button("Geel");
            gc = canvas.getGraphicsContext2D();
            gc.strokeRect(1,1,1049,674);
            vierkant = new Vierkant();
            cirkel = new Cirkel();
            driehoek = new Driehoek();
            rechthoek = new Rechthoek();

            vierkant.draw(gc);
            cirkel.draw(gc);
            driehoek.draw(gc);
            rechthoek.draw(gc);

            canvas.relocate(10, 10);
            bStartKnop.setPrefWidth(100);
            bResetKnop.setPrefWidth(100);
            bGroenKnop.setPrefWidth(100);
            bRoodKnop.setPrefWidth(100);
            bBlauwKnop.setPrefWidth(100);
            bGeelKnop.setPrefWidth(100);
            tScore.relocate(1100, 100);
            tFouten.relocate(1100, 200);
            tTijdGroen.relocate(1100,300);
            tTijdRood.relocate(1100, 400);
            tTijdBlauw.relocate(1100, 500);
            tTijdGeel.relocate(1100,600);

            bStartKnop.relocate(10, 700);
            bResetKnop.relocate(110,700);
            bGroenKnop.relocate(300, 700);
            bRoodKnop.relocate(400, 700);
            bBlauwKnop.relocate(500, 700);
            bGeelKnop.relocate(600, 700);

            p.getChildren().addAll(canvas, bStartKnop, bResetKnop, bGroenKnop, bRoodKnop, bBlauwKnop, bGeelKnop, tScore, tFouten, tTijdGroen, tTijdRood, tTijdBlauw, tTijdGeel);
            
            //Knoppenfunctionaliteiten
            
            bStartKnop.setOnAction(event -> {
                gameRunning = true;
            });
            bResetKnop.setOnAction(event -> {
                Reset();
            });
            bGroenKnop.setOnAction(event -> {
                if (cirkel.getVisible()){
                    finish = System.currentTimeMillis();
                    cirkel.setVisible(false);
                    objectVisible = false;
                    tTijdGroen.setText("Score Groen: " +Integer.toString((int) finish - (int)start));
                    lScores.add((int) finish - (int)start);
                    spawnTicker = 0;
                    CalculateScore();
                    tScore.setText("Gemiddelde Score: " +score);
                } else {
                    errors += 1;
                    tFouten.setText("Fouten; " + errors);
                }
            });
            bRoodKnop.setOnAction(event -> {
                if (vierkant.getVisible()){
                    finish = System.currentTimeMillis();
                    vierkant.setVisible(false);
                    objectVisible = false;
                    tTijdRood.setText("Score Rood: " +Integer.toString((int) finish - (int)start));
                    lScores.add((int) finish - (int)start);
                    spawnTicker = 0;
                    CalculateScore();
                    tScore.setText("Gemiddelde Score: " +score);
                } else {
                    errors += 1;
                    tFouten.setText("Fouten; " + errors);
                }
            });
            bBlauwKnop.setOnAction(event -> {
                if (driehoek.getVisible()){
                    finish = System.currentTimeMillis();
                    driehoek.setVisible(false);
                    objectVisible = false;
                    tTijdBlauw.setText("Score Blauw: " +Integer.toString((int) finish - (int)start));
                    lScores.add((int) finish - (int)start);
                    spawnTicker = 0;
                    CalculateScore();
                    tScore.setText("Gemiddelde Score: " +score);
                } else {
                    errors += 1;
                    tFouten.setText("Fouten; " + errors);
                }
            });
            bGeelKnop.setOnAction(event -> {
                if (rechthoek.getVisible()){
                    finish = System.currentTimeMillis();
                    rechthoek.setVisible(false);
                    objectVisible = false;
                    tTijdGeel.setText("Score Geel: " +Integer.toString((int) finish - (int)start));
                    lScores.add((int) finish - (int)start);
                    spawnTicker = 0;
                    CalculateScore();
                    tScore.setText("Gemiddelde Score: " +score);
                } else {
                    errors += 1;
                    tFouten.setText("Fouten; " + errors);
                }
            });
            
            //Initialiseert de gameloop, waarin de verschillende tijdsgebonden elementen plaatsvinden.
            GameLoop();
	}
        /**
         * Losse functie om de gemiddelde score te berekenen op basis van de ArrayList.
         */
        public void CalculateScore(){
            score = 0;
            if(!lScores.isEmpty()) {
                for (int mark : lScores) {
                    score += mark;
                }
                score = score / lScores.size();
            }
        }
        
        /**
         * Losse functie om een van de vier vormen willekeurig actief te zetten.
         */
        public void TriggerShape(){
            int choice = (int) (4 * Math.random() + 1); // Kies een willekeurige waarde van 1 t/m 4 en laat op basis daarvan één van de vormen zien.
            switch (choice){
                case 1:
                    vierkant.setVisible(true);
                    break;
                case 2:
                    cirkel.setVisible(true);
                    break;
                case 3:
                    driehoek.setVisible(true);
                    break;
                case 4:
                    rechthoek.setVisible(true);
                    break;
            }
        }
        
        /**
         * Losse functie om alle waarden te resetten en het spel opnieuw te kunnen spelen.
         */
        public void Reset(){
            score = 0;
            lScores.clear();
            errors = 0;
            spawnTicker = 0;
            vierkant.setVisible(false);
            vierkant.scrambleLocation();
            cirkel.setVisible(false);
            cirkel.scrambleLocation();
            driehoek.setVisible(false);
            driehoek.scrambleLocation();
            rechthoek.setVisible(false);
            rechthoek.scrambleLocation();
            gameRunning = false;
            spawnDelay = (int) (Math.random() * 120 + 61);
            tScore = new Text("Gemiddelde Score: ");
            tFouten = new Text("Fouten: ");
            tTijdGroen = new Text("Tijd Groen: ");
            tTijdRood = new Text("Tijd Rood: ");
            tTijdBlauw = new Text("Tijd Blauw: ");
            tTijdGeel = new Text("Tijd Geel: ");
            
        }
        
        /**
         * Losse functie om de zgn 'gameloop' uit te voeren op een specifieke timer, namelijk 60 per 1000 ms.
         */
        
        public void GameLoop(){ //initialize new loop with timer
            timer = new Timer();
            timer.schedule(new Loop(), 0, 1000 / 60);
        }
        
        /**
         * De zogenaamde 'gameloop'. Hierin vinden alle actieve acties plaats.
         * Gebaseerd op een TimerTask, een taak die op een timer wordt uitgevoerd.
         */
        public class Loop extends java.util.TimerTask
        {
            public void run() //this becomes the loop
            {
                if (gameRunning){  
                    spawnTicker++;
                    if (spawnTicker >= spawnDelay && !objectVisible){
                        start = System.currentTimeMillis();
                        TriggerShape();
                        
                        objectVisible = true;
                        spawnDelay = (int) (Math.random() * 120 + 61);
                    }
                    gc.clearRect(3,3,1044,670);
                    vierkant.move();
                    cirkel.move();
                    rechthoek.move();
                    driehoek.move();
                    vierkant.draw(gc);
                    cirkel.draw(gc);
                    driehoek.draw(gc);
                    rechthoek.draw(gc);
                }
            }
        }
        
	
	
}
