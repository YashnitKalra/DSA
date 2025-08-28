class Node<T>{
    Node<T> prev;
    Node<T> next;
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
        Node<T> node = new Node<T>(val);
        if(head==null){
            head = tail = node;
        }
        else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    Node<T> popFirst(){
        Node<T> res = head;
        head = head.next;
        if(head==null)
            tail = null;
        else
            head.prev = null;
        return res;
    }

    Node<T> popLast(){
        Node<T> res = tail;
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

    void remove(Node<T> node){
        if(node==head) popFirst();
        else if(node==tail) popLast();
        else{
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }
}