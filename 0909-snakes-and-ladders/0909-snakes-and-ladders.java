class Solution {
    public int snakesAndLadders(int[][] board) {
       int n=board.length;
       boolean[] vis=new boolean[n*n+1];
       Queue<Integer> q=new LinkedList<>();
       q.offer(1);
       vis[1]=true;
       int moves=0;
       while(!q.isEmpty()){
         int size=q.size();
         for(int i=0;i<size;i++){
            int curr=q.poll();
            if(curr==n*n){
                return moves;
            }
            for(int dice=1;dice<=6;dice++){
                int next=curr+dice;
                if(next>n*n) break;
                int[] pos=getPosition(next,n);
                int row=pos[0];
                int col=pos[1];
                if(board[row][col]!=-1){
                    next=board[row][col];
                }
                if(!vis[next]){
                    vis[next]=true;
                    q.offer(next);
                }
            }
         }
         moves++;
       }
       return -1;
    }

    private int[] getPosition(int num,int n){
        int RT=(num-1)/n;
        int RB=(n-1)-RT;

        int col=(num-1)%n;
        if((n%2==1 && RB%2==1) || n%2==0 && RB%2==0 ){
            col=(n-1)-col;
        }
        return new int[]{RB,col};
    }
}