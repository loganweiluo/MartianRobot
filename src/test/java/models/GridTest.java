package models;

import org.junit.Test;

import java.util.Set;

import static models.Orientation.E;
import static models.Orientation.N;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GridTest {
    @Test
    public void shouldSetSizeOfGrid() {
        Grid grid = new Grid(5, 3);
        assertEquals(5, grid.getLength());
        assertEquals(3, grid.getWidth());
    }

    @Test
    public void shouldLeaveMultipleScentForGrid() {
        Grid grid = new Grid(3, 3);
        Robot robot = new Robot(grid, 1, 3, N);
        robot.moveForward();
        assertTrue(robot.isLost());

        Set<Scent> scents = grid.getScents();
        assertEquals(1, scents.size());
        assertThat(scents, hasItem(samePropertyValuesAs(new Scent(1, 3, N))));

        robot = new Robot(grid, 3, 1, E);
        robot.moveForward();
        assertTrue(robot.isLost());
        assertEquals(2, scents.size());

        assertThat(scents, hasItem(samePropertyValuesAs(new Scent(3, 1, E))));
        assertThat(scents, hasItem(samePropertyValuesAs(new Scent(1, 3, N))));
    }
}