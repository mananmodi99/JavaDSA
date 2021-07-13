package LeetcodeProblems;

public class MiddleOfLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode middleNode(ListNode head) {
        if(head.next == null) return head;
        ListNode temp = head;
        int count = 0;
        while(temp.next!=null){
            temp = temp.next;
            count++;
        }
        //System.out.println(count);
        int mid = (count%2==0)?(count/2):count/2+1;
        temp = head;
        while(mid!=0){
            temp = temp.next;
            mid--;
        }
        return temp;
    }
    public ListNode BestmiddleNode(ListNode head) {//Single Traversal
        if(head.next == null) return head;
        ListNode fast_p = head;
        ListNode slow_p = head;
        while(fast_p.next != null && fast_p.next.next!=null){
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
        }
        return (fast_p.next == null)?slow_p:slow_p.next;
    }

}
