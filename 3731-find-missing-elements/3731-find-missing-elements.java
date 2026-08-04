class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int maxi=0;
        int mini=101;
        int[] freq=new int[101];
        for(int x:nums){
            maxi=Math.max(maxi,x);
            mini=Math.min(mini,x);
            freq[x]++;
        }
       ArrayList<Integer> ans=new ArrayList<>();
       for(int i=mini;i<=maxi;i++){
        if(freq[i]==0) ans.add(i);
       }
       return ans;
    }
}