package sort.heap;

import edu.princeton.cs.algs4.Heap;
import sort.base.Basetemplate;

import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2018/7/9 10:59
 * @desc： 堆排序：构造大根堆实现堆序（小根堆原理类似）
 * @note:
 *      核心思想：1.构建初始大根堆（此时最大值在堆的根节点） 54 26 41 22 18 7 3 9 1
 *              2. 和最后一个节点交换（此时最大值在数组的最后一个位置）
 *                 将除去最后一个节点的剩余数据重新构造成堆 41 26 7 22 18 1 3 9 54
 *              3.重复 1 2操作 一直到整个数组有序
 * @note: 升序需要构建大根堆
 *        降序需要构建小根堆
 */
public class HeapSort extends Basetemplate {

    @Override
    public void sort(Comparable[] arr) {
        int n = arr.length;
        //1.构建大顶堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            sink(arr, i, n);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = n - 1; j > 0; j--) {
            exch(arr, 0, j);//将堆顶元素与末尾元素进行交换
            sink(arr, 0, j);//重新对堆进行调整
        }
    }

    /**
     * 将传入的数组 从i到length+i构建为大根堆
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(Comparable[] arr, int i, int length) {
        Comparable temp = arr[i];//先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
            //如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && less(arr[k], arr[k + 1])) {
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (!less(arr[k], temp)) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    public static void main(String[] args) {
        Integer []arr = {9,18,7,26,54,41,3,22,1};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    //和之前的大根堆不同的地方：数组从0开始  0 的儿子是 1 2 1的儿子 3 4 2的儿子三个 5 6
    public void sink(Comparable[]a,int k,int n){
        while ((k * 2 + 1) < n    ){
            int j = k * 2 + 1 ;
            //找到儿子节点中较大值
            if (j+1 < n && less(a[j],a[j+1]))
                j++;
            //如果儿子最大值小于父亲，跳过
            if (a[k].compareTo(a[j]) > 0)
                break;
            exch(a,k,j);
            k = k*2+1;
        }
    }

}
