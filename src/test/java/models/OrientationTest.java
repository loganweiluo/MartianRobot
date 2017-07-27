package models;

import org.junit.Test;

import static models.Orientation.*;
import static org.junit.Assert.*;

public class OrientationTest {

    @Test
    public void shouldRotateLeft() {
        assertEquals(W, N.rotateLeft());
        assertEquals(S, W.rotateLeft());
        assertEquals(E, S.rotateLeft());
        assertEquals(N, E.rotateLeft());
    }

    @Test
    public void shouldRotateRight() {
        assertEquals(E, N.rotateRight());
        assertEquals(S, E.rotateRight());
        assertEquals(W, S.rotateRight());
        assertEquals(N, W.rotateRight());
    }
}