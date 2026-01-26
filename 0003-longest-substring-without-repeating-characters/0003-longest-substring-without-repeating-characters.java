class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s==null) return 0;
        if(s==" ") return 1;
        HashSet<Character> set=new HashSet<>();

        int left=0;
        int maxi=0;
        int i=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            if(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            else{
                set.add(ch);
                maxi=Math.max(maxi,i-left+1);
                i++;
            }
        }
        return maxi;
    }
}

//  int max=0;
//         for(int i=0;i<s.length();i++){
//             HashSet<Character> set=new HashSet<>();
//             for(int j=i;j<s.length();j++){
//                 char ch=s.charAt(j);
//                 if(set.contains(ch)){
//                     max=Math.max(max,j-i);
//                     break;
//                 }
//                 else{
//                     set.add(ch);
//                 }
//             }
//         }
//         return max;