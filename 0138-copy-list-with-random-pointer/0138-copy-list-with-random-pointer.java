/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
       HashMap<Node,Node> map=new HashMap<>();
       Node newhead=new Node(head.val);
       Node oldtemp=head;
       Node newtemp=newhead;
       map.put(head,newhead);
       oldtemp=oldtemp.next;
       while(oldtemp!=null){
        Node copyNode=new Node(oldtemp.val);
        map.put(oldtemp,copyNode);
        newtemp.next=copyNode;
        oldtemp=oldtemp.next;
        newtemp=newtemp.next;
       }
       oldtemp=head;
       newtemp=newhead;
       while(oldtemp!=null){
         newtemp.random=map.get(oldtemp.random);
         oldtemp=oldtemp.next;
         newtemp=newtemp.next;
       }
       return newhead;
    }
}