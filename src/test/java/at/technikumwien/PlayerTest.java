package at.technikumwien;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class PlayerTest {


    @Test
    public void testPlayerConstructor() {

        char expectedMarker = 'X';
        Player player = new Player(expectedMarker);
        assertEquals(expectedMarker, player.getMarker(), "Player marker should be set correctly");
    }
    @Test
    public void testGetMarker() {
        Player player = new Player('X');
        char marker = player.getMarker();
        assertEquals('X', marker);
    }

    @Test
    public void testGetMarkerIncorrect() {
        Player player = new Player('X');
        char marker = player.getMarker();
        assertNotEquals('O', marker);
    }
}
