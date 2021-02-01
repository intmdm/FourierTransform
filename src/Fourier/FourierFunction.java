package Fourier;

import java.util.function.Function;

import static java.lang.Math.*;

public class FourierFunction {
    public static ComplexNumber[] getDiscreteFourierTransform(Function<Double, Double> function, double period, int N) {
        ComplexNumber[] result = new ComplexNumber[N];
        for (int i = 0; i < N; i++) {
            result[i] = new ComplexNumber(0, 0);
        }

        for (int k = 0; k < N; k++) {
            for (int n = 0; n < N; n++) {
                ComplexNumber a = new ComplexNumber(cos(period * k * ((double) n) / N), sin(period * k * ((double) n / N)));
                double x = function.apply(period * ((double) n) / N);
                result[k] = result[k].plus(a.times(x));
            }
            result[k] = result[k].divides(N);
        }
        return result;
    }
}