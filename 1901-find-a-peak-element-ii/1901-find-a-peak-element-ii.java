class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int[][] arr=new int[mat.length+2][mat[0].length+2];
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    arr[i][j]=-1;
                }
                else{
                    arr[i][j]=mat[i-1][j-1];
                }
            }
        }
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                int curr=arr[i][j];
                int up=arr[i-1][j];
                int down=arr[i+1][j];
                int left=arr[i][j-1];
                int right=arr[i][j+1];
                if( (curr>up && curr>down) && (curr>left && curr>right)){
                    return new int[]{i-1,j-1};
                }

            }
        }
        return new int[]{-1,-1};
    }
}