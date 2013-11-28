package com.lazy.textural;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CheckeredBrushBehavior {

    @Test
    public void generatesCheckeredTexture() throws Exception {
        final int black = 0xff0000ff;
        final int yellow = 0xffffff00;
        final CheckeredBrush brush = new CheckeredBrush(black, yellow, 2, 2);

        assertThat(brush.paint(new Pixel(0,0)), is(black));
        assertThat(brush.paint(new Pixel(2,2)), is(black));

        assertThat(brush.paint(new Pixel(0,2)), is(yellow));
        assertThat(brush.paint(new Pixel(2,0)), is(yellow));
    }

}
