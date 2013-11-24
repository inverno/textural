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

}
