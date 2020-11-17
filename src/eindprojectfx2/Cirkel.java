package eindprojectfx2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * De klasse cirkel is een subklasse van de superklasse vorm.
 * @see Vorm
 * @author Vermeulen
 */
public class Cirkel extends Vorm{

    /**
     * Tekent de cirkel op het canvas
     * @param gc de GraphicContext waarin de cirkel getekend wordt
     */
    public void draw(GraphicsContext gc) {
        if (visible) {
            gc.setFill(Color.GREEN);
            gc.fillOval(x, y, w, h);
        }
    }
}
