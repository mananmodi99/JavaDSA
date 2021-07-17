package LeetcodeProblems;

public class RotateALinkedlist {
    public static void main(String[] args) {
        RotateALinkedlist pd = new RotateALinkedlist();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        pd.Best(head, 12);

    }
    public ListNode Best(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int size = 1;
        ListNode temp = head;
        while(temp.next!=null){
            size++;
            temp = temp.next;
        }
        k = k%size;
        temp.next = head;
        ListNode temp2 = head;
        int iter = 1, till = size - k;
        while(iter<till){
            temp2 = temp2.next;
            iter++;
        }
        head = temp2.next;
        temp2.next = null;

        return head;
    }
    public ListNode rotateRight(ListNode head, int k) {
        while(k>0){
            ListNode temp = head;
            while(temp.next.next!=null){
                temp = temp.next;
            }
            ListNode curr = temp.next;
            temp.next = null;
            curr.next = head;
            head = curr;
            k--;
        }
        return head;
    }
}
