package org.example.model;

import java.util.Arrays;
import java.util.List;

public enum WingsLayout {
    RECTANGLE(),
    CIRCLE();

    private final List<Offset> offsets;

    WingsLayout(final Offset... offsets) {
        this.offsets = Arrays.asList(offsets);
    }

    public List<Offset> getOffsets() {
        return offsets;
    }
}
