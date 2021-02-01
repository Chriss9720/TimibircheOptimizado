package Model;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;

/**
 *
 * @author Chriss Yañez
 */
public class Cuadros {

    private String nombre;
    private final LinkedList<Lines> shape;

    public Cuadros(String nombre, LinkedList<Lines> shape) {
        this.nombre = nombre;
        this.shape = shape;
    }

    public int getLines() {
        int r = 0;
        for (Lines lines : shape) {
            r = (lines.getColor().equals(Color.BLACK)) ? 0 : r + 1;
        }
        return r;
    }

    public LinkedList<Lines> getShape() {
        return shape;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Point getFirst() {
        return new Point(this.getShape().getFirst().getBounds().x,
                this.getShape().getFirst().getBounds().y);
    }

}
