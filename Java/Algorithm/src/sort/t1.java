package sort;

class t1 {
    public int solution(int[][] board) {
        int answer = 0;

        for (int w = 0; w < board.length; w++) {
            for (int h = 0; h < board[0].length; h++) {
                if (board[h][w] != 0) {
                    //승리 체크
                    if (checkWin(board, w, h)) {
                        answer = board[h][w];
                        break;
                    }
                }
            }
        }
        //흑 승리 1 백 승리 2
        return answer;
    }

    public boolean checkWin(int[][] board, int w, int h) {
        boolean check = checkWidth(board, w, h);
        if (check) {
            return true;
        }
        check = checkHeigth(board, w, h);
        if (check) {
            return true;
        }
        return false;
    }

    public boolean checkWidth(int[][] board, int w, int h) {
        int check = board[h][w];
        int count = 1;

        //오른쪽
        for (int right = 1; right < 5; right++) {
            int rigthWidth = w + right;
            if (board[0].length < rigthWidth) {  //범위를 넘어선다면
                break;
            } else if (check != board[h][rigthWidth]){ //돌이 다르다면
                break;
            } else if (check == board[h][rigthWidth]){
                count++;
                if (count == 5) {
                    return true;
                }
            }
        }

        //왼쪽
        for (int left = 1; left < 5; left++) {
            int leftWidth = w - left;
            if (0 > leftWidth) {  //범위를 넘어선다면
                break;
            } else if (check != board[h][leftWidth]){ //돌이 다르다면
                break;
            } else if (check == board[h][leftWidth]){
                count++;
                if (count == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkHeigth(int[][] board, int w, int h) {
        int check = board[h][w];
        int count = 1;
        //아래
        for (int down = 1; down < 5; down++) {
            int downHeight = h + down;
            if (board.length < downHeight) {  //범위를 넘어선다면
                break;
            } else if (check != board[downHeight][w]){ //돌이 다르다면
                break;
            } else if (check == board[downHeight][w]){
                count++;
                if (count == 5) {
                    return true;
                }
            }
        }

        //위
        for (int up = 1; up < 5; up++) {
            int upHeight = h - up;
            if (0 > upHeight) {  //범위를 넘어선다면
                break;
            } else if (check != board[upHeight][w]){ //돌이 다르다면
                break;
            } else if (check == board[upHeight][w]){
                count++;
                if (count == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkLine(int[][] board, int w, int h) {
        int check = board[h][w];
        int count = 1;
        //아래 대각선
        for (int down = 1; down < 5; down++) {
            int downHeight = h + down;
            int downWidth  = w - down;
            if (board.length < downHeight || 0 > downWidth) {  //범위를 넘어선다면
                break;
            } else if (check != board[downHeight][downWidth]){ //돌이 다르다면
                break;
            } else if (check == board[downHeight][downWidth]){
                count++;
                if (count == 5) {
                    return true;
                }
            }
        }

        //위 대각선
        for (int up = 1; up < 5; up++) {
            int upHeight = h - up;
            int upWidth = w + up;
            if (0 > upHeight || board[0].length < upWidth) {  //범위를 넘어선다면
                break;
            } else if (check != board[upHeight][upWidth]){ //돌이 다르다면
                break;
            } else if (check == board[upHeight][upWidth]){
                count++;
                if (count == 5) {
                    return true;
                }
            }
        }
        return false;
    }
}