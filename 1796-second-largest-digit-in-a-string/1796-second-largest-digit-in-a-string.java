class Solution {
    public int secondHighest(String s) {
        int first=-1;
        int sec=-1;
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch>='0' && ch<='9'){
                int num=ch-'0';
                if(first==-1){
                    first=num;
                }
                else if(first!=-1 && num>first){
                    sec=first;
                    first=num;
                }
                else if(num<first && num>sec){
                    sec=num;
                }
            }
        }
        return sec;
    }
}