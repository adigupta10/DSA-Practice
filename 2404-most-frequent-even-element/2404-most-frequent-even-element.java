class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int x:nums){
            if(x%2==0){
                map.put(x,map.getOrDefault(x,0)+1);
            }
        }
        int ans=-1;
        int freq=-1;
        for(int key:map.keySet()){
            if(map.get(key)>freq){
                freq=map.get(key);
                ans=key;
            }
            else if(map.get(key)==freq){
                ans=Math.min(key,ans);
            }
        }
        return ans;
    }
}