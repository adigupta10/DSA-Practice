class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        HashMap<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for(char c :s.toCharArray()){
            if(map.containsValue(c)){
                st.push(c);
            }
            else if(map.containsKey(c)){
                if(st.isEmpty() || map.get(c)!=st.pop() ) return false;
            }
        }
        return st.isEmpty();
    }
}