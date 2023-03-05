package MyHashMaP;
public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer,String> myMap = new MyHashMap<>();

        myMap.put(1,"Vladimir");
        myMap.put(2,"Vlad");
        myMap.put(3,"Mir");

        myMap.printMap();

        myMap.remove(3);
        System.out.println(myMap.size());
        System.out.println(myMap.get(1));
        myMap.printMap();

        myMap.clear();
        myMap.printMap();
    }


}
