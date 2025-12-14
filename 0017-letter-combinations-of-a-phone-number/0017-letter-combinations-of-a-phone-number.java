class Solution {
    private void solve(int idx,String digits,HashMap<Character,String> map,List<String> ans,StringBuilder temp){
        if(idx>=digits.length()){
            ans.add(temp.toString());
            return;
        }
        char c=digits.charAt(idx);
        String s=map.get(c);
        for(int i=0;i<s.length();i++){
            //do
            temp.append(s.charAt(i));
            //explore
            solve(idx+1,digits,map,ans,temp);
            //undo
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map=new HashMap<>();
        for(int i=0;i<digits.length();i++){
            char ch=digits.charAt(i);
            if(ch=='2'){
                map.put('2',"abc");
            }
            if(ch=='3'){
                map.put('3',"def");
            }
            if(ch=='4'){
                map.put('4',"ghi");
            }
            if(ch=='5'){
                map.put('5',"jkl");
            }
            if(ch=='6'){
                map.put('6',"mno");
            }
            if(ch=='7'){
                map.put('7',"pqrs");
            }
            if(ch=='8'){
                map.put('8',"tuv");
            }
            if(ch=='9'){
                map.put('9',"wxyz");
            }
        }
        List<String> ans=new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        solve(0,digits,map,ans,temp);
        return ans;
    }
}