class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        //calculate for first window
        HashMap<Integer,Integer> map=new HashMap<>();
        long sum=0;
        long maxi=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        if(map.size()==k) maxi=sum;

        int left=0;
        int right=k;
        while(right<arr.length){
            sum+=arr[right];
            map.put(arr[right],map.getOrDefault(arr[right],0)+1);

            sum-=arr[left];
            map.put(arr[left],map.get(arr[left])-1);
            if(map.get(arr[left])==0) map.remove(arr[left]);
            left++;

            if(map.size()==k) maxi=Math.max(maxi,sum);
            right++;
        }
        return maxi;
    }
}