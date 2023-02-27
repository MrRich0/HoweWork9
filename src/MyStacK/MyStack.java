package MyStacK;

import java.util.EmptyStackException;
import java.util.Objects;

public class MyStack<E> {
    static class Node<E>{
        E element;

        public Node(E element) {
            this.element = element;
        }

        Node<E> next;
    }
    private Node<E> top;
    private int size;

    public void push(E element) {
        Node<E> newNode = new Node<E>(element);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }
    public E remove(int index){
        E element;
        Objects.checkIndex(index,size);
        if(top == null){
            throw new EmptyStackException();
        }
        if(index == 0){
            element = top.element;
            top = top.next;
        }else {
            Node<E> current = top;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            element = current.element;
            current.next = current.next.next;
        }
        size --;
        return element;
    }


    public void clear(){
        top = null;
    }

    public E pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        E element = top.element;
        top = top.next;
        size--;
        return element;
    }

    public E peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.element;
    }

    public int size() {
        return size;
    }
    public void printList(){
        Node<E> ptr = top;
        while (ptr != null)
        {
            System.out.print(ptr.element + " —> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }
}
