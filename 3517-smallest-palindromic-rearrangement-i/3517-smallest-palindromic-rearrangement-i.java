class Solution {
    public String smallestPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        char[] temp=s.substring(0,n/2).toCharArray();
        Arrays.sort(temp);
        sb.append(temp);
        if(n%2!=0) sb.append(s.charAt(n/2));
        for(int i=temp.length-1;i>=0;i--){
            sb.append(temp[i]);
        }
        return sb.toString();
    }
}