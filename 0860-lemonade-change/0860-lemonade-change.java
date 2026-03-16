class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fivecount=0;
        int tencount=0;
        if(bills[0]!=5) return false;
        for(int x:bills){
            if(x==5){
                fivecount++;
                continue;
            }
            else if(x==10){
                if(fivecount==0) return false;
                else{
                    fivecount--;
                    tencount++;
                }
            }
            else if(x==20){
                if(fivecount>=1 && tencount>=1){
                    fivecount--;
                    tencount--;
                }
                else if(fivecount>=3){
                    fivecount-=3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}