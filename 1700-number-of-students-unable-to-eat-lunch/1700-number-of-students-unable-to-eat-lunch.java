class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count=new int[2];
        int n=sandwiches.length;
        for(int i=0;i<students.length;i++){
            count[students[i]]++;
        }
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            st.push(sandwiches[i]);
        }
        while(!st.isEmpty()){
            if(count[st.peek()]>0){
                count[st.pop()]--;
            }
            else{
                break;
            }
        }
        return st.size();
    }
}