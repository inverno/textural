package com.lazy.textural;

import java.util.List;

public interface Pattern {

    List<Pixel> iterate(int width, int height);

}
