class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n=capacity.length;
        int[] remaining=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            remaining[i]=capacity[i]-rocks[i];
        }
        Arrays.sort(remaining);
        for(int j:remaining){
            if(j==0){
                count++;
            }
            else if(additionalRocks>=j){
                count++;
                additionalRocks-=j;
            }
            else{
                break;
            }
        }
        return count;
    }
}