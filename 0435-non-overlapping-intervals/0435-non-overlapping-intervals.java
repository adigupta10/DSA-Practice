class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        int n=intervals.length;
        int st=intervals[0][0];
        int ed=intervals[0][1];
        int count=0;
        for(int i=1;i<n;i++){
            int currst=intervals[i][0];
            int curred=intervals[i][1];
            if(currst<ed) {
                count++;
             ed=Math.min(ed,curred); 
             }
            else{
                ed=curred;
            }
        }
        return count;
    }
}