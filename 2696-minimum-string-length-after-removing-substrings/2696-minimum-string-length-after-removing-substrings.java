class Solution {
    public int minLength(String s) {
        StringBuilder res=new StringBuilder(s);
        int i=0;
        while(i<res.length()-1){
            String p=res.substring(i,i+2);
            if(p.equals("AB") || p.equals("CD") ) {
                res.delete(i,i+2);
                if(i>0) i--;
            }
            else{
                i++;
            }
        }
        return res.length();
    }
}