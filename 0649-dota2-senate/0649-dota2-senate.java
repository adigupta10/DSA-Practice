class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radient=new LinkedList<>();
        Queue<Integer> dire=new LinkedList<>();
        int n=senate.length();
        for(int i=0;i<n;i++){
            if(senate.charAt(i)=='R'){
                radient.offer(i);
            }
            else{
                dire.offer(i);
            }
        }
        while(!radient.isEmpty()  && !dire.isEmpty()){
            int r=radient.poll();
            int d=dire.poll();
            if(r<d){
                radient.offer(r+n);
            }
            else{
                dire.offer(d+n);
            }
        }
        return !radient.isEmpty() ? "Radiant" : "Dire";
    }
}