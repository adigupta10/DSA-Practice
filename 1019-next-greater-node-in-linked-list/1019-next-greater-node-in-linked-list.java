/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> l=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            l.add(curr.val);
            curr=curr.next;
        }
        int[] arr=new int[l.size()];
        Stack<Integer> st=new Stack<>();
        for(int i=l.size()-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=l.get(i)){
                st.pop();
            }
            arr[i]=st.isEmpty() ? 0 : st.peek();
            st.push(l.get(i));
        }
        return arr;
    }
}