class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //max heap
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(b[1]!=a[1]){
                return b[1]-a[1];
            }
            return b[0]-a[0];
        });
       for(int h:arr){
        int diff=Math.abs(h-x);
        pq.add(new int[]{h,diff});
        if(pq.size()>k){
            pq.poll();
        }
       }
       List<Integer> l=new ArrayList<>();
       while(!pq.isEmpty()){
            int[] curr= pq.poll();
            l.add(curr[0]);
       }
       Collections.sort(l);
       return l;
    }
}