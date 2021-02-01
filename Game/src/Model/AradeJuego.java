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

    private final LinkedList<Cuadros> pts = new LinkedList();
    private final LinkedList<Cuadros> lines = new LinkedList();
    private final int valor;

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
        int y = 20;
        int x = 20;
        if (pts.isEmpty()) {
            for (int i = 0; i < (valor - 1); i++) {
                for (int j = 0; j < (valor - 1); j++) {
                    pts.add(new Cuadros(0, null,
                            new Rectangle2D.Double(x, y, 40, 40), Color.BLACK));
                    g2d.setColor(pts.getLast().getColor());
                    g2d.draw(pts.getLast().getShape());
                    x += 40;
                }
                x = 20;
                y += 40;
            }
        } else {
            pts.forEach(i -> {
                g2d.setColor(i.getColor());
                g2d.draw(i.getShape());
                if (i.getNombre() != null) {
                    try {
                        g2d.setColor(Color.WHITE);
                        Font font = new Font("Algerian", Font.BOLD, 16);
                        FontRenderContext frc = g2d.getFontRenderContext();
                        GlyphVector gv = font.createGlyphVector(frc, i.getNombre());
                        Shape fig = gv.getOutline(i.getShape().getBounds().x + 10,
                                i.getShape().getBounds().y + 20);
                        g2d.fill(fig);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            });
        }
        if (lines.isEmpty()) {
            x = 20;
            y = 20;
            for (int i = 0; i < valor; i++) {
                for (int j = 0; j < (valor - 1); j++) {
                    lines.add(new Cuadros(0, null,
                            new Rectangle2D.Double(x, y, 40, 1), Color.BLACK));
                    g2d.setColor(lines.getLast().getColor());
                    g2d.draw(lines.getLast().getShape());
                    x += 40;
                }
                y += 40;
                x = 20;
            }
            x = 20;
            y = 20;
            for (int i = 0; i < valor; i++) {
                for (int j = 0; j < (valor - 1); j++) {
                    lines.add(new Cuadros(0, null,
                            new Rectangle2D.Double(x, y, 1, 40), Color.BLACK));
                    g2d.setColor(lines.getLast().getColor());
                    g2d.draw(lines.getLast().getShape());
                    y += 40;
                }
                y = 20;
                x += 40;
            }
        } else {
            lines.forEach(i -> {
                g2d.setColor(i.getColor());
                g2d.draw(i.getShape());
            });
        }
        y = 15;
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

    public LinkedList<Cuadros> getPts() {
        return pts;
    }

    public LinkedList<Cuadros> getLines() {
        return lines;
    }

}
