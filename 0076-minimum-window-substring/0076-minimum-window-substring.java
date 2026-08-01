class Solution {
    public String minWindow(String s, String t) {
        int[] freq1=new int[256];
        int[] freq2=new int[256];

        for(char ch:t.toCharArray()){
            freq2[ch]++;
        }
        int start=0;
        int left=0;
        int minlen=Integer.MAX_VALUE;
        for(int right=0;right<s.length();right++){
            freq1[s.charAt(right)]++;
            while(check(freq1,freq2)){
                if(right-left+1<minlen){
                    minlen=right-left+1;
                    start=left;
                }
                freq1[s.charAt(left)]--;
                left++;
            }
        }
        return minlen==Integer.MAX_VALUE ? "" : s.substring(start,start+minlen);  
    }
    public static boolean check(int[] freq1,int[] freq2){
        for(int i=0;i<256;i++){
            if(freq1[i]<freq2[i]){
                return false;
            }
        }
        return true;
    }
}