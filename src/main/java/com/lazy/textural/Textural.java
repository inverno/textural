package com.lazy.textural;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Textural {
    private String name;

    public Textural(String name) {
        this.name = name;
    }

    public void print(int x0, int y0, int width, int height) {
        File output = new File(name);
        try {
            ImageIO.write(new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB), "bmp", output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
