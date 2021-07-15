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
public class Add2Nums {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val+l2.val+carry;
            dummy = addLast(temp, sum%10);
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;

        }
        while(l1!=null){
            int sum = (l1.val + carry);
            dummy = addLast(temp, sum%10);;
            carry = sum/10;
            l1 = l1.next;
        }
        while(l2!=null){
            int sum = (l2.val + carry);
            dummy = addLast(temp, sum%10);;
            carry = sum/10;
            l2 = l2.next;
        }
        if(carry!=0){
            dummy = addLast(temp, carry);
        }
        return dummy.next;
    }
    public ListNode addLast(ListNode head, int num){
        ListNode nn = new ListNode();
        nn.val = num;
        ListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = nn;
        return head;
    }
    public static void main(String[] args) {
        Add2Nums add = new Add2Nums();
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        //1,9,9,9,9,9,9,9,9,9
        //head.next=new ListNode(4);
        //head.next.next=new ListNode(3);
        ListNode head2 = new ListNode(5);
        head2.next=new ListNode(6);
        head2.next.next=new ListNode(7);
        head2.next.next.next=new ListNode(9);
        add.addTwoNumbers(head, head2);
    }
}
