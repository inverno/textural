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
        final BufferedImage transparentTexture = textural.retrieveImage();
        assertEquals(transparent, transparentTexture.getRGB(0, 0));
        assertEquals(transparent, transparentTexture.getRGB(99, 0));
        assertEquals(transparent, transparentTexture.getRGB(0, 99));
        assertEquals(transparent, transparentTexture.getRGB(99, 99));
    }

    @Test
    public void printsFlatColor() throws Exception {
        int blue = 0xff0000ff;
        Textural textural = new Textural(images + "blue.png");
        textural.color(blue).print(100, 100);
        final BufferedImage blueTexture = textural.retrieveImage();
        assertEquals(blue, blueTexture.getRGB(0,0));
    }
}
