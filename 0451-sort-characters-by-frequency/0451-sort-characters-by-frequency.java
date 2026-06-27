class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        ArrayList<Character>[] bucket=new ArrayList[s.length()+1];
        for(char c:map.keySet()){
            int freq=map.get(c);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(c);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                for(char ch:bucket[i]){
                    int freq=map.get(ch);
                    // bucket[i] is itself the freq
                    // for(int j=0;j<i;j++)
                    while(freq-->0){
                        sb.append(ch);
                    }
                }
            }
        }
        return sb.toString();
    }
}