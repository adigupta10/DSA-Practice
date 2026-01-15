class Solution {
    public void solve(char[][] board) {
        Queue<int[]> q=new LinkedList<>();
        int m=board.length; //row
        int n=board[0].length; //col
        boolean[][] vis=new boolean[m][n];   //false values se initialise ho rha hai
        //row
        for(int j=0;j<n;j++){
            if(board[0][j]=='O' && !vis[0][j]){
                vis[0][j]=true;
                q.offer(new int[]{0,j});
            }
            if(board[m-1][j]=='O' && !vis[m-1][j]){
                vis[m-1][j]=true;
                q.offer(new int[]{m-1,j});
            }
        }
        //col
        for(int i=0;i<m;i++){
            if(board[i][0]=='O' && !vis[i][0]){
                vis[i][0]=true;
                q.offer(new int[]{i,0});
            }
            if(board[i][n-1]=='O' && !vis[i][n-1]){
                vis[i][n-1]=true;
                q.offer(new int[]{i,n-1});
            }
        }
        int[][] direction={{0,1},{-1,0},{0,-1},{1,0}};
        while(!q.isEmpty()){
            int[] cell=q.poll();
            int r=cell[0];
            int c=cell[1];
            for(int[] dir:direction){
                int nr=r+dir[0];
                int nc=c+dir[1];
                if(nc>=0  && nc<n  && nr>=0 && nr<m && board[nr][nc]=='O' && vis[nr][nc]!=true){
                    vis[nr][nc]=true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && vis[i][j]==false){
                    board[i][j]='X';
                }
            }
        }
    }
}