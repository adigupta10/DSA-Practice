class Solution {
    public int[] fairCandySwap(int[] a, int[] b) {
        int sum1=0;
        int sum2=0;
        for(int i:a){
            sum1+=i;
        }
        for(int i:b){
            sum2+=i;
        }
        int d=(sum1-sum2)/2;

        Arrays.sort(a);
        Arrays.sort(b);
        int ans1=0; int ans2=0;
        int i=0; int j=0;
        while(i<a.length && j<b.length){
            if((a[i]-b[j])>d) j++;
            else if((a[i]-b[j])<d) i++;
            else if((a[i]-b[j])==d) {
                ans1=a[i];
                ans2=b[j];
                break;
            }
        }
        return new int[]{ans1,ans2};
    }
}