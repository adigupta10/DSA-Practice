class Solution {
    public int minCost(String s, int[] nt) {
        if(s.length()==1) return 0;
        int prev=nt[0];
        int cost=0;
        for(int i=1;i<s.length();i++){
            int curr=nt[i];
            if(s.charAt(i)==s.charAt(i-1)){
                cost+=Math.min(prev,curr);
                prev=Math.max(prev,curr);
            }
            else{
                prev=nt[i];
            }
        }
        return cost;
    }
}