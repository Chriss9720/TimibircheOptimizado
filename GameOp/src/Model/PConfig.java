package Model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

/**
 *
 * @author Chriss Yañez
 */
public class PConfig extends JPanel {

    public PConfig() {
        init();
    }

    private void init() {
        this.setPreferredSize(new Dimension(400, 200));
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        Shape s = new Line2D.Double(199, 0, 199, 120);
        g2d.draw(s);
    }

}
