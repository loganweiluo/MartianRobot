package models;

public class Robot {

    private Grid grid;
    private int x;
    private int y;
    private Orientation orientation;

    private int lastSeenX;
    private int lastSeenY;
    private Orientation lastSeenOrientation;

    public Robot(Grid grid, int x, int y, Orientation orientation) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.orientation = orientation;

        this.lastSeenX = this.x;
        this.lastSeenY = this.y;
        this.lastSeenOrientation = this.orientation;
    }

    public int getLatestX() {
        if (isLost()) {
            return lastSeenX;
        }
        return x;
    }

    public int getLatestY() {
        if (isLost()) {
            return lastSeenY;
        }
        return y;
    }

    public Orientation getLatestOrientation() {
        if (isLost()) {
            return lastSeenOrientation;
        }
        return orientation;
    }

    public void rotateLeft() {
        if (!isLost()) {
            this.orientation = this.orientation.rotateLeft();
        }
    }

    public void rotateRight() {
        if (!isLost()) {
            this.orientation = this.orientation.rotateRight();
        }
    }

    public void moveForward() {
        if (!isLost()) {
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
        if (!isLost()) {
            this.lastSeenX = this.x;
            this.lastSeenY = this.y;
            this.lastSeenOrientation = this.orientation;
        }
    }

    public boolean isLost() {
        if (this.x > grid.getLength() || this.x < 0 || this.y > grid.getWidth() || this.y < 0) {
            return true;
        }
        return false;
    }
}
