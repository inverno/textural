package com.lazy.textural;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Rendering {
    public final BufferedImage image;

    public Rendering(BufferedImage image) {
        this.image = image;
    }

    public static Rendering retrieveImage(String fileName) throws IOException {
        return new Rendering(ImageIO.read(new FileInputStream(fileName)));
    }

    public int getRGB(int x, int y) {
        return image.getRGB(x, y);
    }

    public void storeAsPNG(String fileName) throws IOException {
        FileOutputStream output = new FileOutputStream(fileName);
        ImageIO.write(image, "PNG", output);
    }
}
