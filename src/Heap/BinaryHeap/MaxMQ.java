package Heap.BinaryHeap;

/**
 * @Author: leaderHoo
 * @Date: 2018/7/6 0:00
 * @Desc: 二叉堆表示优先队列 : 实际上就是最大堆
 * @note: 某个节点的优先级上升，在堆底插入元素，需要由下到上恢复堆序
 * 某个节点优先级下降，将根节点替换为较小元素时，需要由上到下恢复堆序
 * @note2 插入元素时，将新元素添加到数组末尾，增加堆得大小，并让新元素上浮到合适的位置
 * 删除最大元素时，从数组顶端删除最大元素，将数组最后一个元素放到顶端，减小堆的大小，并下沉元素
 * @note3
 *      数组 0 位置不用 所以 直接用a[curentSize]
 *
 */
public class MaxMQ<key extends Comparable<key>> {

    private key[] pq;
    public  int currentSize = 0;

    public MaxMQ() {
    }

    public MaxMQ(int MaxSize) {
        pq = (key[]) new Comparable[MaxSize + 1];
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public int size(){
        return currentSize;
    }
    public void add(key key) {
        //扩容
        if (currentSize  == pq.length - 1)
            // 扩容数组
            resizingArray(currentSize*2);
        pq[++currentSize] = key;
        swim(currentSize);
    }


    //delMax
    public key poll() {
        key max = pq[1];   //返回根节点
        exch(1, currentSize--); //首尾交换
        //小于数组1/4,将数组减半
        if(currentSize > 0 && currentSize == pq.length/4) {
            resizingArray(pq.length/2);
        }
        pq[currentSize +1] = null; //防止越界
        sink(1);
        return max;
    }
    //TODO 此处存在BUG,执行多次之后，pq[1]成为null
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) <= 0;
    }

    private void exch(int i, int j) {
        key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    //上浮 : 由下至上的堆有序化
    private void swim(int k) {
        //a[0]元素不使用 k/2是父节点，父亲小于儿子需要交换
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    //下沉
    private void sink(int k) {
        while (k * 2 <= currentSize) {
            int j = 2 * k;
            //找到儿子节点中较大的节点，（下沉时，只需要与最大的儿子交换即可）
            if (j < currentSize && less(j, j + 1))
                j++;
            if (!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    //数组大小修改
    private  void resizingArray(int len){
        key [] keys = (key[]) new Comparable[len];
        for(int i=0;i<currentSize;i++) {
            keys[i] = pq[i];
        }
        pq = keys;
    }

}
