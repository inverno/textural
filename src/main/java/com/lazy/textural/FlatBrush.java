package com.lazy.textural;

import java.awt.image.BufferedImage;

public class FlatBrush implements Brush {
    private final BufferedImage image;
    private int color;

    public FlatBrush(BufferedImage image, int baseColor) {
        this.image = image;
        this.color = baseColor;
    }

    public void paintPixel(int x, int y) {
        image.setRGB(x, y, color);
    }
}
