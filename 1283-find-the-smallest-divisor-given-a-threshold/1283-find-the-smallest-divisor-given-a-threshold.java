class Solution {
    public static boolean solve(int mid,int[] nums,int t){
        int sum=0;
        for(int x:nums){
            sum+=Math.ceil((double) x/mid);
        }
        return sum<=t;
    }
    public int smallestDivisor(int[] nums, int t) {
        int l=1;
        int h=-1;
        for(int i:nums){
            h=Math.max(h,i);
        }
        int ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(solve(mid,nums,t)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}