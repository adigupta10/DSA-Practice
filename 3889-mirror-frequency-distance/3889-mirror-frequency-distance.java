class Solution {
    public int mirrorFrequency(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            char mirror;
                if(Character.isDigit(ch)){
                   mirror=(char) ('9'-(ch-'0'));
                }
                else{
                   mirror=(char) ('z'-(ch-'a'));
                }

                if(map.containsKey(mirror)){
                    map.put(mirror,map.get(mirror)-1);
                    if(map.get(mirror)==0) map.remove(mirror);
                }
                else{
                    map.put(ch,map.getOrDefault(ch,0)+1);
                }
        }
        // for(int value:map.values()){
        // }
        int ans=0;
        for(char key:map.keySet()){
            int val=map.get(key);
            ans+=val;
        }
        return ans;
    }
}