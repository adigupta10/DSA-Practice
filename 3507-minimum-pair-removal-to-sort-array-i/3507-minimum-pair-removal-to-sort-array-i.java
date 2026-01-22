class Solution {
    private boolean nondec(ArrayList<Integer> l){
        for(int i=0;i<l.size()-1;i++){
            if(l.get(i)>l.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public int minimumPairRemoval(int[] nums) {
        int count=0;
        int n=nums.length;
        ArrayList<Integer> l=new ArrayList<>();
        for(int i:nums){
            l.add(i);
        }
        while(nondec(l)==false){
            int sum=Integer.MAX_VALUE;
            int currIndex=0;
            for(int i=0;i<l.size()-1;i++){
                if(l.get(i)+l.get(i+1)<sum){
                    sum=l.get(i)+l.get(i+1);
                    currIndex=i;
                }
            }
            l.set(currIndex,sum);
            l.remove(currIndex+1);
            count++;
        }
        return count;
    }
}