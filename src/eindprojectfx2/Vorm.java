package eindprojectfx2;

/**
 * De klasse vorm is de superklasse van de verschillende vormen, hierin staan de x en y-coordinaten, de grootte en de snelheid.
 * @author Vermeulen
 * @see Vierkant
 * @see Rechthoek
 * @see Driehoek
 * @see Cirkel
 */
public class Vorm {
    /**
     * publieke variabelen moeten toegankelijk zijn voor de subklassen.
     */
    public int x = (int) (1005 * Math.random() + 25);
    public int y = (int) (630 * Math.random() + 25);
    public int w = 20;
    public int h = 20;
    public boolean visible;

    private int dx = (int) (2 * Math.random() + 1);
    private int dy = (int) (1 * Math.random() + 1);


    
    /**
     * Initialiseert de vorm en zet hem op onzichtbaar
     */
    public Vorm(){
        this.visible = false;
    }

    /**
     * Levert de zichtbaarheid van de vorm
     * @return de zichtbaarheid van de vorm
     */
    public boolean getVisible(){
        return visible;
    }
    
    /**
     * Stelt de positie in op een nieuwe willekeurige plek
     */
    public void scrambleLocation(){
        x = (int) (1024 * Math.random() + 25);
        y = (int) (649 * Math.random() + 25);
    }

    /**
     * Stelt de zichtbaarheid in
     * @param visible de zichtbaarheid(true/false) van de vorm
     */
    public void setVisible(boolean visible){
        this.visible = visible;
    }
    
    /**
     * Verplaatst de vorm binnen de grenzen van het canvas
     */
    public void move(){
        if (x +dx <= 20 || x + dx + 25 >= 1030 )
            dx = -dx;
        if ( y + dy <= 20 || y + dy + 25 >= 655)
            dy = -dy;

        x += dx; y += dy;
    }
}
