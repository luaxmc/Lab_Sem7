package figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SolidFigurasGUI extends JFrame implements ActionListener {

    private JButton btnCalcular;
    private JTextArea txtResultado;

    public SolidFigurasGUI() {
        setTitle("Aplicación de Principios SOLID");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        btnCalcular = new JButton("Calcular áreas");
        btnCalcular.setBounds(0, 0, 436, 31);
        btnCalcular.addActionListener(this);
        getContentPane().setLayout(null);
        getContentPane().add(btnCalcular);

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtResultado);
        scrollPane.setBounds(0, 31, 436, 232);
        getContentPane().add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            do_btnCalcular_actionPerformed();
        }
    }

    private void do_btnCalcular_actionPerformed() {
        Rectangulo rectangulo = new Rectangulo(10.0, 5.0);
        Circulo circulo = new Circulo(3.0);
        Triangulo triangulo = new Triangulo(6.0, 4.0);
        Cuadrado cuadrado = new Cuadrado(4.0);

        List<FiguraGeometrica> listaFiguras = new ArrayList<>();
        listaFiguras.add(rectangulo);
        listaFiguras.add(circulo);
        listaFiguras.add(triangulo);
        listaFiguras.add(cuadrado);


        CalculadoraArea calculadora = new CalculadoraArea();
        double areaTotal = calculadora.calcularAreaTotal(listaFiguras);

        txtResultado.setText("");
        txtResultado.append("Área del Rectángulo: " + rectangulo.calcularArea() + "\n");
        txtResultado.append("Área del Círculo: " + circulo.calcularArea() + "\n");
        txtResultado.append("Área del Triángulo: " + triangulo.calcularArea() + "\n");
        txtResultado.append("Área del Cuadrado: " + cuadrado.calcularArea() + "\n");
        txtResultado.append("---------------------------------\n");
        txtResultado.append("Área total combinada: " + areaTotal + "\n");
        
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SolidFigurasGUI frame = new SolidFigurasGUI();
            frame.setVisible(true);
        });
    }
}