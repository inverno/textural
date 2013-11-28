package com.lazy.textural;

import java.awt.image.BufferedImage;

public class ImageAddBrush implements Brush {

    private final BufferedImage targetImage;
    private final Rendering sourceImage;

    public ImageAddBrush(BufferedImage targetImage, Rendering sourceImage) {
        this.targetImage = targetImage;
        this.sourceImage = sourceImage;
    }

    public void paintPixel(int x, int y) {
        targetImage.setRGB(x, y, targetImage.getRGB(x, y) + sourceImage.getRGB(x, y));
    }

    @Override
    public int paint(Pixel pixel) {
        return sourceImage.getRGB(pixel);
    }
}
