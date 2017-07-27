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

}