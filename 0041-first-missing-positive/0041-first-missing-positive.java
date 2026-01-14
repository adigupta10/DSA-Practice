class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int ans=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<ans) continue;
            if(nums[i]==ans) ans++;
            else if(nums[i]>ans) return ans;
        }
        return ans;
    }
}

// int n=nums.length;
//         int j=0;
//         while(j<n){
//            int correctindex=nums[j]-1;
//            if(nums[j]>0 && nums[j]<=n  && nums[j]!=nums[correctindex]){
//                 int temp=nums[j];
//                 nums[j]=nums[correctindex];
//                 nums[correctindex]=temp;
//            }
//            else{
//             j++;
//            }
//         }
//         for(int k=0;k<n;k++){
//             if(nums[k]!=k+1){
//                 return k+1;
//             }
//         }
//         return n+1;