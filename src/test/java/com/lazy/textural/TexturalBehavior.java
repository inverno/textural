package com.lazy.textural;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;

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
        final String transparentFileName = images + "transparent.png";
        new Textural().generate(100, 100).storeAsPNG(transparentFileName);
        assertColorEquals(0x00000000, Rendering.retrieveImage(transparentFileName));
    }

    @Test
    public void generatesFlatImage() throws Exception {
        int blue = 0xff0000ff;
        Textural textural = new Textural(new Background(), blue);
        assertColorEquals(blue, textural.generate(100, 100));
    }

    @Test
    public void generatesInnerRectangle() throws Exception {
        int red = 0xffff0000;
        Textural textural = new Textural(new Rectangle(10), red);
        final Rendering image = textural.generate(100, 100);
        assertPixelColorEquals(red, image, 10, 10);
        assertPixelColorEquals(red, image, 10, 50);
        assertPixelColorEquals(red, image, 90, 90);
        assertPixelColorEquals(red, image, 90, 50);
        assertPixelColorEquals(0x00000000, image, 0, 0);
    }

    @Test
    public void combinesWithAnotherTexture() throws Exception {
        final int red = 0xff0000ff;
        final Textural component1 = new Textural(new Rectangle(10), red);
        final int blue = 0xffff0000;
        final Textural component2 = new Textural(new Rectangle(20), blue);
        Textural composition = component1.add(component2);
        final Rendering composedTexture = composition.generate(100, 100);
        assertPixelColorEquals(red, composedTexture, 10, 10);
        assertPixelColorEquals(blue, composedTexture, 20, 20);
    }

    private void assertColorEquals(int color, Rendering image) {
        for(int x = 0; x < 100; x++) {
            for(int y = 0; y < 100; y++) {
                assertPixelColorEquals(color, image, x, y);
            }
        }
    }

    private void assertPixelColorEquals(int color, Rendering image, int x, int y) {
        assertEquals("Pixel[" + x + "," + y + "]", color, image.getRGB(x, y));
    }
}
