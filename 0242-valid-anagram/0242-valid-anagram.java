class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> ch=new HashMap<>();
        int n=s.length();
        for(char i: s.toCharArray()){
            ch.put(i, ch.getOrDefault(i,0)+1);
        }
        for(char i: t.toCharArray()){
            if(!ch.containsKey(i)){
                return false;
            }
            ch.put(i,ch.get(i)-1);
            if(ch.get(i)==0){
                ch.remove(i);
            }
        }
        return true;
    }
}