class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        ArrayList<Character> list=new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b)-> map.get(b)-map.get(a));
        StringBuilder sb=new StringBuilder();
        for(char c:list){
            int freq=map.get(c);
            while(freq-->0){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}