package Controller;

import Model.Conf;
import Vista.Vta;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Chriss Yañez
 */
public class Acciones implements ActionListener {

    private Vta vta;

    public Acciones(Vta vta) {
        this.vta = vta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JMenuItem) {
            String t = ((JMenuItem) e.getSource()).getText();
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
                Conf c = new Conf(vta);
                c.setVisible(true);
                break;
            case "Nuevo juego":
                vta.dispose();
                boolean ok = true;
                int valor = 0;
                do {
                    String entrada = JOptionPane.showInputDialog(null, "Tamaño del cuadrado");
                    if (entrada != null) {
                        try {
                            valor = Integer.parseInt(entrada);
                            if (valor % 2 == 0) {
                                ok = false;
                            } else {
                                JOptionPane.showMessageDialog(null, "Ingrese un numero par de 2",
                                        "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Ingrese un numero par de 2",
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        System.exit(0);
                    }
                } while (ok);
                vta = new Vta(valor);
                vta.setTitle("Juego de puntos");
                vta.setVisible(true);
                break;
            case "Salir":
                System.exit(0);
                break;
        }
    }

}
