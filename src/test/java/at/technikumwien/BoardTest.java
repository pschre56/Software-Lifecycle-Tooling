package at.technikumwien;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @Test
    public void testArrayLength() {
        Board board = new Board();
        char[][] cells = board.getCells();
        assertEquals(3, cells.length);
        for (int i = 0; i < cells.length; i++) {
            assertEquals(3, cells[i].length);
        }
    }

    @Test
    public void testBoardConstructor() {
        Board board = new Board();
        char[][] cells = board.getCells();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', cells[i][j]);

            }
        }
    }

    @Test
    void testIsCellEmpty_EmptyCell() {
        Board board = new Board();

        int x = 0;
        int y = 0;
        boolean isEmpty = board.isCellEmpty(x, y);
        assertTrue(isEmpty, "Zelle sollte leer sein");
    }

    @Test
    void testIsCellEmpty_NonEmptyCell() {
        Board board = new Board();

        int x = 1;
        int y = 1;
        char marker = 'X';
        board.place(x, y, marker);
        boolean isEmpty = board.isCellEmpty(x, y);
        assertFalse(isEmpty, "Zelle sollte nicht leer sein");
    }

    @Test
    public void testisFull() {
        Board board = new Board();
        char[][] cells = board.getCells();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = 'X';
            }
        }
        boolean isFull = board.isFull();
        assertTrue(isFull, "Das Spielfeld sollte voll sein");
    }



    @Test
    public void testClearBoard() {
        Board board = new Board();
        board.getCells()[0][0] = 'X';
        board.clear();
        char[][] cells = board.getCells();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', cells[i][j]);
            }
        }
    }

    @Test
    public void testSetCell() {
        Board board = new Board();
        board.setCell(1, 1, 'X');
        char[][] cells = board.getCells();
        assertEquals('X', cells[1][1]);
    }


}

