class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int j=0;
        int i=0;
        int count=0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        while(i<players.length && j<trainers.length){
            if(trainers[j]>=players[i]){
                count++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return count;
    }
}