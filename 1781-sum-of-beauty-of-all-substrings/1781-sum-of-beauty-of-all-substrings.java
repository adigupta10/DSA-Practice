class Solution {
    public int beautySum(String s) {
        int total=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                String x=s.substring(i,j+1);
                int[] freq=new int[26];
                int maxi=-1; int mini=Integer.MAX_VALUE;
                for(char ch:x.toCharArray()){
                    freq[ch-'a']++;
                }
                for(int k=0;k<26;k++){
                    if(freq[k]>0){
                        maxi=Math.max(maxi,freq[k]);
                        mini=Math.min(mini,freq[k]);
                    }
                }
                // if(maxi==0 || mini==0 || maxi==-1 || mini==Integer.MAX_VALUE) total+=0; else
                total+=maxi-mini;
            }
        }
        return total;
    }
}