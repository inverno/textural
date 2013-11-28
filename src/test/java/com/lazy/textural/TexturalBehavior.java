package com.lazy.textural;

import org.junit.Test;

import static com.lazy.textural.ImageAssert.assertColorEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TexturalBehavior {

    @Test
    public void generatesSquareTexture() throws Exception {
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
    public void mockolo() {
        Brush brush = mock(Brush.class);
        when(brush.paint(new Pixel(1,1))).thenReturn(0xff990099);
        assertThat(brush.paint(new Pixel(1,1)), is(0xff990099));
        verify(brush).paint(new Pixel(1,1));
    }

}
