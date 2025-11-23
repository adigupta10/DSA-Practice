class Solution {
    private int getMax(HashMap<Character,Integer> map){
        int value=0;
        for(int f:map.values()){
            value=Math.max(value,f);
        }
        return value;
    }
    public int characterReplacement(String s, int k) {
        int l=0; int ans=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            int maxfreq=getMax(map);
            int windowsize=r-l+1;
            if(windowsize-maxfreq<=k){
                ans=Math.max(ans,windowsize);
            }
            else{
                //shrinking the window;
                char leftchar=s.charAt(l);
                map.put(leftchar,map.get(leftchar)-1);
                if(map.get(leftchar)==0){
                    map.remove(leftchar);
                }
                l++;
            }
        }
        return ans;
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