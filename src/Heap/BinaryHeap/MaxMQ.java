package Heap.BinaryHeap;

/**
 * @Author: leaderHoo
 * @Date: 2018/7/6 0:00
 * @Desc: 二叉堆表示优先队列 : 实际上就是最大堆
 * @note:
 *     某个节点的优先级上升，在堆底插入元素，需要由下到上恢复堆序
 *     某个节点优先级下降，将根节点替换为较小元素时，需要由上到下恢复堆序
 *
 * @note2
 *      插入元素时，将新元素添加到数组末尾，增加堆得大小，并让新元素上浮到合适的位置
 *      删除最大元素时，从数组顶端删除最大元素，将数组最后一个元素放到顶端，减小堆的大小，并下沉元素
 */
public class MaxMQ<key extends  Comparable<key>> {

    private key [] pq;
    private int currentSize = 0;


    public MaxMQ(int MaxSize) {
        pq = (key[]) new Comparable[MaxSize+1];
    }

    public void add(key key){
        pq[++currentSize] = key;
        swim(currentSize);
    }
    //delMax
    public key poll(){
        key max = pq[1];
        exch(1,currentSize-1);
        pq[currentSize + 1] = null;
        shink(1);
        return max;
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) <= 0;
    }

    private void exch(int i,int j){
        key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    //上浮 : 由下至上的堆有序化
    private  void swim(int k){
        //a[0]元素不使用 k/2是父节点，父亲小于儿子需要交换
        while (k > 1 && less(k/2,k)){
            exch(k/2,k);
            k=k/2;
        }
    }
    //下沉
    private void  shink(int k){
        while (k*2 <= currentSize){
            int j = 2*k;
            if (j<currentSize&&less(j,j+1))
                j++;
            if (!less(k,j))
                break;
            exch(k,j);
            k = j;
        }
    }

    //

}
