package com.lazy.textural;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TexturalBehavior {

    @Test
    public void printsBlackTexture() throws IOException {
        Textural textural = new Textural("black");
        textural.print(0,100,0,100);
        BufferedImage texture = ImageIO.read(new File("black.bmp"));
        assertEquals(0, texture.getRGB(0, 0));
    }
}
