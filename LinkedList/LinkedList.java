package LinkedList;

public class LinkedList{
    //Only LinkedList class should access Node Class
    private class Node{
        int data;
        Node next;
    }
    private Node head;
    private Node tail;
    private int size;
    public int size(){
        return this.size;
    }
    public void display(){
        Node temp =  this.head;
        while(temp != null){
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
        System.out.println("END. ");
    }
    public void addLast(int value) {
        //create a node [_,_]
        Node nn = new Node();
        nn.data = value;
        //Add Values to newly created node[]
        nn.next = null;

        if (this.size >= 1) {//purani list ke tail ko nn(nn node mein address save hogya hoga new Keyword ki vajah se) mein daal do [0, Null]-->[0, 10k]
            this.tail.next = nn;
        }

        //update summary vars
        if (this.size == 0) {//agar pehle se khaali hai to. Matlab You are creating a new Linked List and the newly created node is the new Node
            this.head = nn;
            this.tail = nn;
            this.size++;
        } else { // agar purani h to aane wale elems ko isme point krvao, nn yaani null ko 20k krna
            this.tail = nn;
            this.size++;
        }
    }//O(1)
    public void addFirst(int value){
            //Creation
            Node nn = new Node();
            //Updation of Node Params
            nn.data = value;

            //attachment to prev linkedlist
            if(size==0){
                nn.next = null;
            }
            else{
                nn.next = this.head;
            }

            //Summary Objects Updation
            if(this.size == 0){
                this.head = nn;
                this.tail = nn;
                this.size++;
            } else{
                this.head = nn;
                this.size++;
            }
    }//O(1)
    public int getFirst() throws Exception{
        if(size == 0)
            throw new Exception("LinkedList DNE! Assume me as a Null Pointer Exception");
        return this.head.data;

    }//O(1)
    public int getLast() throws Exception{
        if(size == 0)
            throw new Exception("LinkedList DNE! Assume me as a Null Pointer Exception");
        return this.tail.data;

    }//O(1)
    public int getAt(int index) throws Exception{
        if(index<0 || index >=this.size)
            throw new Exception("Index Out of bounds: LinkedList");
        if(this.size == 0)
            throw new Exception("Linked List DNE");

        Node temp = this.head;
        while(index!=0){
            temp = temp.next;
            index--;
        }
        return temp.data;
    }//O(n)
    private Node getNodeAt(int index) throws Exception{
        if(index<0 || index >=this.size)
            throw new Exception("Index Out of bounds: LinkedList");
        if(this.size == 0)
            throw new Exception("Linked List DNE");

        Node temp = this.head;
        while(index!=0){
            temp = temp.next;
            index--;
        }
        return temp;
    }//O(n)
    public void addAt(int index, int data) throws Exception {
        if(index == 0)
            this.addFirst(data);
        if(index == this.size)
            this.addLast(data);
        if(index<0 || index > this.size)
            throw new Exception("Invalid Index || Index Out of bounds: LinkedList");
        Node before = this.getNodeAt(index-1);
        Node after = this.getNodeAt(index);
        Node nn = new Node();
        before.next = nn;
        nn.data = data;
        nn.next = after;
        this.size++;
    }//O(n)
    public int removeFirst() throws Exception{
        if(this.size == 0)
            throw new Exception("LL to banalo pehle");
        int value = this.head.data;
        if(this.size == 1){
            this.head = null;
            this.tail = null;
        }
        this.head = this.head.next;
        this.size--;
        return value;
    }//O(1)
    public int removeLast() throws Exception{
        if(this.size == 0)
            throw new Exception("LL to banalo pehle");
        int value = this.tail.data;
        if(this.size == 1){
            this.head = null;
            this.tail = null;
        }
        this.tail = this.getNodeAt(this.size-2);
        this.tail.next = null;
        this.size--;
        return value;
    }//O(n)
    public int removeAt(int index) throws Exception{
        if(this.size == 0)
            throw new Exception("LL to banalo pehle");
        if(index<0 || index >=this.size)
            throw new Exception("Index Out of bounds: LinkedList");
        if(index == 0)
            return removeFirst();
        if(index == this.size-1)
            return removeLast();
        Node before = this.getNodeAt(index - 1);
        Node after = this.getNodeAt(index+1);
        Node current = this.getNodeAt(index);
        before.next = after;
        this.size--;
        return current.data;
    }//O(n)
    public void ReverseLLDataApproach() throws Exception {
        int left = 0;
        int right = this.size - 1;
        while(left < right) {
            Node leftNode = getNodeAt(left);
            Node rightNode = getNodeAt(right);
            int temp = leftNode.data;
            leftNode.data = rightNode.data;
            rightNode.data = temp;
            left++;
            right--;
        }
    }
    public void ReverseLLPointerApproach() throws Exception {
        Node prev = this.head;
        Node curr = prev.next;
        while (curr != null){
            Node ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        this.tail.next = null;
    }
    public Node ReverseRecursive(Node head) throws Exception {
        //base
        if(head == null || head.next == null)
            return head;
        //recursive
        Node new_head = ReverseRecursive(head.next);
        Node new_tail = head.next;
        new_tail.next = head;
        head.next = null;
        return new_head;
    }
    public int MidNode() throws Exception {
        Node temp1x = this.head;
        Node temp2x = this.head;
        while(temp2x.next != null && temp2x.next.next != null){
            temp1x = temp1x.next;
            temp2x = temp2x.next.next;
        }
        return temp1x.data;
    }
    public void RecursiveTraversalofLL(Node head){
        if(this.size-1 == 0){
            System.out.print(head.data);
            return;
        }
        System.out.print(head.data+", ");
        this.size--;
        RecursiveTraversalofLL(head.next);

    }
    public void RemoveDuplicates() throws Exception {
        // int index = 1;
        // while(index != this.size){
        //     Node prev = this.getNodeAt(index-1);
        //     Node curr = this.getNodeAt(index);
        //     Node ahead = this.getNodeAt(index+1);
        //     if(prev.data == curr.data){
        //         this.removeAt(index);
        //     }
        //     index++;
        // }
        Node curr = this.head;
        while(curr != null && curr.next != null){
            if(curr.data == curr.next.data){
                curr.next = curr.next.next;
                this.size--;
            }
            else{
                curr = curr.next;
            }
        }
    }
    public void InsertInASortedLL(int data) throws Exception{
        int index = 0;
        while(this.getNodeAt(index).data < data)
            index++;
        this.addAt(index, data);
        this.size++;
    }
    public boolean DetectLoop(){
        Node nn = this.head;
        int k = this.size-1;
        while(k!=0){
            nn = nn.next;
            k--;
        }
        if(nn.next != null){
            return true;
        }
        return false;

    }
    public boolean DetectLoopApproach2(){
        Node curr = this.head;
        Node temp = new Node();
        while(curr!=null){
            if(curr.next == null)
                return false;
            if(curr.next == temp)
                return true;
            Node temp2 = curr.next;
            curr.next = temp;
            curr = temp2; 
        }
        return false;
    }
    public boolean FloysCycleDetection(){
        Node slow_p = this.head;
        Node fast_p = this.head;
        while (fast_p.next!=null && fast_p.next.next != null) { 
            slow_p = slow_p.next; 
            fast_p = fast_p.next.next; 
            if (slow_p == fast_p) { 
                return true; 
            } 
        } 
        return false;
    }
    public void DetectionAndRemoval(){
        Node slow = this.head;
        Node fast = this.head;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        if(slow != fast){
            return;
        }
        slow = this.head;
        while(slow.next != fast.next){
        slow = slow.next;
        fast = fast.next;
        }
        fast.next = null;
    }
    public void EvenOddSeperation(LinkedList ll1){
        LinkedList ll = new LinkedList();
        Node curr = ll1.head;
        while(curr!=null){
            if(curr.data%2 == 0)
                ll.addLast(curr.data);
            curr = curr.next;
        }
        curr = ll1.head;
        while(curr!=null){
            if(curr.data%2 != 0)
                ll.addLast(curr.data);
            curr = curr.next;
        }
        ll.display();
    }
    public void NthNodeFromTheEnd(int n) throws Exception{
        if(n > this.size){
            throw new Exception("LinkedList is smallu");
        }
        Node temp1 = this.getNodeAt(n);
        Node temp2 = this.head;
        while(temp1 != null){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        System.out.println(temp2.data);
    }
    public void PairWiseSwappingData(){
        Node curr = this.head;
        while(curr!=null && curr.next!=null){
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;
            curr = curr.next.next;
        }
    } 
    public void PairWiseSwappingPointer(){
        Node prev = this.head;
        Node curr = this.head.next;
        
        while(curr !=null && curr.next!=null){
            
        }
    }
    public static void main(String[] args) throws Exception{
        LinkedList ll = new LinkedList();
        ll.addFirst(10);
        ll.addLast(20);
        ll.addFirst(100);
        ll.addLast(30);
        ll.addFirst(50);
        ll.display();
        System.out.println();
        //ll.removeLast();
        //ll.removeAt(2);
        ll.display();
        System.out.println();
        ll.ReverseLLDataApproach();
        ll.display();
        ll.ReverseLLPointerApproach();
        ll.display();
        ll.removeLast();
        ll.display();
        //System.out.println(ll.MidNode());
        //System.out.println();
        //System.out.println();
        System.out.println();
        //ll.RecursiveTraversalofLL(ll.head);
        ll.addFirst(50);
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(20);
        ll.addLast(30);
        ll.addAt(2, 100);
        ll.display();
        System.out.println();
        ll.RemoveDuplicates();
        ll.display();
        LinkedList ll1 = new LinkedList();
        ll1.addFirst(10);
        ll1.addLast(20);
        ll1.addLast(30);
        ll1.addLast(50);
        ll1.addLast(60);
        ll1.display();
        ll1.InsertInASortedLL(40);
        ll1.display();
        ll1.NthNodeFromTheEnd(2);
        ll1.display();
        System.out.println();
        ll1.head = ll1.ReverseRecursive(ll1.head);
        ll1.display();
        LinkedList ll2 = new LinkedList();
        ll2.addFirst(10);
        ll2.addLast(20);
        ll2.addLast(30);
        ll2.addLast(40);
        ll2.addLast(50);
        ll2.getNodeAt(4).next = ll2.getNodeAt(2);
        //ll2.display();
        System.out.println(ll2.DetectLoop());
        //System.out.println(ll2.DetectLoopApproach2());
        System.out.println(ll2.FloysCycleDetection());
        ll2.DetectionAndRemoval();
        ll2.display();
        System.out.println();
        ll2.display();
        ll2.addFirst(17);
        ll2.addAt(2,97);
        ll2.addLast(45);
        ll2.display();
        ll2.EvenOddSeperation(ll2);
        System.out.println();
        ll2.removeLast();
        ll2.display();
        ll2.PairWiseSwappingPointer();
        ll2.display();
    }
}