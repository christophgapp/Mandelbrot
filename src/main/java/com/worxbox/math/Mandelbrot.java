package com.worxbox.math;

import java.util.ArrayList;
import java.util.Collection;

public class Mandelbrot {
    private int windowHeight = 1000;
    private int windowWidth = 1000;
    private int maxIterations = 40;
    private double zoom = 1;

    private double rangeReal = 5;
    private double rangeImaginary = 5;

    public int getHeight() {
        return windowHeight;
    }

    public int getWidth() {
        return windowWidth;
    }

    public Collection<Point> getSet() {
        Collection<Point> result = new ArrayList<>();

        for (int y = 0; y < windowHeight; y++) {
            for (int x = 0; x < windowWidth; x++) {
                double percentageY = (double) y / windowHeight;
                double percentageX = (double) x / windowWidth;

                double cX = -(rangeReal / 2) + percentageX * rangeReal / zoom;
                double cY = (rangeImaginary / 2) - percentageY * rangeImaginary / zoom;

                int iterations = checkConvergence(new ComplexNumber(), new ComplexNumber(cX, cY));
                result.add(new Point(x, y, iterations, (double) iterations / maxIterations));
            }
        }
        return result;
    }

    private int checkConvergence(ComplexNumber complex, ComplexNumber z) {
        int iteration = 0;
        for (; iteration < maxIterations; iteration++) {
            complex = complex.times(complex).plus(z);
            if (complex.abs() > 4) {
                break;
            }
        }
        return iteration;
    }
}
