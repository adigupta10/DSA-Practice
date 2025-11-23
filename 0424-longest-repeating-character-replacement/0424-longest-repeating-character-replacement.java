class Solution {
    public int characterReplacement(String s, int k) {
        int left=0; int max=0; int res=0;
        int[] freq=new int[26];
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            freq[ch-'A']++;
            max=Math.max(max,freq[ch-'A']);
            if(right-left+1 - max>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }
}



// int ans=0;
// for(int i=0;i<s.length();i++){
//     int[] freq=new int[26];
//     for(int j=i;j<s.length();j++){
//         char ch=s.charAt(j);
//         freq[ch-'A']++;
//         int maxfreq=0;
//         for(int f:freq) maxfreq=Math.max(f,maxfreq);
//         int len=j-i+1;
//         if(len-maxfreq<=k){
//             ans=Math.max(len,ans);
//         }
//     }
// }
// return ans;