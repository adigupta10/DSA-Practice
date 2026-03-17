class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char ch : tasks){
            freq[ch-'A']++;
        }
        Arrays.sort(freq);
        int maxfreq=freq[25];
        int gaddhey=maxfreq-1;
        int idleslot=n*gaddhey;

        for(int i=24;i>=0;i--){
            idleslot-=Math.min(freq[i],gaddhey);
        }

        if(idleslot>0){
            return idleslot + tasks.length;
        }
        return tasks.length;   // if idleslot size is 0 , return the size of task means all char
    }
}