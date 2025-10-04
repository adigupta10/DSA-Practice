class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int sum=0;
        boolean oddfound=false;
        for(int j: map.values()){
            if(j%2==0){
                sum+=j;
            }
            else{
                sum+=j-1;
                oddfound=true;
            }
        }
        if(oddfound){
            sum+=1;
        }
        return sum;
    }
}