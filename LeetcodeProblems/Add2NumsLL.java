package LeetcodeProblems;

public class Add2NumsLL {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode temp, dummy = new ListNode(0);
        temp = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(carry%10);
            carry /= 10;
            temp = temp.next;
        }
        return dummy.next;
    }
}
