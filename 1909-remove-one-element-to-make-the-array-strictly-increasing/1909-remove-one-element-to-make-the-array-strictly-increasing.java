class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(nums[i]);
        }
        int remove=0;
        int i=1;
        while(i<l.size()){
            if(l.get(i)<=l.get(i-1)){
                remove++;
                if(remove>1) return false;
                if( i>1 && l.get(i)<=l.get(i-2)){
                    l.remove(i);
                }
                else{
                    l.remove(i-1);
                }
            }
            else{
                i++;
            }
        }
        return true;
    }
}