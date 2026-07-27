class Solution {
    public int findLongestChain(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        int ps=arr[0][0];
        int pe=arr[0][1];
        int count=1;
        for(int i=1;i<arr.length;i++){
            int cs=arr[i][0];
            int ce=arr[i][1];
            if(cs>pe){
                count++;
                pe=ce;
            }
        }
        return count;
    }
}