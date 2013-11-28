package com.lazy.textural;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class RenderingBehavior {

    private static final String images = "src/test/images/";

    @BeforeClass
    public static void cleanImages() throws IOException {
        FileUtils.cleanDirectory(new File(images));
    }

    @Test
    public void printsPNG() throws IOException {
        final String transparentFileName = images + "transparent.png";
        final Rendering rendering = new Textural().generate(100, 100);
        rendering.storeAsPNG(transparentFileName);
        assertEquals(rendering, new Rendering(ImageIO.read(new FileInputStream(transparentFileName))));
    }
}
