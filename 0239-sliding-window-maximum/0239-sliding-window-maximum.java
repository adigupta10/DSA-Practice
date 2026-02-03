class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dp=new ArrayDeque<>();
        int n=nums.length;
        int[] arr=new int[n-k+1];
        //first window
        for(int i=0;i<k;i++){
            while(!dp.isEmpty() && nums[dp.peekLast()] <=nums[i]){
                dp.pollLast();
            }
            dp.offerLast(i);
        }
        int idx=0;
        for(int i=k;i<n;i++){
            arr[idx++]=nums[dp.peekFirst()];

            //out of boundary
            while(!dp.isEmpty() && dp.peekFirst()<i-k+1){
                dp.pollFirst();
            }

            //new element position by removing smaller element
            while(!dp.isEmpty() && nums[dp.peekLast()]<nums[i]){
                dp.pollLast();
            }
            dp.offerLast(i);
        }
        arr[idx]=nums[dp.pollFirst()];
        return arr;
    }
}