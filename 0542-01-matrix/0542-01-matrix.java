class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        boolean[][] vis=new boolean[n][m];

        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                    vis[i][j]=true;
                }
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
                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==false){
                    mat[nr][nc]=mat[r][c]+1;
                    q.offer(new int[]{nr,nc});
                    vis[nr][nc]=true;
                }
            }
        }
        return mat;
    }
}