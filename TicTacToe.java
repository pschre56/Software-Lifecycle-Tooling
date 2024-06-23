import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    private char[][] cells; // Declare cells here

    public TicTacToe() {
        this.board = new Board();
        this.cells = this.board.getCells(); // Initialize cells here after board is initialized
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
    }

    public void start() {
        board.print();
        Scanner sc = new Scanner(System.in);
        int row;
        int col;
        boolean gameWon = false;

        while (!gameWon && !board.isFull()) {
            System.out.println("Current player: " + currentPlayer.getMarker());

            System.out.print("row (1-3): ");
            row = sc.nextInt() -1;
            System.out.print("column (1-3): ");
            col = sc.nextInt() -1;

            while(row < 0 || row > 2 || col < 0 || col > 2){
                System.out.println("Invalid input. Please try again.");
                System.out.print("row (1-3): ");
                row = sc.nextInt() -1;
                System.out.print("column (1-3): ");
                col = sc.nextInt() -1;
            }

            if (board.isCellEmpty(row, col)) {
                board.place(row, col, currentPlayer.getMarker());
                board.print();
                if (hasWinner()) {
                    gameWon = true;
                    System.out.println("Player " + currentPlayer.getMarker() + " has won!");
                } else {
                    switchCurrentPlayer();
                    board.print();
                }
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }

        if (!gameWon && board.isFull()) {
            System.out.println("The game ends in a draw!");
        }
        sc.close();
    }

    private void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private boolean hasWinner() {
        // Use cells directly instead of retrieving it from board again
        for (int i = 0; i < 3; i++) {
            if (!board.isCellEmpty(i, 0)) {
                if (cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (!board.isCellEmpty(0, i)) {
                if (cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i]) {
                    return true;
                }
            }
        }
        if (!board.isCellEmpty(1, 1)) {
            if ((cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) ||
                    (cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}