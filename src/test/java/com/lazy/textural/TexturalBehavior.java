package com.lazy.textural;

import org.junit.Test;

import static com.lazy.textural.ImageAssert.assertColorEquals;
import static com.lazy.textural.ImageAssert.assertPixelColorEquals;

public class TexturalBehavior {

    @Test
    public void generatesASquareTexture() throws Exception {
        int blue = 0xff0000ff;
        Textural textural = new Textural(new Background(), new FlatBrush(blue));
        assertColorEquals(blue, textural.generate(100, 100), 100, 100);
    }

    @Test
    public void generatesNonSquareTexture() throws Exception {
        final int violet = 0xffff00ff;
        final Textural textural = new Textural(new Background(), violet);
        final Rendering slimRendering = textural.generate(10, 100);
        assertColorEquals(violet, slimRendering, 10, 100);
    }

    @Test
    public void combinesWithAnotherTexture() throws Exception {
        final int blue = 0xff0000ff;
        final int red = 0xffff0000;
        final int violet = blue + red;
        final Textural component1 = new Textural(new Background(), blue);
        final Textural component2 = new Textural(new Background(), red);
        Textural composition = component1.add(component2);
        final Rendering composedTexture = composition.generate(100, 100);
        assertColorEquals(violet, composedTexture, 100, 100);
    }

    @Test
    public void generatesCheckeredTexture() throws Exception {
        final int black = 0xff0000ff;
        final int yellow = 0xffffff00;
        final Textural textural = new Textural(new Background(), new CheckeredBrush(black, yellow, 5, 5));
        final Rendering rendering = textural.generate(20, 20);

        assertPixelColorEquals(black, rendering, 0, 0);
        assertPixelColorEquals(black, rendering, 4, 4);

        assertPixelColorEquals(yellow, rendering, 5, 0);
        assertPixelColorEquals(yellow, rendering, 9, 4);

        assertPixelColorEquals(yellow, rendering, 0, 5);
        assertPixelColorEquals(yellow, rendering, 4, 9);

        assertPixelColorEquals(black, rendering, 5, 5);
        assertPixelColorEquals(black, rendering, 9, 9);
    }
}
