package Model;

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

    public Conf(Vta vta) {
        this.vta = vta;
        init();
    }

    private void init() {
        PConfig p = new PConfig();
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
        JTextField j1 = confField(new JTextField(vta.getJ1().getNombre()));
        j1.setBounds(5, 10, 180, 40);
        this.add(j1);
        JButton co1 = new JButton();
        co1.setBounds(j1.getBounds().x + (j1.getBounds().width / 2) - 40, 60, 80, 80);
        co1.setBackground(vta.getJ1().getColor());
        co1.addActionListener(new Acciones(vta));
        this.add(co1);
        JTextField j2 = confField(new JTextField(vta.getJ2().getNombre()));
        j2.setBounds(206, 10, 180, 40);
        this.add(j2);
        JButton col2 = new JButton();
        col2.setBounds(j2.getBounds().x + (j2.getBounds().width / 2) - 40, 60, 80, 80);
        col2.setBackground(vta.getJ2().getColor());
        col2.addActionListener(new Acciones(vta));
        this.add(col2);
        JButton acept = new JButton("Aceptar");
        acept.setHorizontalAlignment(SwingConstants.CENTER);
        acept.setFont(new Font("Arial", Font.BOLD, 16));
        acept.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        acept.setBounds(150, 125, 100, 40);
        acept.addActionListener((ActionEvent e) -> {          
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
            
            this.dispose();
        });
        this.add(acept);
    }

    private JTextField confField(JTextField l) {
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setFont(new Font("Arial", Font.BOLD, 16));
        l.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return l;
    }

}
