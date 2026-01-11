class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n=maze.length; int m=maze[0].length;
        int[][] dir={{1,0},{-1,0},{0,-1},{0,1}};
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{entrance[0],entrance[1],0});
        maze[entrance[0]][entrance[1]]='+'; //mark visited
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int i=curr[0];
            int j=curr[1];
            int steps=curr[2];

            for(int[] d:dir){
                int nr=i+d[0];
                int nc=j+d[1];
                //write valid condn.
                if(nr>=0 && nc>=0 && nr<n && nc<m && maze[nr][nc]=='.'){
                    if(nr==0 || nc==0 || nr==n-1 || nc==m-1){
                        return steps+1;
                    }
                    maze[nr][nc]='+';
                    q.add(new int[]{nr,nc,steps+1});
                }
            }
        }
        return -1;
    }
}