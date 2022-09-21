import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @program: lessson
 * @description: hashtable
 * @author: xin
 * @create: 2019-11-24 12:49
 **/
public class HashTable<K,V> {
    private TreeMap<K,V>[] hashtable;
    private int M;
    private int size;

    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 6;

    public HashTable(int M) {
        this.M = M;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++)
            hashtable[i] = new TreeMap<>();
    }

    public HashTable() {
        this(initCapacity);
    }

    public int getSize() {
        return size;
    }

    //将元素的哈希值转换为我们所构建的hashtable的哈希值
    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void add(K key, V value){
        TreeMap<K,V> map = hashtable[hash(key)];

        if (map.containsKey(key)){
            map.put(key,value);
        }else {
            map.put(key,value);
            size++;
        }

        if (size >= upperTol * M){
            resize(M * 2);
        }
    }

    public boolean contains(K key){
        TreeMap<K,V> map = hashtable[hash(key)];
        if (map.containsKey(key))
            return true;
        return false;
    }

    public V remove(K key){
        TreeMap<K,V> map = hashtable[hash(key)];
        V ret = null;
        if (map.containsKey(key)){
            ret = map.remove(key);
            size--;
        }

        if (size <= lowerTol * M && M / 2 >= initCapacity){
            resize(M / 2);
        }

        return ret;
    }

    private void resize(int newM){
        TreeMap<K,V>[] nhashtable = new TreeMap[newM];
        for (int i = 0; i < newM; i ++){
            nhashtable[i] = new TreeMap<>();
        }

        int oldM = M;
        this.M = newM;

        for (int i = 0; i < oldM; i++){
            TreeMap<K,V> map = hashtable[i];
            for (K key : map.keySet()){
                nhashtable[hash(key)].put(key,map.get(key));
            }
        }

    }

    public void set(K key, V value){
        TreeMap<K,V> map = hashtable[hash(key)];
        if (map.containsKey(key)){
            map.put(key,value);
        }
    }

    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }
}
