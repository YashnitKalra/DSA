class Node<T>{
    Node prev;
    Node next;
    T val;
    Node(T val){
        this.val = val;
        prev = null;
        next = null;
    }
}

class DoublyLinkedList<T>{

    Node<T> head, tail;

    DoublyLinkedList(){
        head = null;
        tail = null;
    }

    void insert(T val){
        Node node = new Node(val);
        if(head==null){
            head = tail = node;
        }
        else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    Node popFirst(){
        Node res = head;
        head = head.next;
        if(head==null)
            tail = null;
        else
            head.prev = null;
        return res;
    }

    Node popLast(){
        Node res = tail;
        tail = tail.prev;
        if(tail==null)
            head = null;
        else
            tail.next = null;
        return res;
    }

    T peekFirst(){
        return head.val;
    }

    T peekLast(){
        return tail.val;
    }

    void remove(Node node){
        if(node==head) popFirst();
        else if(node==tail) popLast();
        else{
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }
}