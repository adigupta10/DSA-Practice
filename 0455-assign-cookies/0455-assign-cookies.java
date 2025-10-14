class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int j=0;
        int i=0;
        int count=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i<g.length && j<s.length){
            if(s[j]>=g[i]){
                count++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return count;
    }
}