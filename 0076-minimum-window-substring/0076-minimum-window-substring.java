class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int k=0;k<t.length();k++){
            char ch=t.charAt(k);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int unique=map.size();
        int left=0; int right=0;
        int minlen=Integer.MAX_VALUE;
        int startIndex=-1;
        int n=s.length();
        while(right<n){
            char ch=s.charAt(right);
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    unique--;
                }
            }
            //shrinking window
            while(unique==0){
                int len=right-left+1;
                if(len<minlen){
                    startIndex=left;
                    minlen=len;
                }
                ch=s.charAt(left);
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)+1);
                    if(map.get(ch)>0) unique++;
                }
                left++;
            }
            right++;
        }
        if(startIndex==-1) return "";
        return s.substring(startIndex,startIndex+minlen);
    }
}

// StringBuilder ans=new StringBuilder();
//         ans.append(s+"1");
//         for(int i=0;i<s.length();i++){
//             HashMap<Character,Integer> map=new HashMap<>();
//             for(char j:t.toCharArray()){
//                 map.put(j,map.getOrDefault(j,0)+1);
//             }
//             StringBuilder temp=new StringBuilder();
//             for(int j=i;j<s.length();j++){
//                 char curr=s.charAt(j);
//                 temp.append(curr);
//                 if(map.containsKey(curr)){
//                     map.put(curr,map.get(curr)-1);
//                     if(map.get(curr)==0){
//                         map.remove(curr);
//                     }
//                 }
//                 if(map.size()==0){
//                     if(temp.length()<ans.length()){
//                         ans.setLength(0);
//                         ans.append(temp);
//                     }
//                    break;
//                 }
//             }
//         }
//         if(ans.length()==s.length()+1) return "";
//         return ans.toString();


// another answer
// class Solution {
//     public String minWindow(String s, String t) {
//         int len=Integer.MAX_VALUE;
//         int startIndex=-1;
//         for(int i=0;i<s.length();i++){
//             HashMap<Character,Integer> map=new HashMap<>();
//             int count=t.length();
//             for(int k=0;k<t.length();k++){
//                 char ch=t.charAt(k);
//                 map.put(ch,map.getOrDefault(ch,0)+1);
//             }
//             for(int j=i;j<s.length();j++){
//                 char ch=s.charAt(j);
//                 if(map.containsKey(ch)){
//                     map.put(ch,map.get(ch)-1);
//                     if(map.get(ch)==0){
//                         map.remove(ch);
//                     }
//                     count--;
//                 }
//                 if(count==0){
//                     if(j-i+1<len){
//                         len=j-i+1;
//                         startIndex=i;
//                     }
//                     break;
//                 }
//             }
//         }
//         if(startIndex==-1) return "";
//         return s.substring(startIndex,startIndex+len);
//     }
// }