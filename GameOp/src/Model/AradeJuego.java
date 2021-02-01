package Model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author Chriss Yañez
 */
public class AradeJuego extends JPanel {

    private final int valor;
    private final LinkedList<Cuadros> cuadros = new LinkedList();

    public AradeJuego(int valor) {
        this.valor = valor;
        init();
    }

    private void init() {
        int size = 15 + (20 * valor) + (20 * valor);
        this.setPreferredSize(new Dimension(size, size));
        this.setSize(this.getPreferredSize());
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        Shape fondo = new Rectangle2D.Double(0, 0,
                this.getPreferredSize().width,
                this.getPreferredSize().height);
        g2d.fill(fondo);
        g2d.setStroke(new BasicStroke(5));
        dibCirc(g2d);
        dibCua(g2d);

    }

    private void dibCirc(Graphics2D g2d) {
        int x;
        int y = 15;
        for (int i = 0; i < valor; i++) {
            x = 15;
            for (int j = 0; j < valor; j++) {
                g2d.setColor(Color.WHITE);
                Shape c = new Ellipse2D.Double(x, y, 10, 10);
                g2d.fill(c);
                x += 40;
            }
            y += 40;
        }
    }

    private void dibCua(Graphics2D g2d) {
        int x, y = 15;
        if (cuadros.isEmpty()) {
            for (int i = 0; i < (valor - 1); i++) {
                x = 25;
                for (int j = 0; j < (valor - 1); j++) {
                    LinkedList<Lines> line = new LinkedList();
                    Color c = Color.BLACK;
                    line.add(new Lines(new Rectangle2D.Double(x, y, 30, 10), c));
                    line.add(new Lines(new Rectangle2D.Double(x - 10, y + 10, 10, 30), c));
                    line.add(new Lines(new Rectangle2D.Double(x, y + 40, 30, 10), c));
                    line.add(new Lines(new Rectangle2D.Double(x + 30, y + 10, 10, 30), c));
                    cuadros.add(new Cuadros(null, line));
                    x += 40;
                }
                y += 40;
            }
        }
        cuadros.forEach(c -> {
            boolean p = false;
            for (Lines l : c.getShape()) {
                g2d.setColor(l.getColor());
                g2d.fill(l.getShape());
                if (c.getNombre() != null && !p) {
                     g2d.setColor(Color.WHITE);
                        Font font = new Font("Algerian", Font.BOLD, 16);
                        FontRenderContext frc = g2d.getFontRenderContext();
                        GlyphVector gv = font.createGlyphVector(frc, c.getNombre());
                        Shape fig = gv.getOutline(c.getFirst().x, c.getFirst().y + 25);
                        g2d.fill(fig);
                    p = true;
                }
            }
        });
    }

    public LinkedList<Cuadros> getCuadros() {
        return cuadros;
    }

}
