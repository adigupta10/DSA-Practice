class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> map=new HashSet<>();
        int maxi=1;
        for(int i:nums){
            map.add(i);
        }
        for(int j:map){
            if(!map.contains(j-1)){    // starting point
                int tempmax=1;
                while(map.contains(j+1)){
                    tempmax++;
                    j++;
                }
                maxi=Math.max(maxi,tempmax);
            }

        }
        return maxi;
    }
}