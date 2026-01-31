class Solution {
    public int pivotIndex(int[] nums) {
        int[] ps=new int[nums.length];
        ps[0]=nums[0];
        int n=nums.length;
        if(nums.length==1) return 0;
        for(int i=1;i<n;i++){
            ps[i]=ps[i-1]+nums[i];
        }
        if(ps[0]-ps[n-1]==0) return 0;
        for(int i=1;i<n;i++){
           int left=ps[i-1];
           int right=ps[n-1]-ps[i];
           if(left==right) return i;
        }
        return -1;
    }
}