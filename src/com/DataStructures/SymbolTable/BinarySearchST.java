package com.DataStructures.SymbolTable;


import java.util.ArrayList;
import java.util.List;

public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] values;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];//java不允许泛型数组，只能创建Object再强制转换类型
        this.size = 0;
    }

    public void put(Key key, Value value) {
        if (value == null) {
            delete(key);
            return;
        }
        //如果键存在，则修改键值
        int pos = rank(key);
        if (pos < size && keys[pos].compareTo(key) == 0) {
            values[pos] = value;
            return;
        }
        //键值不存在，判断数组是否越界并将数组扩容
        if (size == keys.length) resize(2 * keys.length);

        //将元素插入到指定位置
        for (int i = size; i > pos; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[pos] = key;
        values[pos] = value;
        size++;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int pos = rank(key);
        if (pos < size && keys[pos].compareTo(key) == 0)
            return values[pos];
        else return null;
    }

    public boolean contains(Key key) {
        if (isEmpty()) return false;
        int pos = rank(key);
        if (pos < size() && keys[pos].compareTo(key) == 0)
            return true;
        else
            return false;
    }

    private boolean isEmpty() {
        return size() == 0;
    }

    public Value delete(Key key) {
        int pos = rank(key);
        //没找到则返回空
        if (pos < size && keys[pos].compareTo(key) != 0) {
            return null;
        }
        Value value = values[pos];
        //数组容量变小
        if (size < keys.length / 2) resize(keys.length / 2);
        //通过移动元素删除
        for (int i = pos; i < size - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[size - 1];
    }
    
    //小于等于key的最大值
    public Key floor(Key key) {
        int pos = rank(key);
        if (pos < size && keys[pos].compareTo(key) == 0) {
            return keys[pos];
        }
        return keys[pos - 1];
    }
    //大于等于key的最小值
    public Key ceiling(Key key) {
        int pos = rank(key);
        return keys[pos];
    }

    /**   
    * @author leaderHoo
    * @date 2018/7/14 12:01
    * @param [key]
    * @Desc   非递归查找当前key值所在位置
    * @return int ：如果找到key，返回key的位置；如果未找到，返回当前key应该存在位置小于key的最大元素的下一个位置
    */ 
    public int rank(Key key) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            int cmp = key.compareTo(keys[middle]);
            if (cmp < 0) high = middle - 1;
            else if (cmp > 0) low = middle + 1;
            else return middle;
        }
        //TODO
        return low;
    }

    //递归的二分查找
    public int rank(Key key, int low, int high) {
        if (low > high) return low;
        int pos = rank(key);
        int cmp = key.compareTo(keys[pos]);
        if (cmp > 0) return rank(key, pos + 1, high);
        else if (cmp < 0) return rank(key, low, pos - 1);
        else return pos;
    }

    public Key select(int index) {
        return keys[index];
    }

    public Iterable<Key> keys(Key low, Key high) {
        List<Key> keys = new ArrayList<Key>(size);
        for (int i = 0; i < size; i++) {
            keys.add(this.keys[i]);
        }
        return keys;
    }

    //该函数仅仅将容量扩大，但是有效元素数量并未改变，所以大小还是size
    @SuppressWarnings("unchecked")
    public void resize(int capacity) {
        Key[] newKeys = (Key[]) new Comparable[capacity];
        Value[] newValues = (Value[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }
        keys = newKeys;
        values = newValues;
    }

    public static void main(String[] args) {
        BinarySearchST<String, String> bst = new BinarySearchST<>(12);
        bst.put("1", "12");
        bst.put("2", "12");
        bst.put("3", "12");
        bst.put("4", "12");
        bst.ceiling("1");

    }
}