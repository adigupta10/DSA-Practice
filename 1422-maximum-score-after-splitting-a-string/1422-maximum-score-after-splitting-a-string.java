class Solution {
    public int maxScore(String s) {
      int[] pl=new int[s.length()];  
      int[] pr=new int[s.length()]; 
      int idx=1; 
      for(int i=0;i<pl.length;i++){
        if(s.charAt(i)=='0'){
            pl[i]=idx;
            idx++;
        }
      }
      idx=1;
      for(int j=s.length()-1;j>=0;j--){
        if(s.charAt(j)=='1'){
            pr[j]=idx;
            idx++;
        }
      }
      int maxi=0;
      for(int i=0;i<s.length()-1;i++){
         maxi=Math.max(maxi,pl[i]+pr[i+1]);
      }
      return maxi;
    }
}