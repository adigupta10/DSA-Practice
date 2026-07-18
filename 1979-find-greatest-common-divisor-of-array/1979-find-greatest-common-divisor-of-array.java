class Solution {
    public int findGCD(int[] nums) {
       int mini=1001;
       int maxi=0;
       for(int i=0;i<nums.length;i++){
            mini=Math.min(mini,nums[i]);
            maxi=Math.max(maxi,nums[i]);
       } 
       return gcd(mini,maxi);
    }
    public static int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a,a);
    }
}