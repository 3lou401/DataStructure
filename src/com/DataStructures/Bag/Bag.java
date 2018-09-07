package com.DataStructures.Bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Author: leaderHoo
 * @Date: 2018/8/14 18:08
 * @desc: 添加一个只可以 添加 和遍历的数据结构
 */
public class Bag<Element> implements Iterable<Element> {

    //数据结构
    class Node<Element>{
        Element element;
        Node nextNode;
    }

    //Bag数据结构
    Node<Element> firstElement;
    int size;

    public Bag() {
        firstElement = null;
        size = 0;
    }

    public void add(Element element) {
        Node<Element> temp = new Node<>();
        temp.element = element;
        temp.nextNode= null;
        firstElement = temp;
        size++;
    }

    public boolean isEmpty() {
        return firstElement == null;
    }

    public int size(){return size;}

    public boolean contains(Element element) {
        Iterator<Element> iterator = this.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(element)){
                return true;
            }
        }
        return false;
    }
    @Override
    public Iterator<Element> iterator() {
        return new ListIterator<>(firstElement);
    }


    class ListIterator<Element> implements Iterator<Element> {

        private Node<Element> iterNode;

        public ListIterator(Node<Element> firstElement) {
            iterNode = firstElement;
        }

        @Override
        public boolean hasNext() {
            return iterNode != null;
        }


        @Override
        public Element next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Element element = iterNode.element;
            //TODO 一定注意 返回值并且指向下一个节点
            iterNode = iterNode.nextNode;
            return iterNode.element;
        }

    }
}
