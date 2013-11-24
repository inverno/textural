package com.lazy.textural;

import java.awt.image.BufferedImage;

public class ImageAddBrush implements Brush {

    private final BufferedImage targetImage;
    private final BufferedImage sourceImage;

    public ImageAddBrush(BufferedImage targetImage, BufferedImage sourceImage) {
        this.targetImage = targetImage;
        this.sourceImage = sourceImage;
    }

    public void paintPixel(int x, int y) {
        final int addition = sourceImage.getRGB(x, y);
        targetImage.setRGB(x, y, targetImage.getRGB(x, y) + addition);
    }
}
