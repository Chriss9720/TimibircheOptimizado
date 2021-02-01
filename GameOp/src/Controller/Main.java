package Controller;

import Vista.Vta;
import javax.swing.JOptionPane;

/**
 *
 * @author Chriss Yañez
 */
public class Main {

    public static void main(String[] args) {
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
        Vta vta = new Vta(valor);
        vta.setTitle("Juego de puntos");
        vta.setVisible(true);
    }

}
