class Solution {
    public int longestSubstring(String s, int k) {
        int maxi=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            HashMap<Character,Integer> map=new HashMap<>();
            for(int j=i;j<n;j++){
                boolean flag=true;
                char ch=s.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)+1);                
                for(char key :map.keySet()){
                    if(map.get(key)<k){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    maxi=Math.max(maxi,j-i+1);
                }

            }
        }
        return maxi;
    }
}