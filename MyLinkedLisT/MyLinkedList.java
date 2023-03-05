package MyLinkedLisT;

import java.util.Objects;

public class MyLinkedList<E> {
    static class Node<E>{
        E element;
        public Node(E element) {

            this.element = element;
        }
        Node<E> next;
    }
    private Node<E> first;
    private Node<E> last;
    private int size;
    public void add(E element){
        Node<E> newNode = new Node<>(element);
        if(first == null){
            first = this.last = newNode;
        }else{
         last.next = newNode;
         last = newNode;
        }
    size++;
    }

    public E remove(int index){
        Objects.checkIndex(index,size);
        E revElement = null;
        if(index == 0){
            revElement = first.element;
            first = first.next;
            if(first == null){
                last = null;
            }
        } else{
            Node<E> current = first;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            revElement = current.next.element;
            current.next = current.next.next;
            if(index == size - 1){
                last = current;
            }
        }

        size--;
        return revElement;
    }

    public E get(int index){
        Objects.checkIndex(index,size);
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
                 current = current.next;
        }
        return (E) current.element;
    }

    public int size(){
        return size;
    }

    public void clear(){
        first = last = null;
        size = 0;
    }

   public void printList(){
        Node<E> ptr = first;
       while (ptr != null)
       {
           System.out.print(ptr.element + " —> ");
           ptr = ptr.next;
       }

       System.out.println("null");
   }
   }

