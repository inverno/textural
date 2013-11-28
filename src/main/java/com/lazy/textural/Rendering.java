package com.lazy.textural;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

public class Rendering {

    private final BufferedImage image;

    public Rendering(BufferedImage image) {
        this.image = image;
    }

    public void set(Pixel pixel, int color) {
        image.setRGB(pixel.x, pixel.y, color);
    }

    public int getRGB(int x, int y) {
        return image.getRGB(x, y);
    }

    public int getRGB(Pixel pixel) {
        return getRGB(pixel.x, pixel.y);
    }

    public void storeAsPNG(String fileName) throws IOException {
        ImageIO.write(image, "PNG", new FileOutputStream(fileName));
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Rendering rendering = (Rendering) o;

        if(image.equals(rendering.image)) return true;
        if(!(image.getWidth() == rendering.image.getWidth())) return false;
        if(!(image.getHeight() == rendering.image.getHeight())) return false;
        for(int x = 0; x < image.getWidth(); x++) {
            for(int y = 0; y < image.getHeight(); y++) {
                if(image.getRGB(x, y) != rendering.image.getRGB(x, y)) return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return image.hashCode();
    }
}
