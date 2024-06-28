package at.technikumwien;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
    }

    @Test
    void testSwitchCurrentPlayer() {
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();
        Player currentPlayer = game.getCurrentPlayer();

        game.switchCurrentPlayer();
        assertEquals(player2, game.getCurrentPlayer());

        game.switchCurrentPlayer();
        assertEquals(player1, game.getCurrentPlayer());
    }

    @Test
    public void testHasNoWinner () {
        TicTacToe game = new TicTacToe();
        boolean winner = game.GetWinner();
        assertEquals(false, winner, "Es sollte keinen Gewinner haben");
    }
    @Test
    public void testHasAWinner () {
        TicTacToe game = new TicTacToe();
        boolean winner = game.GetWinner();
        assertNotEquals(true, winner, "Es sollte einen Gewinner haben");
    }
}