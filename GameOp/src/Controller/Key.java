package Controller;

import Model.Conf;
import Vista.Vta;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Chriss Yañez
 */
public class Key extends EventosSimilares implements KeyListener {

    private final Conf d;
    private Vta vta;

    public Key(Conf d, Vta vta) {
        this.d = d;
        this.vta = vta;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                if (d != null) {
                    d.onClick();
                }
                break;
            case KeyEvent.VK_F1:
                if (vta != null) {
                    this.config(vta);
                }
                break;
            case KeyEvent.VK_F2:
                if (vta != null) {
                    this.newGame(vta);
                }
                break;
            case KeyEvent.VK_F3:
                System.exit(0);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
