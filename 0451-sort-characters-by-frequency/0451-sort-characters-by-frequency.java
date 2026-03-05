class Solution {
    public String frequencySort(String s) {
        TreeMap<Character,Integer> map=new TreeMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        ArrayList<int[]> l=new ArrayList<>();
        for(char key : map.keySet()){
           l.add(new int[]{map.get(key),key});
        }
        Collections.sort(l,(a,b)->b[0]-a[0]);
        StringBuilder sb=new StringBuilder();
        for(int[] x : l){
            int c=x[0];
            char v=(char) x[1];
            while(c-->0){
                sb.append(v);
            }
        }
        return sb.toString();
    }
}