class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        if(n!=m) return false;
        HashSet<Character> s1=new HashSet<>();
        HashSet<Character> s2=new HashSet<>();
        for(int i=0;i<n;i++){
            s1.add(word1.charAt(i));
            
        }
        for(int i=0;i<n;i++){
            s2.add(word2.charAt(i));
        }
        if(!s1.equals(s2)) return false;
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<n;i++){
            char c1=word1.charAt(i);
            char c2=word2.charAt(i);
            map1.put(c1,map1.getOrDefault(c1,0)+1);
            map2.put(c2,map2.getOrDefault(c2,0)+1);
        }
        //we have to match the frequency , no matters what the char is.
        List<Integer> v1 = new ArrayList<>(map1.values());
        List<Integer> v2 = new ArrayList<>(map2.values());
        Collections.sort(v1);
        Collections.sort(v2);
        for(int i=0;i<v1.size();i++){
            if(!v1.get(i).equals(v2.get(i))) return false;
        }
        return true;
    }
}