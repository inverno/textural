package com.lazy.textural;

public class Rectangle implements Pattern {

    private final float relativeDistanceFromBorder;

    public Rectangle(float relativeDistanceFromBorder) {
        this.relativeDistanceFromBorder = relativeDistanceFromBorder;
    }

    public void paint(Brush brush, int width, int height) {
        int xMin = Math.round(width * relativeDistanceFromBorder / 100);
        int yMin = Math.round(height * relativeDistanceFromBorder / 100);
        int xMax = width - xMin;
        int yMax = height - yMin;
        for(int x = xMin; x <= xMax; x++) {
            brush.paintPixel(x, yMin);
            brush.paintPixel(x, yMax);
        }
        for(int y = yMin; y <= yMax; y++) {
            brush.paintPixel(xMin, y);
            brush.paintPixel(xMax, y);
        }
    }

}
