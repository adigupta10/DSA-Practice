class MinStack {
    Stack<int[]> st=new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            st.push(new int[]{value,value});
        }
        else{
            int[] curr=st.peek();
           st.push(new int[]{value,Math.min(value,curr[1])});
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        int[] curr=st.peek();
        return curr[0];
    }
    
    public int getMin() {
        int[] curr=st.peek();
        return curr[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */