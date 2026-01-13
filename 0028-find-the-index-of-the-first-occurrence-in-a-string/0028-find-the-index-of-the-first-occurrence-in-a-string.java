class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int k=needle.length();
        int i=0;
        
        if (k == 0) return 0;
        if (k > n) return -1;
        
       for(int j=0;j<n;j++){
            if(j-i+1>k){
                i++;
            }
            if(j-i+1==k){
                if(haystack.substring(i,j+1).equals(needle)){
                    return i;
                }
             }
        }
       return -1; 
    }
}