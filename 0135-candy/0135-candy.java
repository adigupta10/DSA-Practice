class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] arrleft=new int[n];
        int[] arrright=new int[n];
        Arrays.fill(arrleft,1);
        Arrays.fill(arrright,1);
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                arrleft[i]=arrleft[i-1]+1;
            }
        }
        for(int j=n-2;j>=0;j--){
            if(ratings[j]>ratings[j+1]){
                arrright[j]=arrright[j+1]+1;
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=Math.max(arrleft[i],arrright[i]);
        }
        return sum;
    }
}