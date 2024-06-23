public class Board {
    private char[][] cells;
    public char[][] getCells(){
        return cells;
    }
    public Board(){
        cells = new char[3][3];
        clear();
    }
    public boolean isCellEmpty(int x, int y){
        return cells[x][y] == '\0';
    }
    public void place(int x, int y, char marker){
        cells[x][y] = marker;
    }
    public boolean isFull(){
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (cells[row][col] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }
    public void clear() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                cells[row][col] = '\0';
            }
        }
    }
    public void print() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                char symbol = cells[row][col] == '\0' ? ' ' : cells[row][col];
                System.out.print(symbol + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}