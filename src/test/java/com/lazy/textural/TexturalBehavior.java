package com.lazy.textural;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TexturalBehavior {

    private final String images = "src/test/images/";
    private final int transparent = 0x00000000;
    private final int blue = 0x00ff0000;

    @Before
    public void cleanImages() throws IOException {
        FileUtils.cleanDirectory(new File(images));
    }

    @Test
    public void printsTransparentTexture() throws IOException {
        Textural textural = new Textural(images + "transparent.png");
        textural.print(100,100);
        final BufferedImage transparentTexture = textural.retrieveImage();
        assertEquals(transparent, transparentTexture.getRGB(0, 0));
        assertEquals(transparent, transparentTexture.getRGB(99, 0));
        assertEquals(transparent, transparentTexture.getRGB(0, 99));
        assertEquals(transparent, transparentTexture.getRGB(99, 99));
    }

    @Test
    public void printsFlatColor() throws Exception {
        Textural textural = new Textural(images + "blue.png");
        textural.color(blue).print(100, 100);
        final BufferedImage blueTexture = textural.retrieveImage();
        for(int x = 0; x < 100; x++) {
            for(int y = 0; y < 100; y++) {
                assertEquals("Pixel[" + x + "," + y + "]", blue, blueTexture.getRGB(x, y));
            }
        }
    }
}
