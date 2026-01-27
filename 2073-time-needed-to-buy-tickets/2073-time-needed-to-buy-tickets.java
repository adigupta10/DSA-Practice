class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q=new LinkedList<>();
        int time=0;
        for(int i=0;i<tickets.length;i++){
           if(i<=k){
            time+=Math.min(tickets[i],tickets[k]);
           }
           if(i>k){
            time+=Math.min(tickets[k]-1,tickets[i]);
           }
        }
        return time;
    }
}