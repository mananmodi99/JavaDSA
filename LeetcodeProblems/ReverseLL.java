package LeetcodeProblems;

public class ReverseLL {
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
        public ListNode getNodeAt(ListNode head, int idx) {
            ListNode temp = head;
            while(idx!=0){
                temp = temp.next;
                idx--;
            }
            return temp;
        }
        public ListNode reverseList(ListNode head) {
            if(head == null) return head;
            ListNode tail = head;
            int lastIdx = 0;
            while(tail.next != null){
                tail = tail.next;
                lastIdx++;
            }
            int lo = 0, hi = lastIdx;
            while(lo<hi){
                ListNode left = getNodeAt(head, lo);
                ListNode right = getNodeAt(head, hi);
                int val = left.val;
                left.val = right.val;
                right.val = val;
                lo++;
                hi--;
            }
            return head;
        }
        public ListNode PointerApproachreverseList(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode prev = head;
            ListNode curr = head.next;
            while(curr.next != null){
                ListNode ahead = curr.next;
                curr.next = prev;
                prev = curr;
                curr = ahead;

            }
            curr.next = prev;
            head.next = null;
            head = curr;

            return head;
        }
}
