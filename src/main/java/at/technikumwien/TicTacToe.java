package at.technikumwien;

import java.util.Scanner;

public class TicTacToe {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    // Konstruktor, der das Spiel initialisiert und Spieler, sowie das Spielfeld erstellt
    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1; // Spieler 1 beginnt das Spiel
        board = new Board();
    }
    // Startet das Spiel
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        while (!gameWon && !board.isFull()) {
            board.print();
            System.out.println("Spieler " + currentPlayer.getMarker() + " ist an der Reihe.");
            System.out.print("Geben Sie die Zeile und Spalte ein (z.B. 1 1 für oberste linke Ecke): ");

            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (isValidMove(row, col)) {
                board.place(row, col, currentPlayer.getMarker());

                if (hasWinner()) {
                    gameWon = true;
                    System.out.println("Spieler " + currentPlayer.getMarker() + " hat gewonnen!");
                } else {
                    switchCurrentPlayer();
                }
            } else {
                System.out.println("Ungültiger Zug. Bitte versuchen Sie es erneut.");
            }
        }

        if (!gameWon) {
            System.out.println("Das Spiel endet unentschieden!");
        }

        board.print();
        scanner.close();
    }
    // Wechselt den aktuellen Spieler
    private void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    // Überprüft, ob der aktuelle Spieler gewonnen hat
    private boolean hasWinner() {
        // Überprüfen der Zeilen
        for (int i = 0; i < 3; i++) {
            if (board.isCellEmpty(i, 0)) continue;
            if (board.cells[i][0] == board.cells[i][1] && board.cells[i][1] == board.cells[i][2]) {
                return true;
            }
        }

        // Überprüfen der Spalten
        for (int i = 0; i < 3; i++) {
            if (board.isCellEmpty(0, i)) continue;
            if (board.cells[0][i] == board.cells[1][i] && board.cells[1][i] == board.cells[2][i]) {
                return true;
            }
        }

        // Überprüfen der Diagonalen
        if (!board.isCellEmpty(1, 1)) {
            if ((board.cells[0][0] == board.cells[1][1] && board.cells[1][1] == board.cells[2][2]) ||
                    (board.cells[0][2] == board.cells[1][1] && board.cells[1][1] == board.cells[2][0])) {
                return true;
            }
        }

        return false;
    }
    // Überprüft, ob der Zug gültig ist (d.h. das Feld ist leer und innerhalb des Spielfelds)
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board.isCellEmpty(row, col);
    }

    public boolean GetWinner(){
        return hasWinner();
    }
}
