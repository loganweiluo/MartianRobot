package models;

public class Robot {

    private Grid grid;
    private int x;
    private int y;
    private Orientation orientation;

    public Robot(Grid grid, int x, int y, Orientation orientation) {
        this.grid = grid;
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

    public void moveForward() {
        switch (this.orientation) {
            case N:
                this.y++;
                break;
            case S:
                this.y--;
                break;
            case E:
                this.x++;
                break;
            case W:
                this.x--;
                break;
        }
    }

    public boolean isLost() {
        if (this.x > grid.getLength() || this.x < 0 || this.y > grid.getWidth() || this.y < 0) {
            return true;
        }
        return false;
    }
}
