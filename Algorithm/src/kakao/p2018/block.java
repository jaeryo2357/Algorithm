package kakao.p2018;

public class block {

    //  반목문 반복시 높이 , 가로 순으로 반복해야 빠름..??
    public static void main(String[] args) {
        String[] board = new String[] {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(4, 5, board));
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] charBoard = new char[m][n];

        for (int i = 0; i < m; i++) {
            charBoard[i] = board[i].toCharArray();
        }

        while (true) {
            int count = calculateBlockSame(n, m, charBoard);
            if (count == 0) {
                break;
            }

            checkBoardSort(n, m, charBoard);
            answer += count;
        }

        return answer;
    }

    /**
     * block을 체크하며 동일한 블럭이 있는 지 확인
     * @param n 체크하고자 하는 블럭의 가로
     * @param m 체크하고자 하는 블럭의 세로
     */
    public static int calculateBlockSame(int n, int m, char[][] board) {

        boolean[][] checkBoard = new boolean[m][n];

        for (int h = 0; h < m - 1; h++) {
            for (int w = 0; w < n - 1; w++) {
                if (board[h][w] != '0') {
                    checkBoard(w, h, board, checkBoard);
                }
            }
        }

        int deleteBlockCount = 0;

        for (int h = 0; h < m; h++) {
            for (int w = 0; w < n; w++) {
                if (checkBoard[h][w]) {
                    deleteBlockCount++;
                    board[h][w] = '0';
                }
            }
        }

        return deleteBlockCount;
    }

    public static void checkBoard(int n, int m, char[][] board, boolean[][] checkBoard) {
        char target = board[m][n];

        for (int h = m; h <= m + 1; h++) {
            for (int w = n; w <= n + 1; w++) {
                if (target != board[h][w]) {
                    return;
                }
            }
        }

        //4개 맞으므로 true 로 변경
        for (int h = m; h <= m + 1; h++) {
            for (int w = n; w <= n + 1; w++) {
                checkBoard[h][w] = true;
            }
        }
    }

    public static void checkBoardSort(int n, int m, char[][] board) {
        for (int h = m - 1; h > 0; h--) {
            for (int w = 0; w < n; w++) {
                if (board[h][w] == '0') {

                    int startHeight = h - 1;
                    while (startHeight >= 0 && board[startHeight][w] == '0') {
                        startHeight--;
                    }
                    if (startHeight >= 0) {
                        char temp = board[h][w];
                        board[h][w] = board[startHeight][w];
                        board[startHeight][w] = temp;
                    }
                }
            }
        }
    }
}
