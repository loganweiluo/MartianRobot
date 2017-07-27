package models;

public class Robot {

    private int x;
    private int y;
    private Orientation orientation;

    public Robot(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void rotateLeft() {
        this.orientation = this.orientation.rotateLeft();
    }

    public void rotateRight() {
        this.orientation = this.orientation.rotateRight();
    }
}
