package MyArrayLisT;
public class Main {
    public static void main(String[] args) {

       MyArrayList<String> list = new MyArrayList<>();


        list.add("A");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("f");
        list.add("A");
        list.remove(-3);
        list.remove(0);
        list.remove(0);
        System.out.println("list = " + list);
        System.out.println(list.size());


    }
}