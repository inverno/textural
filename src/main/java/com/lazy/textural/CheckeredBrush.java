package com.lazy.textural;

public class CheckeredBrush implements Brush{

    public CheckeredBrush(int color1, int color2, int width, int height) {
    }

    public void paintPixel(int x, int y) {
        throw new RuntimeException("I miss the image to write on!");
    }

    public int paint(Pixel pixel) {
        return 0;
    }
}
