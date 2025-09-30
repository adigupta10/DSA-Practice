class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char i:magazine.toCharArray()){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(char j:ransomNote.toCharArray()){
            if(map.containsKey(j)){
                map.put(j,map.get(j)-1);
                if(map.get(j)==0){
                    map.remove(j);
                }
                continue;
            }
            return false;
        }
        return true;
    }
}