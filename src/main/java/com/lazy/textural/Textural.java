package com.lazy.textural;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Textural {

    private Pattern pattern;
    private int baseColor;
    private List<Textural> components = new ArrayList<Textural>();

    public Textural() {
        this(new Background(), 0x00000000);
    }

    public Textural(Pattern pattern, int baseColor) {
        this.pattern = pattern;
        this.baseColor = baseColor;
    }

    public Rendering generate(int width, int height) {
        final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for(Textural component : components) {
            final Rendering componentImage = component.generate(width, height);
            new Background().paint(new ImageAddBrush(image, componentImage), width, height);
        }
        if(components.isEmpty()) {
            pattern.paint(new FlatBrush(image, baseColor), width, height);
        }
        return new Rendering(image);
    }

    public Textural add(Textural other) {
        final Textural combination = new Textural();
        combination.components.add(this);
        combination.components.add(other);
        return combination;
    }
}
