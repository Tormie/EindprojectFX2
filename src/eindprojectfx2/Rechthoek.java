package eindprojectfx2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * De klasse rechthoek is een subklasse van de superklasse vorm.
 * @see Vorm
 * @author Vermeulen
 */
public class Rechthoek extends Vorm{

    /**
     * Tekent de rechthoek op het canvas
     * @param gc de GraphicContext waarin de rechthoek getekend wordt
     */
    public void draw(GraphicsContext gc) {
        if (visible) {
            gc.setFill(Color.YELLOW);
            gc.fillRect(x, y, w, h*2);
        }
    }
}
