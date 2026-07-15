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
    public ListNode oddEvenList(ListNode head) {
        ListNode evenhead=null;
        ListNode eventail=null;
        ListNode oddhead=null;
        ListNode oddtail=null;
        ListNode curr=head;
        int p=1;
        while(curr!=null){
            if(p%2==0){
                if(evenhead==null){
                    evenhead=curr;
                    eventail=curr;
                }
                else{
                    eventail.next=curr;
                    eventail=curr;
                }
            }
            else{
                if(oddhead==null){
                    oddhead=curr;
                    oddtail=curr;
                }
                else{
                    oddtail.next=curr;
                    oddtail=curr;
                }
            }
            curr=curr.next;
            p++;
        }
        if(evenhead==null) return oddhead;
        if(oddhead==null) return oddhead;
        
        oddtail.next=evenhead;
        eventail.next=null;
        
        return oddhead;
    }
}