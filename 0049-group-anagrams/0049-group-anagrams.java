class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] visit=new boolean[strs.length];
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            if(visit[i]) continue;
            List<String> temp=new ArrayList<>();
            temp.add(strs[i]);
            for(int j=i+1;j<strs.length;j++){
            String a=strs[i];
            String b=strs[j];
            char[] x=a.toCharArray();
            char[] y=b.toCharArray();
            Arrays.sort(x);
            Arrays.sort(y);
            String s1=new String(x);
            String s2=new String(y);
                if(s1.equals(s2)){
                    temp.add(b);
                    visit[j]=true;
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}