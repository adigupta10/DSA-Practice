class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix[0].length;
        //tranpose of a matrix
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //reverse of a matrix
        for(int i=0;i<n;i++){
            int k=matrix[0].length-1;
            for(int j=0;j<n/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][k];
                matrix[i][k]=temp;
                k--;
            }
        }
    }
}