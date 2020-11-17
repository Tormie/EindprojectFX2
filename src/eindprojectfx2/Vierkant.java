package eindprojectfx2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * De klasse vierkant is een subklasse van de superklasse vorm.
 * @see Vorm
 * @author Vermeulen
 */
public class Vierkant extends Vorm{

    /**
     * Tekent het vierkant op het canvas
     * @param gc de GraphicContext waarin het vierkant getekend wordt
     */
    public void draw(GraphicsContext gc) {
        if (visible) {
            gc.setFill(Color.RED);
            gc.fillRect(x, y, w, h);
        }
    }
}
