package LeetcodeProblems;

public class findIntersectionPointOfYLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == headB) return headA;
        ListNode temp1 = headA, temp2 = headB;
        int count = 0;
        while(temp1.next!=null){
            count++;
            temp1 = temp1.next;
        }
        int count1 = 0;
        while(temp2.next!=null){
            count1++;
            temp2 = temp2.next;
        }
        while(atIndex(count, headA) == atIndex(count1, headB) && count>=0 && count1>=0){
            count--;
            count1--;
        }
        return (atIndex(count+1, headA) == atIndex(count1+1, headB))?atIndex(count+1,headA):null;
    }
    public ListNode atIndex(int i, ListNode head){
        int iter = 0;
        ListNode temp = head;
        while(iter != i && temp.next!=null){
            temp = temp.next;
            iter++;
        }
        return temp;
    }

    public ListNode Best(ListNode headA, ListNode headB) {
        if(headA == headB) return headA;
        ListNode temp1 = headA, temp2 = headB;
        while(temp1 != temp2){
            if(temp1 == null && temp2 == null) return null;
            if(temp1 == null)
                temp1 = headB;
            if(temp2 == null)
                temp2 = headA;
            if(temp1 == temp2) return temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        //head.next=new ListNode(2);
        //head.next.next=new ListNode(3);
        ListNode head2 = new ListNode(2);
        //head2.next=new ListNode(3);
        head2.next = head;
        findIntersectionPointOfYLinkedList fd = new findIntersectionPointOfYLinkedList();
        //fd.getIntersectionNode(head, head2);
        fd.Best(head, head2);
    }
}
