package com.lazy.textural;

public interface Brush {
    void paintPixel(int x, int y);

    int paint(Pixel pixel);
}
