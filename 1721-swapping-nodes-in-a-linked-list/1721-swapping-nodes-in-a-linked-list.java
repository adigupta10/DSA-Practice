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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr=head;
        int count=0;
        while(curr!=null){
            curr=curr.next;
            count++;
        }
        ListNode x=head;
        for(int i=1;i<k;i++){
            x=x.next;
        }
        ListNode y=head;
        for(int i=1;i<count-k+1;i++){
            y=y.next;
        }
        
        int z=x.val;
        x.val=y.val;
        y.val=z;
        return head;
    }
}