class Solution {
    char[][] board;
    List<List<String>> ans=new ArrayList<>();
    int N;
    private List<String> convert(char[][] board){
        List<String> temp=new ArrayList<>();
        for(char[] i:board) temp.add(new String(i));   // {'.','Q','.','.'} -> ["..Q."]  and so on
        return temp;
    }
    private boolean isSafe(char[][] board,int row , int col){
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
    private void solve(char[][] board,int row){
        if(row>=N){
            ans.add(convert(board));  // to convert board(2r array) into listOfString we use another function
            return;
        }
        for(int col=0;col<N;col++){
            if(isSafe(board,row,col)){
                //do
                board[row][col]='Q';
                //explore
                solve(board,row+1);
                //undo
                board[row][col]='.';
            }    
        }
    }
    public List<List<String>> solveNQueens(int n) {
        N=n;
        board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        solve(board,0);
        return ans;

    }
}