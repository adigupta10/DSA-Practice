class Solution {
    public int diagonalSum(int[][] mat) {
        int n=mat.length;
        int sum=0;
        int sidesum=n-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                   sum+=mat[i][j];
                }
                if(i+j==sidesum){
                    sum+=mat[i][j];
                }

            }
        }
        if(n%2!=0){
            int x=n/2;
            sum-=mat[x][x];
        }
        return sum;
    }
}