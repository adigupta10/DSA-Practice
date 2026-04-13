class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum=0;
        for(int x:arr) sum+=x;
        if(sum%3!=0) return false;
        int n=arr.length;

        int target=sum/3;
        int currSum=0;
        int count=0;
        for(int i=0;i<n-1;i++){
            currSum+=arr[i];
            if(target==currSum){
                currSum=0;
                count++;
                if(count==2) return true;
            }
        }
        return false;
    }
}