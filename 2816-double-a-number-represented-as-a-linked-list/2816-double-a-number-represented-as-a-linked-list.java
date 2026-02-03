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
    public ListNode doubleIt(ListNode head) {
        ArrayList<Integer> l=new ArrayList<>();
        ArrayList<Integer> res=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            l.add(curr.val);
            curr=curr.next;
        }
        int carry=0;
        for(int i=l.size()-1;i>=0;i--){
            int last=l.get(i)*2 +carry;
            res.add(last%10);
            carry=last/10;
        }
        if(carry>0) res.add(carry);
        Collections.reverse(res);

        ListNode newh=new ListNode(res.get(0));
        ListNode cur=newh;
        for(int i=1;i<res.size();i++){
            cur.next=new ListNode(res.get(i));
            cur=cur.next;
        }
        return newh;
    }
}