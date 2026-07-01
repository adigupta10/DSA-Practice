class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int left=0;
        int right=0;
        int maxi=0;
        int maxfreq=0;
        while(right<s.length()){
            char ch=s.charAt(right);
            freq[ch-'A']++;

            maxfreq=Math.max(maxfreq,freq[ch-'A']);

            while(right-left+1 - maxfreq > k){
                freq[s.charAt(left)-'A']--;
                left++;
                for(int i=0;i<26;i++){
                    maxfreq=Math.max(maxfreq,freq[i]);
                }
            }
            maxi=Math.max(maxi,right-left+1);
            right++;
        }
        return maxi;
    }
}