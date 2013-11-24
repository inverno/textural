package com.lazy.textural;

import static org.junit.Assert.assertEquals;

public class ImageAssert {
    public static void assertColorEquals(int color, Rendering image) {
        for(int x = 0; x < 100; x++) {
            for(int y = 0; y < 100; y++) {
                assertPixelColorEquals(color, image, x, y);
            }
        }
    }

    public static void assertPixelColorEquals(int color, Rendering image, int x, int y) {
        assertEquals("Pixel[" + x + "," + y + "]", color, image.getRGB(x, y));
    }
}
