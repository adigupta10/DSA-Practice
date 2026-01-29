class Solution {
    public int tupleSameProduct(int[] nums) {

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                map.put(nums[i]*nums[j] , map.getOrDefault(nums[i]*nums[j] , 0) +1);
            }
        }
        int count=0;
        for(int k : map.keySet()){
            if(map.get(k)>1){
                int n=map.get(k);
                count+=(n*(n-1))/2;
            }
        }
        return count*8;
    }
}