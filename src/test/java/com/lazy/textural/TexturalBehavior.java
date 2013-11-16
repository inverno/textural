package com.lazy.textural;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TexturalBehavior {

    @Before
    public void cleanImages() throws IOException {
        FileUtils.cleanDirectory(new File("src/test/images/"));
    }

    @Test
    public void printsBlackTexture() throws IOException {
        Textural textural = new Textural("src/test/images/black.png");
        textural.print(100,100);
        assertEquals(0xff000000, textural.retrieveImage().getRGB(0, 0));
    }

}
