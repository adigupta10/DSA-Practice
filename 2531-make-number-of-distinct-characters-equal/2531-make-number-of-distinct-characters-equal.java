class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] freq1=new int[26];
        int[] freq2=new int[26];
        for(char ch:word1.toCharArray()){
            freq1[ch-'a']++;
        }
        for(char ch:word2.toCharArray()){
            freq2[ch-'a']++;
        }
        int c1=solve(freq1);
        int c2=solve(freq2);
        if(c1==c2){
            for(int i=0;i<26;i++){
                if(freq1[i]>0 && freq2[i]>0){
                    return true;
                }
            }
        }

        for(int i=0;i<26;i++){
            if(freq1[i]==0) continue;
            for(int j=0;j<26;j++){
                if(freq2[j]==0) continue;
                if(i==j) continue;

                int newcount1=c1;
                int newcount2=c2;

                if(freq1[i]==1) newcount1--;
                if(freq1[j]==0) newcount1++;

                if(freq2[j]==1) newcount2--;
                if(freq2[i]==0) newcount2++;

                if(newcount1==newcount2){
                    return true;
                }
            }
        }
        return false;
    }
    private int solve(int[] freq){
        int c=0;
        for(int f : freq){
            if(f>0) c++;
        }
        return c;
    }
}
