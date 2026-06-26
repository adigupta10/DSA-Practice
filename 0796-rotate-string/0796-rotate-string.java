class Solution {
    public boolean rotateString(String s, String goal) {
        String x=s+s;
        for(int i=0;i<=x.length()-goal.length();i++){
            int j=0;
            while(j<goal.length() && x.charAt(i+j)==goal.charAt(j)){
                j++;
            }
            if(j==goal.length()) return true;
        }
        return false;
    }
}