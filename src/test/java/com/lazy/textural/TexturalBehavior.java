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
        final String transparentFileName = images + "transparent.png";
        Textural textural = new Textural();
        textural.print(100,100, transparentFileName);
        assertColorEquals(transparent, textural.retrieveImage(transparentFileName));
    }

    @Test
    public void printsFlatColor() throws Exception {
        int blue = 0xff0000ff;
        final String blueFileName = images + "blue.png";
        Textural textural = new Textural();
        textural.color(blue).print(100, 100, blueFileName);
        assertColorEquals(blue, textural.retrieveImage(blueFileName));
    }

    @Test
    public void printsInnerRectangle() throws Exception {
        int red = 0xffff0000;
        final String rectangleFileName = images + "rectangle.png";
        Textural textural = new Textural();
        textural.rectanglePattern(10).color(red).print(100, 100, rectangleFileName);
        final BufferedImage image = textural.retrieveImage(rectangleFileName);
        assertPixelEquals(red, image, 10, 10);
        assertPixelEquals(red, image, 10, 50);
        assertPixelEquals(red, image, 90, 90);
        assertPixelEquals(red, image, 90, 50);
        assertPixelEquals(0x00000000, image, 0, 0);
    }

    @Test
    public void combinesWithAnotherTexture() throws Exception {
        final Textural component1 = new Textural();
        component1.rectanglePattern(10).color(0xff0000ff);
        final Textural component2 = new Textural();
        component2.rectanglePattern(20).color(0xffff0000);
        Textural composition = component1.add(component2);
        final String compositionFileName = images + "composition.png";
        composition.print(100,100, compositionFileName);
        final BufferedImage composedTexture = composition.retrieveImage(compositionFileName);
        assertPixelEquals(0xff0000ff, composedTexture, 10, 10);
        assertPixelEquals(0xffff0000, composedTexture, 20, 20);
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
