package at.technikumwien;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    @Test
    public void testIsNotWinner () {
        TicTacToe game = new TicTacToe();
        boolean winner = game.GetWinner();
        assertEquals(false, winner, "Spieler 1 hat verloren!");
    }
}