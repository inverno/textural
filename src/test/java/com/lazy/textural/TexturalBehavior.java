package com.lazy.textural;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TexturalBehavior {

    private static final String images = "src/test/images/";
    private final int transparent = 0x00000000;
    private final int blue = 0x00ff0000;

    @BeforeClass
    public static void cleanImages() throws IOException {
        FileUtils.cleanDirectory(new File(images));
    }

    @Test
    public void printsTransparentTexture() throws IOException {
        Textural textural = new Textural(images + "transparent.png");
        textural.print(100,100);
        final BufferedImage transparentTexture = textural.retrieveImage();
        assertColorEquals(transparent, transparentTexture);
    }

    @Test
    public void printsFlatColor() throws Exception {
        Textural textural = new Textural(images + "blue.png");
        textural.color(blue).print(100, 100);
        final BufferedImage blueTexture = textural.retrieveImage();
        assertColorEquals(blue, blueTexture);
    }

    @Test
    public void printsHalfHalf() throws Exception {
        final Textural textural = new Textural(images + "halfhalf.png");
        textural.brush(new HalfBrush());
    }

    private void assertColorEquals(int expectedColor, BufferedImage texture) {
        for(int x = 0; x < 100; x++) {
            for(int y = 0; y < 100; y++) {
                assertPixelColorEquals(expectedColor, texture, x, y);
            }
        }
    }

    private void assertPixelColorEquals(int expectedColor, BufferedImage texture, int x, int y) {
        assertEquals("Pixel[" + x + "," + y + "]", expectedColor, texture.getRGB(x, y));
    }
}
