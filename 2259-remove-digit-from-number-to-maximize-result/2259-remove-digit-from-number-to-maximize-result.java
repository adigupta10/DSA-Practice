class Solution {
    public String removeDigit(String number, char digit) {
        int last=0;
        int n=number.length();
        String ans="";
        for(int i=0;i<n;i++){
            char ch=number.charAt(i);
            if(ch==digit){
                if(i!=n-1 && number.charAt(i+1)>digit){
                    ans=number.substring(0,i)+number.substring(i+1);
                    return ans;
                }
                else{
                    last=i;
                }
            }
        }
        if(last==n-1) return number.substring(0,last);
        ans=number.substring(0,last)+number.substring(last+1);
        return ans;
    }
}