class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum=0;
        int i=0;
        while(i<s.length()-1){
            char fs=s.charAt(i);
            char sc=s.charAt(i+1);
            int f1=map.get(fs);
            int f2=map.get(sc);
            if(f1<f2){
                sum+=f2-f1;
                i+=2;
            }
            else{
                sum+=f1;
                i++;
            }
        }
        if(i<s.length()){
            sum+=map.get(s.charAt(i));
        }
        return sum;
    }
}