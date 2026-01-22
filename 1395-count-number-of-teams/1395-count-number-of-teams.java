class Solution {
    public int numTeams(int[] rating) {
        int n=rating.length;
       int total=0;
       for(int i=1;i<n-1;i++){
            int curr=rating[i];
            int sum=0;
            int leftsmall=0;
            int leftbig=0;
            int rightsmall=0;
            int rightbig=0;
            for(int j=i+1;j<n;j++){
                if(rating[i]<rating[j]){
                    rightbig++;
                }
                else if(rating[i]>rating[j]){
                    rightsmall++;
                }
            }
            for(int k=i-1;k>=0;k--){
                if(rating[i]>rating[k]){
                    leftsmall++;
                }
                else if(rating[i]<rating[k]){
                    leftbig++;
                }
            }
            sum+=leftsmall*rightbig;
            sum+=leftbig*rightsmall;
            total+=sum;
       } 
       return total;
    }
}