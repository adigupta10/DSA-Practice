class Solution {
    public long calculateScore(String s) {
        HashMap<Character,Stack<Integer>> map=new HashMap<>();
        long score=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            char mirror=(char) ('z'-(ch-'a'));
            if(map.containsKey(mirror) && !map.get(mirror).isEmpty()){
                long temp=i-map.get(mirror).pop();
                score+=temp;
            }
            else{
                if(map.containsKey(ch)){
                    map.get(ch).push(i);
                }
                else{
                    map.put(ch,new Stack<>());
                    map.get(ch).push(i);
                }
            }
        }
        return score;
    }
}

// int n=s.length();
//         boolean[] vis=new boolean[n];
//         long count=0;
//         for(int i=0;i<n;i++){
//             if(vis[i]) continue;
//             char curr=s.charAt(i);
//             char mirror =(char) ('z'-(curr-'a'));
//             for(int j=i+1;j<n;j++){
//                 if(!vis[j] && s.charAt(j)==mirror){
//                     vis[i]=true;
//                     vis[j]=true;
//                     count+=j-i;
//                     break;
//                 }   
//             }
//         }
//         return count;