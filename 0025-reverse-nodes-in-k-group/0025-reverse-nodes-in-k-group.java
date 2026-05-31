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
    public ListNode reverseKGroup(ListNode head, int k) {
        int cnt=0;
        ListNode temp=head;
        while(temp!=null && cnt<k){
            temp=temp.next;
            cnt++;
        }
        if(cnt<k){
            return head;
        }

        //reverse the LL
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=null;
        cnt=0;
        while(curr!=null && cnt<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            cnt++;
        }
        if(next!=null){  //agge ke liye check karna ki nodes left hai ya nahi
            head.next=reverseKGroup(next,k);
        }
        return prev;
    }
}