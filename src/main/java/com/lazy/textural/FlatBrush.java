package com.lazy.textural;

public class FlatBrush implements Brush {

    private int color;

    public FlatBrush(int color) {
        this.color = color;
    }

    @Override
    public int paint(Pixel pixel) {
        return color;
    }
}
