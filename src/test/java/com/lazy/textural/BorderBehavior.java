package com.lazy.textural;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BorderBehavior {

    @Test
    public void generatesBorder() throws Exception {
        final List<Pixel> pixels = new Border(0).iterate(10, 10);
        assertEquals(40, pixels.size());
        assertThat(pixels, hasItem(new Pixel(0, 0)));
        assertThat(pixels, hasItem(new Pixel(0, 9)));
        assertThat(pixels, hasItem(new Pixel(9, 0)));
        assertThat(pixels, hasItem(new Pixel(9, 9)));
        assertThat(pixels, not(hasItem(new Pixel(1,1))));
        assertThat(pixels, not(hasItem(new Pixel(8,8))));
    }

}
