package MyQueuE;

public class MyQueue<E> {
    static class Node<E>{
        E element;
        public Node(E element) {
            this.element = element;
        }
        Node<E> next;
    }
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public void add(E element){
        Node<E> newNode = new Node<>(element);
        if(head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size ++;
    }

    public E poll(){
        Node<E> revHead = head;
        head = head.next;
        return revHead.element;

    }
    public E peek(){
        return head.element;
    }

    public int size(){
        return size;
    }

    public void clear(){
        head = tail = null;
    }
    public void printList(){
        Node<E> ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.element + " —> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }
}
