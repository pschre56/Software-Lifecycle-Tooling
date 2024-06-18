
    public class Field {

        private int[][] board;

        public Field() {

            board = new int[3][3];

            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 3; i++) {
                    if (board[j][i] == ) {
                        System.out.print(" O ");
                    } else if (board[j][i] == 2) {
                        System.out.print(" X ");

                    } else System.out.print(" _ ");
                }
                System.out.println();
            }
        }}
