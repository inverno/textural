package com.lazy.textural;

import java.awt.image.BufferedImage;

public class Brush {
    private final BufferedImage image;
    private int color;

    public Brush(BufferedImage image, int baseColor) {
        this.image = image;
        this.color = baseColor;
    }

    public void paintPixel(int x, int y) {
        image.setRGB(x, y, color);
    }
}
