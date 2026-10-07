package figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FigurasGUI extends JFrame implements ActionListener {

    private JComboBox<String> comboFigura;
    private JTextField txt1;
    private JTextField txt2;
    private JButton btnCalcular;
    private JLabel lblResultado;

    public FigurasGUI() {
        setTitle("Calculadora de Figuras Geométricas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 250);
        getContentPane().setLayout(null);

        JLabel lblFigura = new JLabel("Elige figura:");
        lblFigura.setBounds(20, 20, 100, 20);
        getContentPane().add(lblFigura);

        comboFigura = new JComboBox<>(new String[]{"Rectangulo", "Circulo", "Triangulo"});
        comboFigura.setBounds(130, 20, 150, 20);
        getContentPane().add(comboFigura);

        JLabel lbl1 = new JLabel("Valor 1 (ancho/radio/base):");
        lbl1.setBounds(20, 55, 180, 20);
        getContentPane().add(lbl1);

        txt1 = new JTextField();
        txt1.setBounds(210, 55, 100, 20);
        getContentPane().add(txt1);

        JLabel lbl2 = new JLabel("Valor 2 (alto/altura, si aplica):");
        lbl2.setBounds(20, 85, 180, 20);
        getContentPane().add(lbl2);

        txt2 = new JTextField();
        txt2.setBounds(210, 85, 100, 20);
        getContentPane().add(txt2);

        btnCalcular = new JButton("Calcular area");
        btnCalcular.setBounds(130, 120, 150, 25);
        btnCalcular.addActionListener(this);
        getContentPane().add(btnCalcular);

        lblResultado = new JLabel("area = ");
        lblResultado.setBounds(20, 160, 300, 20);
        getContentPane().add(lblResultado);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            do_btnCalcular_actionPerformed();
        }
    }

    private void do_btnCalcular_actionPerformed() {
        int op = comboFigura.getSelectedIndex();
        double a;
        if (op == 0) {
            double b = Double.parseDouble(txt1.getText());
            double c = Double.parseDouble(txt2.getText());
            a = b * c;
            lblResultado.setText("area = " + a);
        } else if (op == 1) {
            double r = Double.parseDouble(txt1.getText());
            a = 3.1416 * r * r;
            lblResultado.setText("area = " + a);
        } else if (op == 2) {
            double b2 = Double.parseDouble(txt1.getText());
            double h = Double.parseDouble(txt2.getText());
            a = (b2 * h) / 2;
            lblResultado.setText("area = " + a);
        } else {
            lblResultado.setText("opcion invalida");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            FigurasGUI frame = new FigurasGUI();
            frame.setVisible(true);
        });
    }
}