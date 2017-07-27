package models;

public enum Orientation {
    N, E, S, W;

    public Orientation rotateLeft() {
        int index = this.ordinal() - 1;
        Orientation[] values = Orientation.values();
        if (index < 0) {
            index = index + values.length;
        }
        return values[index];
    }

    public Orientation rotateRight() {
        int index = this.ordinal() + 1;
        Orientation[] values = Orientation.values();
        if (index >= values.length) {
            index = index - values.length;
        }
        return values[index];
    }
}
