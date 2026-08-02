class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
       HashMap<Integer,Integer> map=new HashMap<>();
       map.put(0,1);
       int oddsum=0;
       int count=0;
       for(int i=0;i<nums.length;i++){
        if(nums[i]%2!=0){
            oddsum+=1;
        }
        if(map.containsKey(oddsum-k)){
            count+=map.get(oddsum-k);
        }
        map.put(oddsum,map.getOrDefault(oddsum,0)+1);
       } 
       return count;
    }
}