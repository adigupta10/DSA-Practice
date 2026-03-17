class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)->Integer.compare(a[1],b[1]));
        int remainingSeats=capacity;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);  // ending and capacity
        pq.offer(new int[]{trips[0][2],trips[0][0]});
        if(remainingSeats<trips[0][0]) return false;
        remainingSeats-=trips[0][0];
        boolean flag=true;
        for(int[] x:trips){
            int currP=x[0];
            int st=x[1];
            int end=x[2];

            if(flag){
                flag=false;
                continue;
            }
            while(!pq.isEmpty() && st>=pq.peek()[0]){
                remainingSeats+=pq.peek()[1];
                pq.poll();
            }

            if(remainingSeats<currP) return false;

            remainingSeats-=currP;

            pq.offer(new int[]{end,currP});
        }
        return true;
    }
}