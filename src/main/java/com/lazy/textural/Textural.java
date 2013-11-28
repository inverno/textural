package com.lazy.textural;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Textural {

    private Pattern pattern;
    private List<Textural> components = new ArrayList<>();
    private Brush brush;

    public Textural() {
        this(new Background(), new FlatBrush(0x00000000));
    }

    public Textural(Pattern pattern, int baseColor) {
        this.pattern = pattern;
        this.brush = new FlatBrush(baseColor);
    }

    public Textural(Pattern pattern, Brush brush) {
        this.pattern = pattern;
        this.brush = brush;
    }

    public Rendering generate(int width, int height) {
        final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        final Rendering rendering = new Rendering(image);
        for(Textural component : components) {
            final Rendering componentImage = component.generate(width, height);
            new Background().paint(new ImageAddBrush(image, componentImage), width, height);
        }
        if(components.isEmpty()) {
            for(Pixel pixel : pattern.iterate(width, height)) {
                rendering.set(pixel, brush.paint(pixel));
            }
        }
        return rendering;
    }

    public Textural add(Textural other) {
        final Textural combination = new Textural();
        combination.components.add(this);
        combination.components.add(other);
        return combination;
    }
}
