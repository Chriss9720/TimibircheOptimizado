package Vista;

import Controller.Key;
import Controller.Mouse;
import Model.AradeJuego;
import Model.Jugador;
import Model.Menu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Chriss Yañez
 */
public class Vta extends JFrame {

    private final Jugador j1, j2;
    private final int valor;
    private JLabel c1, p, co1, c2, p2, co2, turno;
    private AradeJuego aJ;

    public Vta(int valor) {
        this.valor = valor;
        j1 = new Jugador("Jugador1", 0, Color.RED);
        j2 = new Jugador("Jugador2", 0, Color.BLUE);
        init();
    }

    private void init() {
        aJ = new AradeJuego(valor);
        this.addKeyListener(new Key(null, this));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        aJ.setBounds(0, 50, aJ.getPreferredSize().width, aJ.getPreferredSize().height);
        aJ.addMouseListener(new Mouse(this));
        this.add(aJ);
        Dimension d = aJ.getPreferredSize();
        d.height += 100;
        this.setPreferredSize(d);
        this.setJMenuBar(new Menu(this));
        this.pack();
        this.setLocationRelativeTo(null);
        config();
    }

    public void config() {
        c1 = confLabel(new JLabel());
        c1.setBounds(5, 5, 40, 40);
        c1.setText(j1.getNick());
        this.add(c1);
        p = confLabel(new JLabel());
        p.setBounds(c1.getBounds().x + 5 + c1.getBounds().width, 5, 40, 40);
        p.setText(String.valueOf(j1.getPuntos()));
        this.add(p);
        co1 = new JLabel();
        co1.setOpaque(true);
        co1.setBounds(p.getBounds().x + 5 + p.getBounds().width, 5, 40, 40);
        co1.setBackground(j1.getColor());
        this.add(co1);
        c2 = confLabel(new JLabel());
        c2.setBounds(this.getPreferredSize().width - 10 - 40, 5, 40, 40);
        c2.setText(j2.getNick());
        this.add(c2);
        p2 = confLabel(new JLabel());
        p2.setBounds(c2.getBounds().x - 45, 5, 40, 40);
        p2.setText(String.valueOf(j2.getPuntos()));
        this.add(p2);
        co2 = new JLabel();
        co2.setOpaque(true);
        co2.setBounds(p2.getBounds().x - 45, 5, 40, 40);
        co2.setBackground(j2.getColor());
        this.add(co2);
        turno = confLabel(new JLabel(j1.getNick()));
        turno.setBounds(180, 5, 40, 40);
        this.add(turno);
    }

    private JLabel confLabel(JLabel l) {
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setVerticalAlignment(SwingConstants.CENTER);
        l.setFont(new Font("Arial", Font.BOLD, 16));
        l.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return l;
    }

    public Jugador getJ1() {
        return j1;
    }

    public Jugador getJ2() {
        return j2;
    }

    public JLabel getC1() {
        return c1;
    }

    public JLabel getP() {
        return p;
    }

    public JLabel getCo1() {
        return co1;
    }

    public JLabel getC2() {
        return c2;
    }

    public JLabel getP2() {
        return p2;
    }

    public JLabel getCo2() {
        return co2;
    }

    public AradeJuego getaJ() {
        return aJ;
    }

    public JLabel getTurno() {
        return turno;
    }

    public void setTurno(JLabel turno) {
        this.turno = turno;
    }

}
