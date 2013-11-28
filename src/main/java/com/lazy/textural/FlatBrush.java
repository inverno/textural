package com.lazy.textural;

public class FlatBrush implements Brush {

    private int color;

    public FlatBrush(int color) {
        this.color = color;
    }

    public void paintPixel(int x, int y) {
        throw new UnsupportedOperationException("Deprecated");
    }

    public int paint(Pixel pixel) {
        return color;
    }
}
