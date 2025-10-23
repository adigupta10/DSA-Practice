class Solution {
    public int firstUniqChar(String s) {
        //creating a frequency array
        int[] freq=new int[26];
        for(int i : s.toCharArray()){
            freq[i-'a']++;
        }
        for(int j=0;j<s.length();j++){
            if(freq[s.charAt(j)-'a']==1){
                return j;
            }
        }
        return -1;
    }
}