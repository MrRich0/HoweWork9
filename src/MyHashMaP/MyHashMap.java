package MyHashMaP;

import java.util.HashSet;
import java.util.Set;

public class MyHashMap<K, V> {
    private int size;
    static class Node<K, V>{
        private K key;
        private V value;
        private Node<K, V> next;
        public Node(K key,V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
//        @Override
//        public String toString() {
//            Node<K, V> temp = this;
//            StringBuilder sb = new StringBuilder();
//            while (temp != null) {
//                sb.append(temp.key + " -> " + temp.value + ",");
//                temp = temp.next;
//            }
//            return sb.toString();
//        }
    }
    private final int SIZE = 16;

    private Node<K, V> table[];

    MyHashMap(){
        table = new Node[SIZE];
    }

    public void put(K key, V value) {
        int hash = key.hashCode() % SIZE;
        Node<K, V> kvNode = table[hash];

        if (kvNode == null) {
            table[hash]= new Node<K, V>(key, value);
        } else {
            while (kvNode.next != null) {
                if (kvNode.getKey() == key) {
                    kvNode.setValue(value);
                    return;
                }
                kvNode = kvNode.next;
            }

            if (kvNode.getKey() == key) {
                kvNode.setValue(value);
                return;
            }

            kvNode.next = new Node<K, V>(key, value);
        }
        size++;
    }

    public V get(K key){
        int hash = key.hashCode() % SIZE;
        Node<K, V> kvNode = table[hash];

        if(kvNode == null)
            return null;

        while (kvNode != null){
            if(kvNode.getKey() == key){
                return kvNode.getValue();
            }
            kvNode = kvNode.next;
        }
        return null;
    }

    public void remove(K key){
        int hash = key.hashCode() % SIZE;
        Node<K, V> kvNode = table[hash];

        if(kvNode == null)
            throw new NullPointerException();

        if(kvNode.getKey() == key){
            table[hash] = kvNode.next;
            kvNode.next = null;
        }

        Node<K, V> prev  = kvNode;
        kvNode = kvNode.next;
        while (kvNode != null){
            if(kvNode.getKey() == key){
                prev.next = kvNode.next;
                kvNode.next = null;

            }
            prev = kvNode;
            kvNode = kvNode.next;
        }
        size--;
    }

    public void clear() {
        table = new Node[SIZE];
        size = 0;
    }

    public int size(){
        return size;
    }


    private Set<Node<K, V>> entrySet() {
        Set<Node<K, V>> set = new HashSet<>();
        for (Node<K, V> entry : table) {
            if (entry != null) {
                set.add(entry);
            }
        }
        return set;
    }
    public void printMap() {
        for (MyHashMap.Node node : entrySet()) {
            System.out.println("Key: " + node.getKey() + " Value: "
                    + node.getValue());
        }
    }

}
