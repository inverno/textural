package com.lazy.textural;

import java.util.List;

public interface Pattern {
    void paint(Brush brush, int width, int height);

    List<Pixel> iterate(int width, int height);
}
