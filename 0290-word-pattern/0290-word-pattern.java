class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr=s.split(" ");
        if(pattern.length()!=arr.length) return false;
        HashMap<Character,String> map=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char ss=pattern.charAt(i);
            String tt=arr[i];
            if(map.containsKey(ss)){
                if(!map.get(ss).equals(tt)) return false;
            }
            else{
                if(map.containsValue(tt)) return false;
            }
            map.put(ss,tt);

        }
        return true;
    }
}