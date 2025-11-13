class Solution {
    public void gameOfLife(int[][] board) {
        int row=board.length; int col=board[0].length;
        int[][] arr=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j]=board[i][j];
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j]==1){
                    int ans=findLiveNeighbor(i,j,arr,board.length,board[0].length);
                    if(ans==2 || ans==3){
                        board[i][j]=1;
                    }
                    else if(ans>3){
                        board[i][j]=0;
                    }
                    else if(ans<2){
                        board[i][j]=0;
                    }
                }
                else{
                    int ans=findLiveNeighbor(i,j,arr,board.length,board[0].length);
                    if(ans==3){
                        board[i][j]=1;
                    }
                }
            }
        }
    }
    private int findLiveNeighbor(int i,int j, int[][] arr,int row,int col){
        int live=0;
        if(i+1<row && arr[i+1][j]==1) live++;
        if(i-1>=0 && arr[i-1][j]==1) live++;
        if(j+1<col && arr[i][j+1]==1) live++;
        if(j-1>=0 && arr[i][j-1]==1) live++;

        //check for diagonal elements
        if(i+1<row && j+1<col && arr[i+1][j+1]==1) live++;
        if(i-1>=0 && j-1>=0 && arr[i-1][j-1]==1) live++;
        if(i+1<row && j-1>=0 && arr[i+1][j-1]==1) live++;
        if(i-1>=0 && j+1<col && arr[i-1][j+1]==1) live++;

        return live;
    }
}