package com.lazy.textural;

import org.junit.Test;

import static com.lazy.textural.ImageAssert.assertColorEquals;
import static com.lazy.textural.ImageAssert.assertPixelColorEquals;

public class TexturalBehavior {

    @Test
    public void generatesFlatImage() throws Exception {
        int blue = 0xff0000ff;
        Textural textural = new Textural(new Background(), blue);
        assertColorEquals(blue, textural.generate(100, 100));
    }

    @Test
    public void generatesBorder() throws Exception {
        int red = 0xffff0000;
        Textural textural = new Textural(new Border(10), red);
        final Rendering image = textural.generate(100, 100);
        assertPixelColorEquals(red, image, 10, 10);
        assertPixelColorEquals(red, image, 10, 50);
        assertPixelColorEquals(red, image, 90, 90);
        assertPixelColorEquals(red, image, 90, 50);
        assertPixelColorEquals(0x00000000, image, 0, 0);
    }

    @Test
    public void combinesWithAnotherTexture() throws Exception {
        final int blue = 0xff0000ff;
        final int red = 0xffff0000;
        final Textural component1 = new Textural(new Border(10), blue);
        final Textural component2 = new Textural(new Border(20), red);
        Textural composition = component1.add(component2);
        final Rendering composedTexture = composition.generate(100, 100);
        assertPixelColorEquals(blue, composedTexture, 10, 10);
        assertPixelColorEquals(red, composedTexture, 20, 20);
    }

    @Test
    public void generatesANonSquareTexture() throws Exception {
        final int violet = 0xffff00ff;
        final Textural textural = new Textural(new Background(), violet);
        final Rendering slimRendering = textural.generate(10, 100);
        assertColorEquals(violet, slimRendering);
    }
}
