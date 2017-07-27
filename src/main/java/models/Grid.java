package models;

import java.util.HashSet;
import java.util.Set;

public class Grid {

    private int length;
    private int width;
    private Set<Scent> scents;

    public Grid(int length, int width) {
        this.length = length;
        this.width = width;
        scents = new HashSet<Scent>();
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public Set<Scent> getScents() {
        return scents;
    }

    public void addScent(Scent scent) {
        this.scents.add(scent);
    }
}
