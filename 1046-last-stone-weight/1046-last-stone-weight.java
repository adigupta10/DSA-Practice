class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> b-a);
        for(int x:stones) pq.add(x);
        while(pq.size()>1){
            int m1=pq.poll();
            int m2=pq.poll();
            if(m1!=m2){
                pq.add(m1-m2);
            }
        }
        
        return pq.size()==1 ? pq.poll() : 0;
    }
}