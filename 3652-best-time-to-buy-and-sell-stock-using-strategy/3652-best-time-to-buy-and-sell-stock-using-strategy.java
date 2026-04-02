class Solution {
    public long maxProfit(int[] pr, int[] st, int k) {
        long maxi=0;
        int n=pr.length;
        long[] pf=new long[n];
        long totalorg=0;
        for(int i=0;i<n;i++){
            pf[i]=pr[i]*st[i];
            totalorg+=pf[i];
        }
        long originalsub=0;
        long modifysub=0;
        int left=0;
        int i=0;
        while(i<n){
            originalsub+=pf[i];
            if(i-left+1>k/2){
                modifysub+=pr[i];
            }
            if(i-left+1>k){
                originalsub-=pf[left];
                modifysub-=pr[left+k/2];
                left++;
            }
            if(i-left+1==k){
                maxi=Math.max(maxi,modifysub-originalsub);
            }
            i++;
        }
        return totalorg+maxi;
    }
}