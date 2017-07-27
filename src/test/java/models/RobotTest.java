package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {
    @Test
    public void shouldSetInitialStatusOfRobot() {
        Robot robot = new Robot(1, 1, Orientation.E);
        assertEquals(1, robot.getX());
        assertEquals(1, robot.getY());
        assertEquals(Orientation.E, robot.getOrientation());
    }

    @Test
    public void shouldRotateLeft() {
        Robot robot = new Robot(1, 1, Orientation.E);
        robot.rotateLeft();
        assertEquals(Orientation.N, robot.getOrientation());
    }

    @Test
    public void shouldRotateRight() {
        Robot robot = new Robot(1, 1, Orientation.E);
        robot.rotateRight();
        assertEquals(Orientation.S, robot.getOrientation());
    }

    @Test
    public void shouldMoveForwardWhenFacingNorth() {
        Robot robot = new Robot(1, 1, Orientation.N);
        robot.moveForward();
        assertEquals(1, robot.getX());
        assertEquals(2, robot.getY());
        assertEquals(Orientation.N, robot.getOrientation());
    }

    @Test
    public void shouldMoveForwardWhenFacingSouth() {
        Robot robot = new Robot(1, 1, Orientation.S);
        robot.moveForward();
        assertEquals(1, robot.getX());
        assertEquals(0, robot.getY());
        assertEquals(Orientation.S, robot.getOrientation());
    }

    @Test
    public void shouldMoveForwardWhenFacingEast() {
        Robot robot = new Robot(1, 1, Orientation.E);
        robot.moveForward();
        assertEquals(2, robot.getX());
        assertEquals(1, robot.getY());
        assertEquals(Orientation.E, robot.getOrientation());
    }

    @Test
    public void shouldMoveForwardWhenFacingWest() {
        Robot robot = new Robot(1, 1, Orientation.W);
        robot.moveForward();
        assertEquals(0, robot.getX());
        assertEquals(1, robot.getY());
        assertEquals(Orientation.W, robot.getOrientation());
    }

}