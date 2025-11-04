class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int index=0;
        for(int j=0;j<3;j++){
            int freq=map.getOrDefault(j,0);
            for(int i=0;i<freq;i++){
                nums[index++]=j;
            }
        }
    }
}