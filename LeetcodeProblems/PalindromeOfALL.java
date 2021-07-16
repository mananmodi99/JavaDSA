package LeetcodeProblems;

public class PalindromeOfALL {
    public boolean isPalindrome(ListNode head) {
        ListNode slow_p = head;
        ListNode fast_p = head;
        ListNode midNode = null;
        while(fast_p.next!=null && fast_p.next.next!=null){
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
        }
        midNode = slow_p;
        ListNode prev = null;
        ListNode curr = midNode.next;
        ListNode ahead = null;
        while(curr!=null){
            ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        midNode.next = prev;
        ListNode ll2 = prev;
        while(ll2!=null){
            if(head.val!=ll2.val) return false;
            head = head.next;
            ll2 = ll2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeOfALL pd = new PalindromeOfALL();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(pd.isPalindrome(head));
    }
}
