package Model;

import java.awt.Color;
import java.awt.Shape;

/**
 *
 * @author Chriss Yañez
 */
public class Cuadros {

    private int lineas;
    private String nombre;
    private Shape shape;
    private Color color;

    public Cuadros(int lineas, String nombre, Shape shape, Color color) {
        this.lineas = lineas;
        this.nombre = nombre;
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

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public int getLineas() {
        return lineas;
    }

    public void setLineas(int lineas) {
        this.lineas = lineas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
