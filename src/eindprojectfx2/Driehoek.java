
package eindprojectfx2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


/**
 * De klasse driehoek is een subklasse van de superklasse vorm.
 * @see Vorm
 * @author Vermeulen
 */

public class Driehoek extends Vorm{
    /**
     * Tekent de driehoek op het canvas
     * @param gc de GraphicContext waarin de driehoek getekend wordt
     */
    public void draw(GraphicsContext gc) {
        if (visible) {
            gc.setFill(Color.BLUE);
            gc.fillPolygon(new double[]{x-w/2,x,x+w/2}, new double[]{y+h/2,y-h/2,y+h/2},3);
        }
    }
}

