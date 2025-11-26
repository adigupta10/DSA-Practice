class Solution {
    public void rev(char[] s,int i,int j){
        if(i>=j) return;
        char temp=s[i];
        s[i]=s[j];
        s[j]=temp;
        rev(s,i+1,j-1);
    }
    public void reverseString(char[] s) {
        rev(s,0,s.length-1);
    }
}