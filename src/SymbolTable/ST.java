package SymbolTable;

import java.util.Iterator;

/**
 * @Author: leaderHoo
 * @Date: 2018/7/13 10:47
 * @Desc: 符号表的抽象接口
 */
public interface  ST<K extends Comparable<K>,V> {
    void put(K key, V value);

     V get(K key);

     void delete(K key);

     boolean contains(K key);

    Iterator<K> keys();
}
