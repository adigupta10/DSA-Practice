class Solution {
    public int maximumUnits(int[][] boxTypes, int c) {
        Arrays.sort(boxTypes,(a,b)-> b[1]-a[1]);

        int sum=0;
        for(int[] x:boxTypes){
            int boxes=x[0];
            int unit=x[1];

            if(c==0) break;

            if(c>=boxes){
                c-=boxes;
                sum+=(boxes*unit);
            }
            else{
                sum+=unit*c;
                c=0;
            }
        }
        return sum;
    }
}