package at.technikumwien;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

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

    @Test
    void testWinningBoard() {
        Board board = game.getBoard();
        char playerMarker = game.getPlayer1().getMarker();

        board.setCell(0, 0, playerMarker);
        board.setCell(0, 1, playerMarker);
        board.setCell(0, 2, playerMarker);

        boolean hasWinner = game.GetWinner();

        assertTrue(hasWinner, "Die hasWinner Methode sollte true zurückgeben, da Spieler 1 gewonnen hat");
    }

    @Test
    void testInvalidMove() {
        Board board = game.getBoard();
        char playerMarker = game.getCurrentPlayer().getMarker();

        board.setCell(0, 0, playerMarker);
        boolean isValidMove = game.isValidMove(0, 0);

        assertFalse(isValidMove, "Sollte ungültig sein, da das Feld bereits belegt ist");
    }
    @Test
    void testDraw() {
        Board board = game.getBoard();

        board.setCell(0, 0, 'X');
        board.setCell(0, 1, 'O');
        board.setCell(0, 2, 'X');
        board.setCell(1, 0, 'O');
        board.setCell(1, 1, 'X');
        board.setCell(1, 2, 'O');
        board.setCell(2, 0, 'O');
        board.setCell(2, 1, 'X');
        board.setCell(2, 2, 'O');

        boolean isFull = board.isFull();
        boolean hasWinner = game.GetWinner();

        assertTrue(isFull, "Das Board sollte voll sein.");
        assertFalse(hasWinner, "Es sollte keinen Gewinner geben.");
    }
    @Test
    void testInitialBoardState() {
        Board board = game.getBoard();
        boolean allCellsEmpty = true;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (!board.isCellEmpty(row, col)) {
                    allCellsEmpty = false;
                    break;
                }
            }
        }
        assertTrue(allCellsEmpty, "Alle Felder müssten leer sein.");
    }
    @Test
    void testFullGamePlay() {
        String input = "1 1\n1 2\n2 2\n1 3\n3 3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        game.start();

        boolean hasWinner = game.GetWinner();
        char winnerMarker = game.getCurrentPlayer().getMarker();

        assertTrue(hasWinner, "Es sollte einen Gewinner geben.");
        assertEquals('X', winnerMarker, "Spieler X sollte gewonnen haben.");
    }

}