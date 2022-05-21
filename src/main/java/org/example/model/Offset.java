package org.example.model;

public record Offset(double x,
                     double y,
                     double z) {
    public static Offset of(final double x,
                            final double y,
                            final double z) {
        return new Offset(x, y, z);
    }
}
