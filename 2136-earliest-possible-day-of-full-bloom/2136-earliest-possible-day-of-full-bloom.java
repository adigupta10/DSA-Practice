class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n=plantTime.length;
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=plantTime[i];
            arr[i][1]=growTime[i];
       }
       Arrays.sort(arr,(a,b)-> b[1]-a[1]);
       int maxi=0;
       int prevPlantDays=0;
       for(int i=0;i<n;i++){
            int currPlantTime=arr[i][0];
            int currPlantGrow=arr[i][1];
            prevPlantDays+=currPlantTime;
            maxi=Math.max(maxi,prevPlantDays+ currPlantGrow);
       }
       return maxi;
    }
}