class Solution {
    public int minimumPushes(String word) {
        int[] freq=new int[26];
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            freq[ch-'a']++;
        }
        Arrays.sort(freq); // it is asc to desc , we want in desc , so reverse the array
        int i=0; int j=freq.length-1;
        while(i<=j){
            int temp=freq[i];
            freq[i]=freq[j];
            freq[j]=temp;
            i++;
            j--;
        }
        int sum=0;
        int press=1;
        for(int k=0;k<26;k++){
            press=k/8+1;
            sum+=(press*freq[k]);
        }
        return sum;
    }
}