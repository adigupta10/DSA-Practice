class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int count=0;
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int i=0;
        while(i<n){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()==3){
                count+=n-i;
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0) map.remove(s.charAt(left));
                left++;
            }
            i++;
        }
        return count;
    }
}