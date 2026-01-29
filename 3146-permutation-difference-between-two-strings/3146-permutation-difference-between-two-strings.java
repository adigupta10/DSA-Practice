class Solution {
    public int findPermutationDifference(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        int len1=s.length();
        int len2=t.length();
        for(int i=0;i<len1;i++){
            char ch=s.charAt(i);
            map.put(ch,i);
        }
        int sum=0;
        for(int k=0;k<len2;k++){
            char c=t.charAt(k);
            if(map.containsKey(c)){
                sum+=Math.abs(k-map.get(c));
                if(map.get(c)==0) map.remove(c);
            }
        }
        return sum;
    }
}