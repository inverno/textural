package com.lazy.textural;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TexturalBehavior {

    private static final String images = "src/test/images/";

    @BeforeClass
    public static void cleanImages() throws IOException {
        FileUtils.cleanDirectory(new File(images));
    }

    @Test
    public void printsTransparentTexture() throws IOException {
        int transparent = 0x00000000;
        Textural textural = new Textural(images + "transparent.png");
        textural.print(100,100);
        assertColorEquals(transparent, textural.retrieveImage());
    }

    @Test
    public void printsFlatColor() throws Exception {
        int blue = 0xff0000ff;
        Textural textural = new Textural(images + "blue.png");
        textural.color(blue).print(100, 100);
        assertColorEquals(blue, textural.retrieveImage());
    }

    @Test
    public void printsInnerRectangle() throws Exception {
        int red = 0xffff0000;
        Textural textural = new Textural(images + "rectangle.png");
        textural.rectanglePattern(10).color(red).print(100, 100);
        final BufferedImage image = textural.retrieveImage();
        assertPixelEquals(red, image, 10, 10);
        assertPixelEquals(red, image, 10, 50);
        assertPixelEquals(red, image, 90, 90);
        assertPixelEquals(red, image, 90, 50);
        assertPixelEquals(0x00000000, image, 0, 0);
    }

    private void assertColorEquals(int color, BufferedImage image) {
        for(int x = 0; x < 100; x++) {
            for(int y = 0; y < 100; y++) {
                assertPixelEquals(color, image, x, y);
            }
        }
    }

    private void assertPixelEquals(int color, BufferedImage image, int x, int y) {
        assertEquals("Pixel[" + x + "," + y + "]", color, image.getRGB(x, y));
    }
}
