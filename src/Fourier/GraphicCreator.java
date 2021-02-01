package Fourier;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.util.function.Function;

public class GraphicCreator {

    public static void showGraphic(LineChart<Number, Number> lineChart, ComplexNumber[] values, String title) {
        lineChart.setTitle(title);
        lineChart.setLegendVisible(false);
        XYChart.Series series = new XYChart.Series();

        for (int i = 0; i < values.length; i++) {
            series.getData().add(new XYChart.Data(values[i].phase(i), values[i].abs()));
        }
        lineChart.getData().add(series);
    }
}
