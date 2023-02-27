package MyLinkedLisT;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

       list.printList();
        System.out.println("list.get(2) = " + list.get(2));
        System.out.println("list.size() = " + list.size());
        list.remove(3);
        list.printList();
        list.clear();
        list.printList();
    }
}
