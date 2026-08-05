import java.math.BigInteger;
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
      PriorityQueue<BigInteger> pq=new PriorityQueue<>();
      for(int i=0;i<nums.length;i++){
            BigInteger n=new BigInteger(nums[i]);
            pq.offer(n);
            while(pq.size()>k){
                pq.poll();
            }
      }  
      return String.valueOf(pq.poll());
    }
}