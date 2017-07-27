package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {
    @Test
    public void shouldSetInitialStatusOfRobot() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, Orientation.E);
        assertEquals(1, robot.getLatestX());
        assertEquals(1, robot.getLatestY());
        assertEquals(Orientation.E, robot.getLatestOrientation());
    }

    @Test
    public void shouldRotateLeftWhenFacingEast() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, Orientation.E);
        robot.rotateLeft();
        assertEquals(Orientation.N, robot.getLatestOrientation());
    }

    @Test
    public void shouldRotateLeftWhenFacingNorth() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, Orientation.N);
        robot.rotateLeft();
        assertEquals(Orientation.W, robot.getLatestOrientation());
    }

    @Test
    public void shouldRotateRightWhenFacingEast() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, Orientation.E);
        robot.rotateRight();
        assertEquals(Orientation.S, robot.getLatestOrientation());
    }

    @Test
    public void shouldRotateRightWhenFacingWest() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, Orientation.W);
        robot.rotateRight();
        assertEquals(Orientation.N, robot.getLatestOrientation());
    }

    @Test
    public void shouldMoveForwardWhenFacingNorth() {
        Grid grid = new Grid(3, 3);
        Robot robot = new Robot(grid, 1, 1, Orientation.N);
        robot.moveForward();
        assertEquals(1, robot.getLatestX());
        assertEquals(2, robot.getLatestY());
        assertEquals(Orientation.N, robot.getLatestOrientation());
    }

    @Test
    public void shouldMoveForwardWhenFacingSouth() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, Orientation.S);
        robot.moveForward();
        assertEquals(1, robot.getLatestX());
        assertEquals(0, robot.getLatestY());
        assertEquals(Orientation.S, robot.getLatestOrientation());
    }

    @Test
    public void shouldMoveForwardWhenFacingEast() {
        Grid grid = new Grid(3, 3);
        Robot robot = new Robot(grid, 1, 1, Orientation.E);
        robot.moveForward();
        assertEquals(2, robot.getLatestX());
        assertEquals(1, robot.getLatestY());
        assertEquals(Orientation.E, robot.getLatestOrientation());
    }

    @Test
    public void shouldMoveForwardWhenFacingWest() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, Orientation.W);
        robot.moveForward();
        assertEquals(0, robot.getLatestX());
        assertEquals(1, robot.getLatestY());
        assertEquals(Orientation.W, robot.getLatestOrientation());
    }

    @Test
    public void shouldDetectLost() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, Orientation.N);
        robot.moveForward();
        assertTrue(robot.isLost());
    }

    @Test
    public void shouldReturnFalseWhenNotLost() {
        Grid grid = new Grid(3, 3);
        Robot robot = new Robot(grid, 1, 1, Orientation.N);
        robot.moveForward();
        assertFalse(robot.isLost());
    }

    @Test
    public void shouldIgnoreSubsequentCommandAfterLost() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, Orientation.N);
        robot.moveForward();
        assertTrue(robot.isLost());

        robot.rotateLeft();
        robot.moveForward();
        assertEquals(1, robot.getLatestX());
        assertEquals(1, robot.getLatestY());
        assertEquals(Orientation.N, robot.getLatestOrientation());
    }

}