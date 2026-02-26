class Solution {
    public int numSteps(String s) {
        int n=Integer.parseInt(s,2);
        int c=0;
        while(n!=1){
            if(n%2!=0){
                n+=1;
            }
            else{
                n/=2;
            }
            c++;
        }
        return c;
    }
}