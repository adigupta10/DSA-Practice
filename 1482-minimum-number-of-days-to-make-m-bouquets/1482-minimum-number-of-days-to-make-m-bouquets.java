class Solution {
    public static boolean canbloom(int day,int m,int k,int[] bloom){
        int bouquet=0;
        int consecutive_count=0;
        for(int i=0;i<bloom.length;i++){
            if(bloom[i]<=day){
                consecutive_count++;
            }
            else{
                consecutive_count=0;
            }
            if(consecutive_count==k){
                bouquet++;
                consecutive_count=0;
            }
        }
        if(bouquet>=m) return true;
        return false;
    }
    public int minDays(int[] bloom, int m, int k) {
        int l=1;
        int h=-1;
        int ans=-1;
        //edge case 
        if(m*k >bloom.length) return -1;
        for(int i:bloom) h=Math.max(h,i);
        while(l<=h){
            int mid=l+(h-l)/2;
            if(canbloom(mid,m,k,bloom)){
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