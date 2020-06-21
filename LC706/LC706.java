import java.util.ArrayList;
class MyHashMap {
    private ArrayList keys[];
    private ArrayList values[];
    /** Initialize your data structure here. */
    public MyHashMap() {
        keys = new ArrayList [100];
        values = new ArrayList [100];
        for(int i = 0; i < 100; i++){
            keys[i] = new ArrayList<Integer>();
            values[i] = new ArrayList<Integer>();
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = key % 100;
        int keyInd = keys[i].indexOf(key);
        if(keyInd == -1){
            keys[i].add(key);
            values[i].add(value);
        }
        else{
            values[i].set(keyInd, value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = key%100;
        int keyInd = keys[i].indexOf(key);
        if(keyInd == -1){
            return -1;
        }
        int result = Integer.parseInt(values[i].get(keyInd).toString());
        return result;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = key % 100;
        int keyInd = keys[i].indexOf(key);
        if(keyInd == -1){
            return;
        }
        keys[i].remove(keyInd);
        values[i].remove(keyInd);
    }
}
class LC706{
    public static void main(String args[]){
        MyHashMap obj = new MyHashMap();
        //int[] arguments = {[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2]};
        //String[] funcs = {"MyHashMap","put","put","get","get","put","get", "remove", "get"};

        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        obj.put(2,1);
        System.out.println(obj.get(2));
        obj.remove(2);
        System.out.println(obj.get(2));
    }
}