package com.lazy.textural;

import java.util.ArrayList;
import java.util.List;

public class Background implements Pattern {

    @Override
    public List<Pixel> iterate(int width, int height) {
        List<Pixel> pixels = new ArrayList<>(width * height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels.add(new Pixel(x,y));
            }
        }
        return pixels;
    }

}