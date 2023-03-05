package MyStacK;

public class Main {
    public static void main(String[] args) {
        MyStack<String> list = new MyStack<>();

        list.push("K");
        list.push("Q");
        list.push("C");
        list.push("O");
        list.printList();
        list.remove(3);
        list.remove(2);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.printList();
    }
}
