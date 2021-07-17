package LeetcodeProblems;

import java.util.HashMap;

class Node{
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CloneALinkedList {
    public Node Best(Node head) {
        Node iter = head;
        Node front = head;

        //Step 1
        while (iter != null) {
            front = iter.next;

            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;

            iter = front;
        }

        // Step 2
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Step 3
        iter = head;
        Node pseudoHead = new Node(0);
        Node copy = pseudoHead;

        while (iter != null) {
            front = iter.next.next;


            copy.next = iter.next;
            copy = copy.next;


            iter.next = front;

            iter = front;
        }

        return pseudoHead.next;
    }
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> h = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            Node nn = new Node(temp.val);
            h.put(temp, nn);
            temp = temp.next;
        }
        Node temp2 = head;
        while(temp2!=null){
            Node nn = h.get(temp2);
            nn.random = h.get(temp2.random);
            nn.next = h.get(temp2.next);
            temp2 = temp2.next;
        }
        return h.get(head);
    }

    public static void main(String[] args) {
        CloneALinkedList ll = new CloneALinkedList();
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head;
        ll.copyRandomList(head);
    }
}
