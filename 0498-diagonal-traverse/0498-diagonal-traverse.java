class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int r=mat.length;
        int c=mat[0].length;
        List<List<Integer>> l=new ArrayList<>();
        for(int d=0;d<r+c-1;d++){
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    if(i+j==d) temp.add(mat[i][j]);
                }
            }
            if(d%2==0) Collections.reverse(temp);
            l.add(temp);
        }
        int[] ans=new int[r*c];
        int idx=0;
        for(List<Integer> res:l){
            for(int i:res){
                ans[idx++]=i;
            }
        }
        return ans;
    }
}