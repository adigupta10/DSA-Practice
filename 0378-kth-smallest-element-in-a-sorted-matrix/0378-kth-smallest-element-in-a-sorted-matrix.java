class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // max heap
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int[] x:matrix){
            for(int j:x){
                pq.add(j);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}