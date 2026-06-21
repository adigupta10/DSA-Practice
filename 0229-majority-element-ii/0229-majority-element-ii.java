class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        } 
        for(int key:map.keySet()){
            if(map.get(key)>(nums.length/3)){
                ans.add(key);
            }
        }
        return ans;
    }
}