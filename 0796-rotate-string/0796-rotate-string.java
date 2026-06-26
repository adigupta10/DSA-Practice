class Solution {
    public boolean rotateString(String s, String goal) {
        String x=s+s;
        int i=0; int j=0;
        while(i<x.length()){
            if(x.charAt(i)==goal.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
            if(j==goal.length()) return true;
        }
        return false;
    }
}