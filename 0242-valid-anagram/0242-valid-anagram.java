class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char tt=t.charAt(i);
            map.put(tt,map.getOrDefault(tt,0)+1); // write again in diff method
        }
        for(int i=0;i<s.length();i++){
            char ss=s.charAt(i);
            if(map.containsKey(ss)){
                map.put(ss,map.get(ss)-1);
                if(map.get(ss)==0){
                    map.remove(ss);
                }
            }
            else{
                return false;
            }
        }
        return map.isEmpty() ? true : false;
    }
}