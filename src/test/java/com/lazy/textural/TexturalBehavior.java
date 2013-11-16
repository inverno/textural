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
    private final int black = 0xff000000;

    @Before
    public void cleanImages() throws IOException {
        FileUtils.cleanDirectory(new File(images));
    }

    @Test
    public void printsBlackTexture() throws IOException {
        Textural textural = new Textural(images + "black.png");
        textural.print(100,100);
        final BufferedImage blackTexture = textural.retrieveImage();
        assertEquals(black, blackTexture.getRGB(0, 0));
        assertEquals(black, blackTexture.getRGB(99, 0));
        assertEquals(black, blackTexture.getRGB(0, 99));
        assertEquals(black, blackTexture.getRGB(99, 99));
    }

}
