package com.worxbox.math;

public class Point {
    private final int x;
    private final int y;
    private final int deep;
    private final double color;

    public Point(int x, int y, int deep, double color) {
        this.x = x;
        this.y = y;
        this.deep = deep;
        this.color = color;
    }

    public double getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDeep() {
        return deep;
    }
}
