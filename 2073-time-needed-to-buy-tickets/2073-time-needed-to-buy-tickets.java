class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q=new LinkedList<>();
        int n=tickets.length;
        for(int i=0;i<n;i++){
            q.offer(i);
        }
        int count=0;
        while(!q.isEmpty()){
            count++;
            int curr=q.poll();
            tickets[curr]--;
            if(curr==k  && tickets[curr]==0){
                return count;
            }
            if(tickets[curr]!=0){
                q.offer(curr);
            }
        }
        return count;
    }
}