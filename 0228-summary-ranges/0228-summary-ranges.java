class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> l=new ArrayList<>();
        if(nums.length==0) return l;
        int start=0;
        for(int i=1;i<nums.length;i++){
            if((nums[i]-1)!=nums[i-1]){
                if(i-1==start){
                    l.add(String.valueOf(nums[i-1]));
                }
                else{
                    l.add(String.valueOf(nums[start])+"->"+String.valueOf(nums[i-1]));
                }   
                start=i;
            }
        }
        if(start==nums.length-1){
            l.add(String.valueOf(nums[start]));
        }
        else{
            l.add(String.valueOf(nums[start]+"->"+nums[nums.length-1]));
        }
        return l;
    }
}