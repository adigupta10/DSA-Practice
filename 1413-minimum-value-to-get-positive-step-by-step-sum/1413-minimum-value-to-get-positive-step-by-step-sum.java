class Solution {
    public int minStartValue(int[] nums) {
        int l=1;
        int r=10000;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(solve(mid,nums)){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public static boolean solve(int mid,int[] nums){
        for(int i:nums){
            mid+=i;
            if(mid<1) return false;
        }
        return true;
    } 
}