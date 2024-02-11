import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Pair {
    private int key;
    private int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}


public class MyHashMap {

    List<List<Pair>> hashMap;
    int moduloFactor;

    public MyHashMap() {
        hashMap = new ArrayList<>();
        moduloFactor = 2069;
        for(int i = 0;i < moduloFactor; i++) {
            hashMap.add(i, new LinkedList<>());
        }
    }

    public void put(int key, int value) {
        int index = key % moduloFactor;
        boolean contains = false;
        List<Pair> pairs = hashMap.get(index);

        for(int i = 0;i < pairs.size(); i++) {
            if(pairs.get(i).getKey() == key) {
                pairs.get(i).setValue(value);
                contains = true;
                break;
            }
        }

        if(!contains) {
            hashMap.get(index).add(new Pair(key, value));
        }
    }

    public int get(int key) {
        int index = key % moduloFactor;
        List<Pair> pairs = hashMap.get(index);
        for(Pair pair : pairs) {
            if(pair.getKey() == key) {
                return pair.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % moduloFactor;
        List<Pair> pairs = hashMap.get(index);
        for(int i = 0;i < pairs.size(); i++) {
            if(pairs.get(i).getKey() == key) {
                pairs.remove(i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }

}

