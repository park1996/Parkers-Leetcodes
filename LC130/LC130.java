class LC130 {
    public static boolean validArea(char[][] board, boolean[][] visited, int x, int y){
        if(board[x][y]=='X'){
            visited[x][y]=true;
            return true;
        }
        else if(board[x][y]=='O'){
            visited[x][y]=true;
            boolean result = true;
            if(x+1 < board.length && !visited[x+1][y]){
                result &= validArea(board, visited, x+1, y);
            }
            else{
                result &= x+1 < board.length;
            }
            if(y+1 < board[0].length &&!visited[x][y+1]){
                result &= validArea(board, visited, x, y+1);
            }
            else{
                result &= y+1<board[0].length;
            }
            if(x-1 >= 0 && !visited[x-1][y]){
                result &= validArea(board, visited, x-1, y);
            }
            else{
                result &= x-1 >= 0;
            }
            if(y-1 >= 0 && !visited[x][y-1]){
                result &= validArea(board, visited, x, y-1);
            }
            else{
                result &= y-1>=0;
            }
            return result;
        }
        return false;
    }
    public static void flipArea(char[][] board, int x, int y){
        if(board[x][y]=='O'){
            board[x][y]='X';
            flipArea(board, x+1, y);
            flipArea(board, x, y+1);
        }
    }
    public static void solve(char[][] board) {
        if(board.length <= 0){
            return;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(i==5  && j == 5){
                    System.out.println(visited[i][j]);
                }
                if(!visited[i][j] && board[i][j]=='O'){
                    boolean isArea = validArea(board, visited, i, j);
                    if(isArea){
                        System.out.println("Is valid area");
                        flipArea(board, i, j);
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        char[][] board = {{'X','O','O','X','X','X','O','X','O','O'},{'X','O','X','X','X','X','X','X','X','X'},{'X','X','X','X','O','X','X','X','X','X'},{'X','O','X','X','X','O','X','X','X','O'},{'O','X','X','X','O','X','O','X','O','X'},{'X','X','O','X','X','O','O','X','X','X'},{'O','X','X','O','O','X','O','X','X','O'},{'O','X','X','X','X','X','O','X','X','X'},{'X','O','O','X','X','O','X','X','O','O'},{'X','X','X','O','O','X','O','X','X','O'}};
        solve(board);
    }
}