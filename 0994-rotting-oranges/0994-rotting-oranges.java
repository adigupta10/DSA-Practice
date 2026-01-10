class Solution {
    static class Node{
        int r,c,t;
        Node(int r,int c,int t){
            this.r=r;
            this.c=c;
            this.t=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Node> q=new LinkedList<>();
        int row=grid.length;   
        int col=grid[0].length; 
        boolean[][] vis=new boolean[row][col];
        int fresh=0;  
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    q.offer(new Node(i,j,0));
                }
                else if(grid[i][j]==1) fresh++;
            }
        }
        int ans=0;
        while(!q.isEmpty()){
            Node curr=q.poll();
            int i=curr.r;
            int j=curr.c;
            int t=curr.t;

            ans=Math.max(ans,t);
            if(i+1<row && !vis[i+1][j] && grid[i+1][j]==1){
                q.offer(new Node(i+1,j,t+1));
                vis[i+1][j]=true;
                fresh--;
            }
            if(i-1>=0 && !vis[i-1][j] && grid[i-1][j]==1){
                q.offer(new Node(i-1,j,t+1));
                vis[i-1][j]=true;
                fresh--;
            }
            if(j+1<col && !vis[i][j+1] && grid[i][j+1]==1){
                q.offer(new Node(i,j+1,t+1));
                vis[i][j+1]=true;
                fresh--;
            }
            if(j-1>=0 && !vis[i][j-1] && grid[i][j-1]==1){
                q.offer(new Node(i,j-1,t+1));
                vis[i][j-1]=true;
                fresh--;
            }
        }
        return fresh==0 ? ans : -1;
    }
}