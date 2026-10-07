package figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FigurasRefactorizadoGUI extends JFrame implements ActionListener {

    private JComboBox<String> comboFigura;
    private JTextField txtValor1;
    private JTextField txtValor2;
    private JButton btnCalcular;
    private JLabel lblResultado;

    public FigurasRefactorizadoGUI() {
        setTitle("Calculadora de Figuras Geométricas (Refactorizado)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 250);
        getContentPane().setLayout(null);

        JLabel lblFigura = new JLabel("Elige figura:");
        lblFigura.setBounds(20, 20, 100, 20);
        getContentPane().add(lblFigura);

        comboFigura = new JComboBox<>(new String[]{"Rectangulo", "Circulo", "Triangulo"});
        comboFigura.setBounds(130, 20, 150, 20);
        getContentPane().add(comboFigura);

        JLabel lblValor1 = new JLabel("Valor 1 (ancho/radio/base):");
        lblValor1.setBounds(20, 55, 180, 20);
        getContentPane().add(lblValor1);

        txtValor1 = new JTextField();
        txtValor1.setBounds(210, 55, 100, 20);
        getContentPane().add(txtValor1);

        JLabel lblValor2 = new JLabel("Valor 2 (alto/altura, si aplica):");
        lblValor2.setBounds(20, 85, 180, 20);
        getContentPane().add(lblValor2);

        txtValor2 = new JTextField();
        txtValor2.setBounds(210, 85, 100, 20);
        getContentPane().add(txtValor2);

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
        int figuraSeleccionada = comboFigura.getSelectedIndex();
        double areaCalculada = calcularArea(figuraSeleccionada);

        if (areaCalculada >= 0) {
            mostrarResultado(areaCalculada);
        } else {
            lblResultado.setText("Opción inválida.");
        }
    }

    private double calcularArea(int figuraSeleccionada) {
        switch (figuraSeleccionada) {
            case 0:
                return calcularAreaRectangulo();
            case 1:
                return calcularAreaCirculo();
            case 2:
                return calcularAreaTriangulo();
            default:
                return -1;
        }
    }

    private double calcularAreaRectangulo() {
        double ancho = Double.parseDouble(txtValor1.getText());
        double alto = Double.parseDouble(txtValor2.getText());
        return ancho * alto;
    }

    private double calcularAreaCirculo() {
        double radio = Double.parseDouble(txtValor1.getText());
        return Math.PI * radio * radio;
    }

    private double calcularAreaTriangulo() {
        double base = Double.parseDouble(txtValor1.getText());
        double altura = Double.parseDouble(txtValor2.getText());
        return (base * altura) / 2;
    }

    private void mostrarResultado(double areaCalculada) {
        lblResultado.setText("area = " + areaCalculada);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            FigurasRefactorizadoGUI frame = new FigurasRefactorizadoGUI();
            frame.setVisible(true);
        });
    }
}