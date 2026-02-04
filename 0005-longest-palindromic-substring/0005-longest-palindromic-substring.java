class Solution {
    String ans="";
    boolean solve(int i, int j, String s){
        int l=i;
        int r=j;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        int len=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(solve(i,j,s)){
                    if(j-i+1>len){
                        len=j-i+1;
                        ans=s.substring(i,j+1);
                    }
                }
            }
        }
        return ans;
    }
}