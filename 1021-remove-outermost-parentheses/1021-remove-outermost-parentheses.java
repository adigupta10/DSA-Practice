class Solution {
    public String removeOuterParentheses(String s) {
        List<String> list = new ArrayList<>();
        int balance = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                balance++;
            else
                balance--;
            if (balance == 0) {
                list.add(s.substring(start, i + 1));
                start = i + 1;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String str : list) {
            ans.append(str.substring(1, str.length() - 1));
        }
        return ans.toString();
    }
}