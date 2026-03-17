class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(intervals[0][1]);
        boolean flag=true;
        for(int[] x:intervals){
            if(flag){
                flag=false;
                continue;
            }
            int firstIndex=x[0];
            if(firstIndex>pq.peek()){
                pq.poll();
            }
            pq.add(x[1]);
        }
        return pq.size();
    }
}