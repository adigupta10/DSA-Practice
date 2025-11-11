class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] arr1=new int[matrix.length];
        int[] arr2=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            int ans1=matrix[i][0];
            for(int j=1;j<matrix[i].length;j++){
               ans1= Math.min(ans1,matrix[i][j]);
            }
            arr1[i]=ans1;
        }
        for(int j=0;j<matrix[0].length;j++){
            int ans2=matrix[0][j];
            for(int i=1;i<matrix.length;i++){
               ans2= Math.max(ans2,matrix[i][j]);
            }
            arr2[j]=ans2;
        }
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                if(arr1[i]==arr2[j]){
                    a.add(arr1[i]);
                }
            }
        }
        return a;
    }
}