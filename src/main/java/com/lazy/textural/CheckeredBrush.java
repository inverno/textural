package com.lazy.textural;

public class CheckeredBrush implements Brush {

    private final int color1;
    private final int color2;
    private final int width;
    private final int height;

    public CheckeredBrush(int color1, int color2, int width, int height) {
        this.color1 = color1;
        this.color2 = color2;
        this.width = width;
        this.height = height;
    }

    @Override
    public int paint(Pixel pixel) {
        return (xParity(pixel) == yParity(pixel)) ? color1 : color2;
    }

    private boolean xParity(Pixel pixel) {
        return Math.round(pixel.x / width) % 2 == 0;
    }

    private boolean yParity(Pixel pixel) {
        return Math.round(pixel.y / height) % 2 == 0;
    }

}
