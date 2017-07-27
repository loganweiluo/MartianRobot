package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridTest {
    @Test
    public void shouldSetSizeOfGrid(){
        Grid grid = new Grid(5, 3);
        assertEquals(5, grid.getLength());
        assertEquals(3, grid.getWidth());
    }

}