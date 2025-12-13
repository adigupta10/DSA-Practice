class Solution {
    char[][] board;
    int N;
    int count;
    private boolean isSafe(int row , int col){
        //look upward
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q') return false;
        }
        //right diagonal upward
        for(int i=row-1,j=col+1;i>=0 && j<N;i--,j++){
            if(board[i][j]=='Q') return false;
        }
        //left diagonal upward
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
    private void solve(int row){
        if(row>=N){
            count++;
            return;
        }
        for(int col=0;col<N;col++){
            if(isSafe(row,col)){
                //do
                board[row][col]='Q';
                //explore
                solve(row+1);
                //undo
                board[row][col]='.';
            }    
        }
    }
    public int totalNQueens(int n) {
        N=n;
        board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        solve(0);
        return count;

    }
}