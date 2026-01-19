class Solution {
    public String makeGood(String s) {
       StringBuilder res=new StringBuilder(s);
        int i=0;
        while(i<res.length()-1){
            char first=res.charAt(i);
            char second=res.charAt(i+1);
            if((Character.toUpperCase(first)==second || Character.toUpperCase(second)==first) && first!=second)
            {
                    res.delete(i,i+2);
                    if(i>0) i--;
                }
            else{
                i++;
            }
        }
        return res.toString(); 
    }
}