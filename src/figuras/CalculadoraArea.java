package figuras;

import java.util.List;

public class CalculadoraArea {
    public double calcularAreaTotal(List<FiguraGeometrica> figuras) {
        double total = 0;
        for (FiguraGeometrica figura : figuras) {
            total += figura.calcularArea();
        }
        return total;
    }
}