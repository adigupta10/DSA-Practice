class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums[0].length();
        StringBuilder sb=new StringBuilder();
        //generating all binary string of length n and checking into the map
        HashSet<String> map=new HashSet<>();
        for(String s : nums){
            map.add(s);
        }
        String ans=solve(map,"",n);
        return ans;
    }
    public static String solve(HashSet<String> map,String temp,int n){
        if(temp.length()==n){
            if(!map.contains(temp)){
                return temp;
            }
            return "";
        }
       
        String left=solve(map,temp+"0",n);
        if(!left.equals("")) return left;
        String right=solve(map,temp+"1",n);
        return right;
    }
}