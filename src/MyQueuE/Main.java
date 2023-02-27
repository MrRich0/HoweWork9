package MyQueuE;

public class Main {
    public static void main(String[] args) {
        MyQueue<String> list = new MyQueue<>();
        list.add("L");
        list.add("B");
        list.add("C");
        list.add("D");

        list.poll();
        list.printList();
    }
}
