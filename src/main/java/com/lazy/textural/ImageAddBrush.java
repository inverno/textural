package com.lazy.textural;

public class ImageAddBrush implements Brush {

    private final Rendering targetImage;
    private final Rendering sourceImage;

    public ImageAddBrush(Rendering targetImage, Rendering sourceImage) {
        this.targetImage = targetImage;
        this.sourceImage = sourceImage;
    }

    @Override
    public int paint(Pixel pixel) {
        return targetImage.getRGB(pixel) + sourceImage.getRGB(pixel);
    }

}
