class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ss=s.charAt(i);
            char tt=t.charAt(i);
            if(map.containsKey(ss)){
                if(tt!=map.get(ss)) return false;
            }
            else{
                if(map.containsValue(tt)) return false;
            map.put(ss,tt);
            }
        }
        return true;
    }
}