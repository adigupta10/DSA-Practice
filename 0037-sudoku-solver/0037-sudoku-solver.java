class Solution {
    private boolean isSafe(char[][] board,int row, int col,int d){
        //row check
        for(int i=0;i<9;i++){
            if(board[i][col]==d) return false;
        }
        //column check
        for(int i=0;i<9;i++){
            if(board[row][i]==d) return false;
        }
        //box check
        int start_r=row/3 *3;
        int start_c=col/3 *3;
        for(int k=0;k<3;k++){
            for(int l=0;l<3;l++){
                if(board[start_r + k][start_c + l]==d) return false;
            }
        }
        return true;
    }
    private boolean solve(char[][] board){
        int n=board.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.') continue;
                for(char d='1';d<='9';d++){
                    if(isSafe(board,i,j,d)){
                        //do
                        board[i][j]=d;
                        //explore
                        if(solve(board)==true) return true;
                        //undo
                        board[i][j]='.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
        return;
        
    }
}