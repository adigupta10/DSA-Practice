class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb=new StringBuilder(s);
        int i=0;
        while(i<=sb.length()-part.length()){
            char ch=sb.charAt(i);
            if(sb.substring(i,i+part.length()).equals(part)){
                sb.delete(i,i+part.length());
                if(i>0) i--;
            }
            else{
                i++;
            }
        }
        return sb.toString();
    }
}