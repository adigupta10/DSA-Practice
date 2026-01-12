class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int maxi=0;
        for(int i=1;i<points.length;i++){
            int start=Math.abs(points[i-1][0]-points[i][0]);
            int end=Math.abs(points[i-1][1]-points[i][1]);
            maxi+=Math.max(start,end);
        }
        return maxi;
    }
}