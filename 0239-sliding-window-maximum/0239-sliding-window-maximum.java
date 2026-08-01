class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        int n=nums.length;
        int[] arr=new int[n-k+1];
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        int idx=1;
        int left=1;
        arr[0]=nums[dq.peekFirst()];

        for(int right=k;right<nums.length;right++){
            //out of bound
            while(!dq.isEmpty() && dq.peekFirst()<left){
                dq.pollFirst();
            }
            //smaller ele in dq
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[right]){
                dq.pollLast();
            }

            dq.offerLast(right);
            left++;
            arr[idx++]=nums[dq.peekFirst()];
        }
        return arr;
    }
}




// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {

//         int n = nums.length;
//         int[] ans = new int[n - k + 1];

//         // Max Heap -> {value, index}
//         PriorityQueue<int[]> pq = new PriorityQueue<>(
//                 (a, b) -> b[0] - a[0]
//         );

//         int left = 0;

//         // First window
//         for (int i = 0; i < k; i++) {
//             pq.offer(new int[]{nums[i], i});
//         }

//         ans[0] = pq.peek()[0];

//         // Slide the window
//         for (int right = k; right < n; right++) {

//             pq.offer(new int[]{nums[right], right});

//             left++;

//             // Remove all elements that are left of the window
//             while (pq.peek()[1] < left) {
//                 pq.poll();
//             }

//             ans[left] = pq.peek()[0];
//         }

//         return ans;
//     }
// }