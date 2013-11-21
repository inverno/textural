package com.lazy.textural;

import java.awt.image.BufferedImage;

public class Background implements Pattern {
    private final Textural textural;

    public Background(Textural textural) {
        this.textural = textural;
    }

    public void paint(int width, int height, BufferedImage image) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                textural.paintPixel(image, x, y);
            }
        }
    }
}