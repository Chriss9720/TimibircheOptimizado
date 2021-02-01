package Controller;

import Model.Conf;
import Vista.Vta;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JMenuItem;

/**
 *
 * @author Chriss Yañez
 */
public class Acciones extends EventosSimilares implements ActionListener {

    private final Vta vta;

    public Acciones(Vta vta) {
        this.vta = vta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JMenuItem) {
            String t = ((JMenuItem) e.getSource()).getName();
            menus(t);
        } else if (e.getSource() instanceof JButton) {
            Botones((JButton) e.getSource());
        }
    }

    private void Botones(JButton boton) {
        if (boton.getBackground().equals(vta.getJ1().getColor())) {
            boton.setBackground(JColorChooser.showDialog(null,
                    "Selecione su color", Color.GREEN));
        } else if (boton.getBackground().equals(vta.getJ2().getColor())) {
            boton.setBackground(JColorChooser.showDialog(null,
                    "Selecione su color", Color.GREEN));
        }
    }

    private void menus(String text) {
        switch (text) {
            case "Configuración":
                this.config(vta);
                break;
            case "Nuevo juego":
                this.newGame(vta);
                break;
            case "Salir":
                System.exit(0);
                break;
        }
    }

}
