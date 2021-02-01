package Controller;

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

    private final Vta vta;
    private boolean sig;

    public Mouse(Vta vta) {
        this.vta = vta;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Rectangle r = new Rectangle(e.getX(), e.getY(), 10, 10);
        sig = true;
        vta.getaJ().getLines().forEach(i -> { //Linea
            if (i.getShape().getBounds().intersects(r) && i.getColor().equals(Color.BLACK)) {
                for (int j = 0, k = 0; j < vta.getaJ().getPts().size() && k != 2; j++) { //cuadro
                    if (vta.getaJ().getPts().get(j).getShape().getBounds().intersects(r)) {
                        vta.getaJ().getPts().get(j).setLineas(
                                vta.getaJ().getPts().get(j).getLineas() + 1);
                        if (sig) {
                            sig = !(vta.getaJ().getPts().get(j).getLineas() == 4
                                    && vta.getaJ().getPts().get(j).getNombre() == null);
                            if (!sig) {
                                System.out.println("ok");
                                if (vta.getTurno().getText().equals(vta.getJ1().getNick())) {
                                    vta.getJ1().setPuntos(vta.getJ1().getPuntos() + 1);
                                    vta.getP().setText(String.valueOf(vta.getJ1().getPuntos()));
                                } else {
                                    vta.getJ2().setPuntos(vta.getJ2().getPuntos() + 1);
                                    vta.getP2().setText(String.valueOf(vta.getJ2().getPuntos()));
                                }
                                vta.getaJ().getPts().get(j).setNombre(vta.getTurno().getText());
                            }
                        }
                        k++;
                    }
                }
                Color c = (vta.getTurno().getText().equals(vta.getJ1().getNick())) ? vta.getJ1().getColor() : vta.getJ2().getColor();
                i.setColor(c);
                vta.getaJ().repaint();
                if (sig) {
                    String next = (vta.getTurno().getText().equals(vta.getJ1().getNick())) ? vta.getJ2().getNick() : vta.getJ1().getNick();
                    vta.getTurno().setText(next);
                }
            }
        });
    }

}
