package com.DataStructures.adT;

/**
 * Created by LeaderHoo on 2018/3/23
 */
public class MyArrayList {
    private  static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] items;

    public MyArrayList() {
        this.size = 0;
        ensurecapacity(DEFAULT_CAPACITY);
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void ensurecapacity(int newCapacity){
        if(newCapacity < size){
            return;
        }
        Object[] newArr = new Object[size * 2];
        for (int i = 0;i < size;i++)
            newArr[i] = items[i];
        items = newArr;
    }
    public void add(int index,Object obj){
        if (items.length == size)
            ensurecapacity(size*2);
        for (int j = size;j > index;j--){
            items[j]=items[j-1];
        }
        items[index] =obj;
        size++;
    }

    public Object remove(int index){
        Object item = null;
        item = items[index];
        for (int i = index;i<size;i++){
            items[i] = items[i+1];
        }
        size--;
        return item;
    }

}
