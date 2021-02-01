package Model;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;

/**
 *
 * @author Chriss Yañez
 */
public class Lines {
    
    private final Shape shape;
    private Color color;

    public Lines(Shape shape, Color color) {
        this.shape = shape;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Shape getShape() {
        return shape;
    }
    
    public Rectangle getBounds() {
        return this.getShape().getBounds();
    }
    
}
