package Controller;

import Model.AradeJuego;
import Model.Cuadros;
import Model.Jugador;
import Model.Lines;
import Vista.Vta;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Chriss Yañez
 */
public class Mouse extends MouseAdapter {

    private final AradeJuego aj;
    private final Jugador j1;
    private final Jugador j2;
    private final Vta vta;

    public Mouse(Vta vta) {
        this.vta = vta;
        this.aj = vta.getaJ();
        this.j1 = vta.getJ1();
        this.j2 = vta.getJ2();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Rectangle r = new Rectangle(e.getX(), e.getY(), 5, 5);
        String next = vta.getTurno().getText();
        int pt = 0;
        boolean intersect = false;
        for (Cuadros c : aj.getCuadros()) {
            for (Lines l : c.getShape()) {
                if (l.getBounds().intersects(r) && l.getColor().equals(Color.BLACK)) {
                    Color col = (next.equals(j1.getNick())) ? j1.getColor() : j2.getColor();
                    l.setColor(col);
                    aj.repaint();
                    if (c.getLines() == 4) {
                        pt += 1;
                        c.setNombre(next);
                    }
                    intersect = true;
                }
            }
        }
        if (pt == 0 && intersect) {
            vta.getTurno().setText((next.equals(j1.getNick())) ? j2.getNick() : j1.getNick());
        } else {
            int ps;
            if (vta.getTurno().getText().equals(j1.getNick())) {
                ps = (j1.getPuntos() + pt);
                j1.setPuntos(ps);
                vta.getP().setText(String.valueOf(j1.getPuntos()));
            } else {
                ps = (j2.getPuntos() + pt);
                j2.setPuntos(ps);
                vta.getP2().setText(String.valueOf(j2.getPuntos()));
            }
        }
    }

}
