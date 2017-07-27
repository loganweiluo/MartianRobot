package models;

import org.junit.Test;

import java.util.Set;

import static models.Orientation.*;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.*;

public class RobotTest {
    @Test
    public void shouldSetInitialStatusOfRobot() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, E);
        assertEquals(1, robot.getLatestX());
        assertEquals(1, robot.getLatestY());
        assertEquals(E, robot.getLatestOrientation());
    }

    @Test
    public void shouldRotateLeftWhenFacingEast() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, E);
        robot.rotateLeft();
        assertEquals(N, robot.getLatestOrientation());
    }

    @Test
    public void shouldRotateLeftWhenFacingNorth() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, N);
        robot.rotateLeft();
        assertEquals(W, robot.getLatestOrientation());
    }

    @Test
    public void shouldRotateRightWhenFacingEast() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, E);
        robot.rotateRight();
        assertEquals(S, robot.getLatestOrientation());
    }

    @Test
    public void shouldRotateRightWhenFacingWest() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, W);
        robot.rotateRight();
        assertEquals(N, robot.getLatestOrientation());
    }

    @Test
    public void shouldMoveForwardWhenFacingNorth() {
        Grid grid = new Grid(3, 3);
        Robot robot = new Robot(grid, 1, 1, N);
        robot.moveForward();
        assertEquals(1, robot.getLatestX());
        assertEquals(2, robot.getLatestY());
        assertEquals(N, robot.getLatestOrientation());
    }

    @Test
    public void shouldMoveForwardWhenFacingSouth() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, S);
        robot.moveForward();
        assertEquals(1, robot.getLatestX());
        assertEquals(0, robot.getLatestY());
        assertEquals(S, robot.getLatestOrientation());
    }

    @Test
    public void shouldMoveForwardWhenFacingEast() {
        Grid grid = new Grid(3, 3);
        Robot robot = new Robot(grid, 1, 1, E);
        robot.moveForward();
        assertEquals(2, robot.getLatestX());
        assertEquals(1, robot.getLatestY());
        assertEquals(E, robot.getLatestOrientation());
    }

    @Test
    public void shouldMoveForwardWhenFacingWest() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, W);
        robot.moveForward();
        assertEquals(0, robot.getLatestX());
        assertEquals(1, robot.getLatestY());
        assertEquals(W, robot.getLatestOrientation());
    }

    @Test
    public void shouldDetectLost() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, N);
        robot.moveForward();
        assertTrue(robot.isLost());
    }

    @Test
    public void shouldReturnFalseWhenNotLost() {
        Grid grid = new Grid(3, 3);
        Robot robot = new Robot(grid, 1, 1, N);
        robot.moveForward();
        assertFalse(robot.isLost());
    }

    @Test
    public void shouldIgnoreSubsequentCommandAfterLost() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, N);
        robot.moveForward();
        assertTrue(robot.isLost());

        robot.rotateLeft();
        robot.moveForward();
        assertEquals(1, robot.getLatestX());
        assertEquals(1, robot.getLatestY());
        assertEquals(N, robot.getLatestOrientation());
    }

    @Test
    public void shouldLeaveScentAfterLost() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, N);
        robot.moveForward();
        assertTrue(robot.isLost());

        Set<Scent> scents = grid.getScents();
        assertEquals(1, scents.size());
        assertThat(scents, hasItem(samePropertyValuesAs(new Scent(1, 1, N))));
    }

    @Test
    public void shouldNotFallOffGridWithScentForTheSameCommand() {
        Grid grid = new Grid(3, 3);
        Robot robot = new Robot(grid, 1, 3, N);
        robot.moveForward();
        assertTrue(robot.isLost());

        Set<Scent> scents = grid.getScents();
        assertEquals(1, scents.size());
        assertThat(scents, hasItem(samePropertyValuesAs(new Scent(1, 3, N))));

        robot = new Robot(grid, 1, 3, N);
        robot.moveForward();
        assertFalse(robot.isLost());
    }

    @Test
    public void shouldTakeCommands() {
        Grid grid = new Grid(5, 3);
        Robot robot = new Robot(grid, 1, 1, E);
        robot.takeCommands("RFRFRFRF");
        assertEquals(1, robot.getLatestX());
        assertEquals(1, robot.getLatestY());
        assertEquals(E, robot.getLatestOrientation());
    }

    @Test
    public void shouldTakeCommandsAndIgnoreAfterLost() {
        Grid grid = new Grid(5, 3);
        Robot robot = new Robot(grid, 3, 2, N);
        robot.takeCommands("FRRFLLFFRRFLL");
        assertEquals(3, robot.getLatestX());
        assertEquals(3, robot.getLatestY());
        assertEquals(N, robot.getLatestOrientation());
        assertTrue(robot.isLost());
    }

    @Test
    public void shouldTakeCommandsWithScent() {
        Grid grid = new Grid(5, 3);
        Robot robot = new Robot(grid, 3, 2, N);
        robot.takeCommands("FRRFLLFFRRFLL");
        assertEquals(3, robot.getLatestX());
        assertEquals(3, robot.getLatestY());
        assertEquals(N, robot.getLatestOrientation());
        assertTrue(robot.isLost());

        robot = new Robot(grid, 0, 3, W);
        robot.takeCommands("LLFFFLFLFL");
        assertEquals(2, robot.getLatestX());
        assertEquals(3, robot.getLatestY());
        assertEquals(S, robot.getLatestOrientation());
    }

    @Test
    public void shouldReturnCurrentStatus() {
        Grid grid = new Grid(5, 3);
        Robot robot = new Robot(grid, 1, 1, E);
        robot.takeCommands("RFRFRFRF");
        assertEquals("1 1 E", robot.getCurrentStatus());
    }

    @Test
    public void shouldReturnCurrentStatusWhenLost() {
        Grid grid = new Grid(5, 3);
        Robot robot = new Robot(grid, 3, 2, N);
        robot.takeCommands("FRRFLLFFRRFLL");
        assertEquals("3 3 N LOST", robot.getCurrentStatus());
    }
}