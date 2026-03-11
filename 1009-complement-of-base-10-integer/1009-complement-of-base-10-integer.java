class Solution {
    public int bitwiseComplement(int n) {
        String s=Integer.toBinaryString(n);
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<sb.length();i++){
            char ch =sb.charAt(i);
            if(ch=='0'){
                sb.setCharAt(i,'1');
            }
            else{
             sb.setCharAt(i,'0');
            }
        }
        return Integer.parseInt(sb.toString(),2);
    }
}