class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int arrow=1;
        int lastEnd=points[0][1];
        boolean flag=true;
        for(int[] p:points){
            //skip the first box
            if(flag) {
                flag=false;
                continue;
            }
            if(p[0]>lastEnd){
                arrow++;
                lastEnd=p[1];
            }
        }
        return arrow;
    }
}