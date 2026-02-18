class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb=new StringBuilder();
        int i=num1.length()-1;
        int j=num2.length()-1;
        int carry=0;
        while(i>=0 || j>=0){
            int sum=0;
            int curr1=0;
            int curr2=0;
            if(i>=0){
                curr1=num1.charAt(i)-'0';
                i--;
            }
            if(j>=0){
                curr2=num2.charAt(j)-'0';
                j--;
            }
            sum+=curr1+curr2;
            sum+=carry;
            sb.append(sum%10);
            carry=sum/10;
        }
        if(carry>0) sb.append(carry);
        return sb.reverse().toString();
    }
}