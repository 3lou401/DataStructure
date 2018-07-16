package SymbolTable;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: leaderHoo
 * @Date: 2018/7/14 12:11
 * @desc： 测试有序符号表
 */
public class OrderedST<Key extends Comparable<Key>,Value> {
    //两个平行数组，记录key和value
    private  Key[] keys;
    private  Value[] values;
    private int size;

    public OrderedST(int size) {
        //TODO  key是 new comparable[]
        keys = (Key[]) new Comparable[size];
        values = (Value[]) new Object[size];
    }

    private int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return getSize() == 0;
    }

    public void put(Key key,Value value){
        int pos = rank(key);

        //查找是否存在元素
        if (pos < getSize() && keys[pos].compareTo(key) == 0){
            values[pos] = value;
            return ;
        }
        // key值不存在，先移动元素，在插入元素,长度++
        for (int i = getSize();i > pos;i--){
            keys[i] = keys[i-1];
            values[i]=values[i-1];
        }
        keys[pos] = key;
        values[pos] = value;
        size++;
    }

    public Value get(Key key){
        if (getSize() == 0)
            return null;
        int pos = rank(key);
        if (pos < getSize() && keys[pos].compareTo(key) == 0)
            return values[pos];
        return null;
    }

    //查找key值对应位置
    private int rank(Key key) {
        int lo = 0;
        int hi = getSize()-1;
        while (lo <=  hi){
            int mid = lo+(hi - lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp > 0) lo = mid +1;
            else if (cmp < 0) hi = mid -1;
            else  if (cmp == 0) return mid;
        }
        return lo;
    }

    public Value delete(Key key){
        int pos = rank(key);
        if (pos < getSize() && keys[pos].compareTo(key) == 0){
            //pos就是要删除的元素
            Value ret = values[pos];
            for (int j = pos ;j < getSize() - 1;j++){
                keys[j] = keys[j+1];
                values[j] =values[j+1];
            }
            size--;
            return ret;
        }
        return null;
    }
    public boolean contain(Key key){
        int pos = rank(key);
        if (pos < size && keys[pos].compareTo(key) == 0){
            return true;
        }
        return false;
    }
    public Key min(){
        return  keys[0];
    }
    public  Key max(){
        return keys[size];
    }
    //小于等于key的，也就是pos上一位
    public Key floor(Key key){
        int pos = rank(key);
        if (pos < size && keys[pos].compareTo(key) == 0) {
            return keys[pos];
        }
        return keys[pos - 1];
    }

    public  Key celing(Key key){
        int pos = rank(key);
        return keys[pos];
    }

    public Iterable<Key> keys(){
        List<Key> kls = new ArrayList<>(size);
        for (int i = 0;i < size;i++)
            kls.add(keys[i]);
        return kls;
    }
}
