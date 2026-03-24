class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(board[i][j]=='O'){
                        dfs(i,j,board);
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='#') board[i][j]='O';
            }
        }
    }

    public void dfs(int i,int j,char[][] b){
        if(i<0 || j<0 || i>=b.length || j>=b[0].length || b[i][j]!='O')
            return;

        b[i][j]='#';

        dfs(i+1,j,b);
        dfs(i-1,j,b);
        dfs(i,j+1,b);
        dfs(i,j-1,b);
    }
}