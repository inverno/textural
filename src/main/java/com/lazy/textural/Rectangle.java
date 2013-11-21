package com.lazy.textural;

import java.awt.image.BufferedImage;

public class Rectangle implements Pattern {
    private final Textural textural;
    private final float relativeDistanceFromBorder;

    public Rectangle(Textural textural, float relativeDistanceFromBorder) {
        this.textural = textural;
        this.relativeDistanceFromBorder = relativeDistanceFromBorder;
    }

    public void paint(int width, int height, BufferedImage image) {
        int xMin = Math.round(width * relativeDistanceFromBorder / 100);
        int yMin = Math.round(height * relativeDistanceFromBorder / 100);
        int xMax = width - xMin;
        int yMax = height - yMin;
        for(int x = xMin; x <= xMax; x++) {
            textural.paintPixel(image, x, yMin);
        }
        for(int y = yMin; y <= yMax; y++) {
            textural.paintPixel(image, xMin, y);
        }
        for(int x = xMin; x <= xMax; x++) {
            textural.paintPixel(image, x, yMax);
        }
        for(int y = yMin; y <= yMax; y++) {
            textural.paintPixel(image, xMax, y);
        }
    }
}
