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
    public int getDecimalValue(ListNode head) {
        ListNode curr=head;
        ArrayList<Integer> l=new ArrayList<>();
        while(curr!=null){
            l.add(curr.val);
            curr=curr.next;
        }
        int ans=0;
        Collections.reverse(l);
        for(int j=0;j<l.size();j++){
            int c=l.get(j);
            if(c==1){
                ans+=Math.pow(2,j);
            }
        }
        return ans;
    }
}