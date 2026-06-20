class Solution {
    public void setZeroes(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        HashSet<Integer> rset=new HashSet<>();
        HashSet<Integer> cset=new HashSet<>();
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    rset.add(i);
                    cset.add(j);
                }
            }
         }
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rset.contains(i) || cset.contains(j)){
                    mat[i][j]=0;
                }
            }
         }
    }
}