class Solution {
    public int smallestNumber(int n, int t) {
        int ans=-1;
        while(true){
            int curr=n;
            int p=1;
            while(curr!=0){
                int rem=curr%10;
                p*=rem;
                curr/=10;
            }
            if(p%t==0){
                ans=n;
                break;
            }
            else{
                n++;
            }  
        }
        return ans;
    }
}