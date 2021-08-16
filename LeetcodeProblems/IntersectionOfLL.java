package LeetcodeProblems;

public class IntersectionOfLL {
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
}
