class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> arr=new ArrayList<>();
        int n=s.length(); int k=p.length();
        if(k>n) return arr;
        int[] freqP=new int[26];
        for(int i=0;i<k;i++){
            freqP[p.charAt(i)-'a']++;
        }
        //working for 1st k length window
        int[] freqS=new int[26];
        for(int i=0;i<k;i++){
            freqS[s.charAt(i)-'a']++;
        }
        if(matches(freqP,freqS)) arr.add(0);

        //working for the entire window


        for(int i=k;i<n;i++){
            freqS[s.charAt(i)-'a']++;
            freqS[s.charAt(i-k)-'a']--;
            if(matches(freqP,freqS)) arr.add(i-k+1);
        }
        return arr;

    }
    public boolean matches(int[] x,int[] y){
        for(int i=0;i<26;i++){
            if(x[i]!=y[i]){
                return false;
            }
        }
        return true;
    }
}

// int n=s.length(); int k=p.length();
//         int WindowSize=n-k+1;
//         List<Integer> arr=new ArrayList<>();
//         for(int i=0;i<=n-k;i++){
//             HashMap<Character,Integer> map=new HashMap<>();
//             for(char j : p.toCharArray()){
//                 map.put(j,map.getOrDefault(j,0)+1);
//             }
//             int c=k;
//             for(int j=i;j<i+k;j++){
//                 char curr=s.charAt(j);
//                 if(map.containsKey(curr)){
//                     map.put(curr,map.get(curr)-1);
//                     if(map.get(curr)==0){
//                         map.remove(curr);
//                     }
//                 }
//                 if(map.size()==0) arr.add(i);
//             }
//         }
//         return arr;