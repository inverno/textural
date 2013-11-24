package com.lazy.textural;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

    public void print(int width, int height, String fileName) {
        storeAsPNG(fileName, generate(width, height));
    }

    public void storeAsPNG(String fileName, BufferedImage image) {
        try {
            FileOutputStream output = new FileOutputStream(fileName);
            ImageIO.write(image, "PNG", output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage generate(int width, int height) {
        final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for(Textural component : components) {
            final BufferedImage componentImage = component.generate(width, height);
            new Background().paint(new ImageAddBrush(image, componentImage), width, height);
        }
        if(components.isEmpty()) {
            pattern.paint(new FlatBrush(image, baseColor), width, height);
        }
        return image;
    }

    public BufferedImage retrieveImage(String fileName) throws IOException {
        return ImageIO.read(new FileInputStream(fileName));
    }

    public Textural add(Textural other) {
        final Textural combination = new Textural();
        combination.components.add(this);
        combination.components.add(other);
        return combination;
    }
}
