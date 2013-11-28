package com.lazy.textural;

import java.util.ArrayList;
import java.util.List;

public class Border implements Pattern {

    private final float relativeDistanceFromFrame;

    public Border(float relativeDistanceFromFrame) {
        this.relativeDistanceFromFrame = relativeDistanceFromFrame;
    }

    @Override
    public List<Pixel> iterate(int width, int height) {
        final List<Pixel> pixels = new ArrayList<>();
        int xMin = Math.round(width * relativeDistanceFromFrame / 100);
        int yMin = Math.round(height * relativeDistanceFromFrame / 100);
        int xMax = width - 1 - xMin;
        int yMax = height - 1 - yMin;
        for (int x = xMin; x <= xMax; x++) {
            pixels.add(new Pixel(x, yMin));
            pixels.add(new Pixel(x, yMax));
        }
        for (int y = yMin; y <= yMax; y++) {
            pixels.add(new Pixel(xMin, y));
            pixels.add(new Pixel(xMax, y));
        }
        return pixels;
    }

}
