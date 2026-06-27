class Solution {
    public int maxDepth(String s) {
        int depth=0;
        int maxi=0;
        for(char ch:s.toCharArray()){
            if(ch=='(') depth++;
            else if(ch==')')  depth--;
            if(depth>=maxi){
                maxi=depth;
            }
           // maxi=Math.max(depth,maxi);
        }
        return maxi;
    }
}