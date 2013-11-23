package com.lazy.textural;

public class Background implements Pattern {

    public void paint(Brush brush, int width, int height) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                brush.paintPixel(x, y);
            }
        }
    }

}