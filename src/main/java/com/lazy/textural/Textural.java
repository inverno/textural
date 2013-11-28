package com.lazy.textural;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Textural {

    private final String name;
    private int baseColor;

    public Textural(String name) {
        this.name = name;
        this.baseColor = 0x00000000;
    }

    public void print(int width, int height) {
        try {
            FileOutputStream output = new FileOutputStream(name);
            final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, this.baseColor);
                }
            }
            ImageIO.write(image, "PNG", output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage retrieveImage() throws IOException {
        return ImageIO.read(new FileInputStream(name));
    }

    public Textural color(int color) {
        this.baseColor = color;
        return this;
    }

    public Textural rectanglePattern(int distanceFromFrame) {
        return this;
    }
}
