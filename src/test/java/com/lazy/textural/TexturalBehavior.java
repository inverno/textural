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

    private void assertColorEquals(int color, BufferedImage image) {
        for(int x = 0; x < 100; x++) {
            for(int y = 0; y < 100; y++) {
                assertEquals("Pixel[" + x + "," + y + "]", color, image.getRGB(x, y));
            }
        }
    }
}
