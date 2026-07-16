/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA;
        ListNode b=headB;
        int counta=1;
        int countb=1;
        while(a!=null){
            a=a.next;
            counta++;
        }
        while(b!=null){
            b=b.next;
            countb++;
        }
        ListNode curra=headA;
        ListNode currb=headB;
        if(countb>counta){
            while(countb!=counta){
                currb=currb.next;
                countb--;
            }
        }
        else if(counta>countb){
            while(counta!=countb){
                curra=curra.next;
                counta--;
            }
        }
        while(curra!=null || currb!=null){
            if(curra==currb) return curra;
            curra=curra.next;
            currb=currb.next;
        }
        return null;
    }
}