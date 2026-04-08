class Solution {
   static HashMap<String,Boolean> map=new HashMap<>();
    public boolean isScramble(String s1, String s2) {
       map.clear();
        return solve(  s1,  s2);
    }
    public static boolean solve(String s1, String s2){
         int n=s1.length();

        if(s1.equals(s2)) return true;
        if(s1.length()!=s2.length()) return false;

        String key= s1 +"_" + s2 ;
       if(map.containsKey(key)) {
        return map.get(key);
       }

        boolean res=false;
        for(int i=1;i<s1.length();i++){

            boolean notswapp=(  solve(s1.substring(0,i),s2.substring(0,i))  &&
                                solve(s1.substring(i),s2.substring(i))
                            );

            if(notswapp){
                res= true;
                break;
            }


            boolean swapp=(  solve(s1.substring(0,i),s2.substring(n-i))  &&
                                solve(s1.substring(i),s2.substring(0,n-i))
                            );

            if(swapp){
                res= true;
                break;
            }
        }
        map.put(key,res);

        return res;
    }
}