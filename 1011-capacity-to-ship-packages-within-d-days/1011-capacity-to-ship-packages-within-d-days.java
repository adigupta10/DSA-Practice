class Solution {
    public static boolean solve(int cap,int[] w,int d){
        int days=1;
        int total=cap;
        for(int i=0;i<w.length;i++){
            if(cap>=w[i]){
            cap-=w[i];
            }
            else{
                days++;
                cap=total;
                cap-=w[i];
            }
        }
        return days<=d;
    }
    public int shipWithinDays(int[] w, int d) {
        int l=0;
        int h=0;
        int ans=-1;
        for(int x:w){
            l=Math.max(l,x);
            h+=x;
        }
        while(l<=h){
            int mid=l+(h-l)/2;
            if(solve(mid,w,d)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}