class Solution {
    public boolean rotateString(String s, String goal) {
        String x=s+s;
        return s.length()==goal.length() && x.contains(goal);
    }
}