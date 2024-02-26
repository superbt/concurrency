package bt.code.sf.code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K,V>{
    private final  int capacity ;
    private final Map<K,V> cache;
    private  final LinkedList<K> keyList ;

    public LRUCache(int capacity){
        this.capacity = capacity ;
        this.cache = new HashMap<>(capacity);
        this.keyList = new LinkedList<>();
    }

    //put 操作 向缓存中存入一个 key - value
    public synchronized void put(K key, V value){
      //如果缓存中已经存在该key,则需要将其聪缓存中移除，因为它将被更新
        if(cache.containsKey(key)){
            keyList.remove(key);
        }
        //如果缓存已满，则需要删除最久未使用的key-value ,即keyList的第一个元素
        if(cache.size()>capacity){
            K  oldestKey = keyList.removeFirst();
            cache.remove(oldestKey);
        }
        //将心得key-value存入缓存中，并将key添加到keyList的末尾，表示最近被访问
        cache.put(key,value);
        keyList.addLast(key);
    }

    //get操作：根据key获取对应的Value
    public synchronized  V get(K key){
        //如果缓存中存在该key ,则将其从keyList中移除，并添加到末尾表示最近被访问
        if(cache.containsKey(key)){
            keyList.remove(key);
            keyList.addLast(key);
            return  cache.get(key);
        }
        return  null ;
    }

}
