class Solution {
    private boolean matches(int[] freq1,int[] freq2){
        for(int l=0;l<26;l++){
            if(freq1[l]!=freq2[l]) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length(); int k=s2.length();
        int[] freq1=new int[26];
        for(int i=0;i<n;i++){
            freq1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<k-n+1;i++){
            int[] freq2=new int[26];
            for(int j=i;j<n+i;j++){
                freq2[s2.charAt(j)-'a']++;
            }
            if(matches(freq1,freq2)){
                return true;
            }
        }
        return false;
    }
}