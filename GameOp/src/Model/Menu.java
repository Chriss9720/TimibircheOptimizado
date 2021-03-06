package Model;

import Controller.Acciones;
import Vista.Vta;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Chriss Yañez
 */
public class Menu extends JMenuBar {

    private final Vta vta;
    private final JMenu m1 = new JMenu();
    private final JMenuItem it1 = new JMenuItem();
    private final JMenuItem it2 = new JMenuItem();
    private final JMenuItem it3 = new JMenuItem();

    public Menu(Vta vta) {
        this.vta = vta;
        init();
    }

    private void init() {
        m1.setText("Menú");
        it1.setName("Configuración");
        it1.setText("Configuración (f1)");
        it1.addActionListener(new Acciones(vta));
        it2.setName("Nuevo juego");
        it2.setText("Nuevo juego (f2)");
        it2.addActionListener(new Acciones(vta));
        it3.setName("Salir");
        it3.setText("Salir (f3)");
        it3.addActionListener(new Acciones(vta));
        m1.add(it1);
        m1.add(it2);
        m1.add(it3);
        this.add(m1);
    }

}
