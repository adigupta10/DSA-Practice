class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int total=0; int count=0;
        int[] prefsum=new int[n];
        prefsum[0]=nums[0];
        for(int i=1;i<n;i++){
            prefsum[i]=prefsum[i-1]+nums[i];
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int j=0;j<n;j++){
            if(prefsum[j]==k) count++;
            int val=prefsum[j]-k;
            if(map.containsKey(val)){
                count+=map.get(val);
            }
            map.put(prefsum[j],map.getOrDefault(prefsum[j],0)+1);
        }
        return count;
    }
}