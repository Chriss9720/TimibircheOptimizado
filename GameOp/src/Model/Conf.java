package Model;

import Controller.Key;
import Controller.Acciones;
import Vista.Vta;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Chriss Yañez
 */
public class Conf extends JDialog {

    private final Vta vta;
    private JButton co1;
    private JButton col2;
    private JTextField j1;
    private JTextField j2;

    public Conf(Vta vta) {
        this.vta = vta;
        init();
    }

    private void init() {
        PConfig p = new PConfig();
        this.addKeyListener(new Key(this, null));
        p.addKeyListener(new Key(this, null));
        this.setTitle("Configuración");
        this.setResizable(false);
        this.setLayout(null);
        p.setBounds(0, 0, 400, 200);
        this.add(p);
        this.setPreferredSize(new Dimension(400, 200));
        this.pack();
        this.setLocationRelativeTo(null);
        componentes();
    }

    private void componentes() {
        j1 = confField(new JTextField(vta.getJ1().getNombre()));
        j1.setBounds(5, 10, 180, 40);
        j1.addKeyListener(new Key(this, null));
        this.add(j1);
        co1 = new JButton();
        co1.setBounds(j1.getBounds().x + (j1.getBounds().width / 2) - 40, 60, 80, 80);
        co1.setBackground(vta.getJ1().getColor());
        co1.addActionListener(new Acciones(vta));
        co1.addKeyListener(new Key(this, null));
        this.add(co1);
        j2 = confField(new JTextField(vta.getJ2().getNombre()));
        j2.setBounds(206, 10, 180, 40);
        j2.addKeyListener(new Key(this, null));
        this.add(j2);
        col2 = new JButton();
        col2.setBounds(j2.getBounds().x + (j2.getBounds().width / 2) - 40, 60, 80, 80);
        col2.setBackground(vta.getJ2().getColor());
        col2.addActionListener(new Acciones(vta));
        col2.addKeyListener(new Key(this, null));
        this.add(col2);
        JButton acept = new JButton("Aceptar");
        acept.setHorizontalAlignment(SwingConstants.CENTER);
        acept.setFont(new Font("Arial", Font.BOLD, 16));
        acept.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        acept.setBounds(150, 125, 100, 40);
        acept.addActionListener((ActionEvent e) -> {
            onClick();
        });
        this.add(acept);
    }

    public void onClick() {
        String namej1 = vta.getC1().getText();
        Color cj1 = vta.getCo1().getBackground();
        String turno = vta.getTurno().getText();
        String p1 = vta.getJ1().getNick();
        vta.getJ1().setNombre(j1.getText());
        vta.getJ1().setColor(co1.getBackground());
        vta.getJ2().setNombre(j2.getText());
        vta.getJ2().setColor(col2.getBackground());
        vta.getC1().setText(vta.getJ1().getNick());
        vta.getC2().setText(vta.getJ2().getNick());
        vta.getCo1().setBackground(vta.getJ1().getColor());
        vta.getCo2().setBackground(vta.getJ2().getColor());
        vta.getTurno().setText((turno.equals(p1))
                ? vta.getJ1().getNick() : vta.getJ2().getNick());
        vta.getaJ().getCuadros().stream().map(c -> {
            if (c.getNombre() != null) {
                c.setNombre((c.getNombre().equals(namej1))
                        ? vta.getJ1().getNick()
                        : vta.getJ2().getNick());
            }
            return c;
        }).map(c -> {
            c.getShape().stream().filter(l
                    -> (!l.getColor().equals(Color.BLACK))).forEachOrdered(l -> {
                l.setColor((l.getColor().equals(cj1))
                        ? vta.getJ1().getColor()
                        : vta.getJ2().getColor());
            });
            return c;
        }).forEachOrdered(_item -> {
            vta.getaJ().repaint();
        });
        this.dispose();
    }

    private JTextField confField(JTextField l) {
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setFont(new Font("Arial", Font.BOLD, 16));
        l.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return l;
    }

}
