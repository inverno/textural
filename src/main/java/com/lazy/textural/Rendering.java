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

    public int getRGB(int x, int y) {
        return image.getRGB(x, y);
    }

    public void storeAsPNG(String fileName) throws IOException {
        ImageIO.write(image, "PNG", new FileOutputStream(fileName));
    }

}
