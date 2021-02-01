package Model;

import java.awt.Color;

/**
 *
 * @author Chriss Yañez
 */
public class Jugador {

    private String nombre;
    private int puntos;
    private Color Color;

    public Jugador(String nombre, int puntos, Color Color) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.Color = Color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Color getColor() {
        return Color;
    }

    public void setColor(Color Color) {
        this.Color = Color;
    }

    public String getNick() {
        char c1 = this.getNombre().charAt(0);
        char c2 = this.getNombre().charAt(this.getNombre().length() - 1);
        return String.valueOf(c1) + String.valueOf(c2);
    }

}
