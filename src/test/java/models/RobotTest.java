package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {
    @Test
    public void shouldSetInitialStatusOfRobot() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, Orientation.E);
        assertEquals(1, robot.getX());
        assertEquals(1, robot.getY());
        assertEquals(Orientation.E, robot.getOrientation());
    }

    @Test
    public void shouldRotateLeft() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, Orientation.E);
        robot.rotateLeft();
        assertEquals(Orientation.N, robot.getOrientation());
    }

    @Test
    public void shouldRotateRight() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, Orientation.E);
        robot.rotateRight();
        assertEquals(Orientation.S, robot.getOrientation());
    }

    @Test
    public void shouldMoveForwardWhenFacingNorth() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, Orientation.N);
        robot.moveForward();
        assertEquals(1, robot.getX());
        assertEquals(2, robot.getY());
        assertEquals(Orientation.N, robot.getOrientation());
    }

    @Test
    public void shouldMoveForwardWhenFacingSouth() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, Orientation.S);
        robot.moveForward();
        assertEquals(1, robot.getX());
        assertEquals(0, robot.getY());
        assertEquals(Orientation.S, robot.getOrientation());
    }

    @Test
    public void shouldMoveForwardWhenFacingEast() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, Orientation.E);
        robot.moveForward();
        assertEquals(2, robot.getX());
        assertEquals(1, robot.getY());
        assertEquals(Orientation.E, robot.getOrientation());
    }

    @Test
    public void shouldMoveForwardWhenFacingWest() {
        Grid grid = new Grid(1, 1);
        Robot robot = new Robot(grid, 1, 1, Orientation.W);
        robot.moveForward();
        assertEquals(0, robot.getX());
        assertEquals(1, robot.getY());
        assertEquals(Orientation.W, robot.getOrientation());
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

}