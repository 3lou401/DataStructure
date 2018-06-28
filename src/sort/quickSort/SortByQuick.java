package sort.quickSort;

import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/27 14:26
 * @desc: 快速排序
 *        和归并排序区别在于 ：归并排序对于数组处理在递归调用之后，
 *        快速排序是 对数组二分之后，先处理数组，在递归分别处理
 *  快速排序 ：
 *
 */
public class SortByQuick {
    //
    public static void main(String[] args) {
        int [] a = {21,1,23,34,22,5,6,8,2,4,7,12234,
                22,44,5667,88,9090,3345,22434,11};

        sort(a,0,a.length-1);

        System.out.printf(Arrays.toString(a));

    }

    public static void sort(int[] a,int left,int right){
        if(left  > right )
            return ;
        int j = position(a,left,right);
        sort(a,left,j-1);
        sort(a,j+1,right);
    }

    private static int position(int[] a, int left, int right) {
        int i = left,j=right;
        int key = a[i];
        //一直到i和j相同时，返回
        while (i < j){
            //哨兵 i和j从两头向中间探测
            while ( a[j] >= key && j > i)
                j--;
            while ( a[i] <= key && j > i)
                i++;
            //交换i和j 只有i < j时才进行交换
            if (i < j)
                swap(a,i,j);
        }
        //基准位置归位:因为交换的时候第一个元素当时作为交换元素 key值，
        //  比较的时候，相同跳过去了，所以最后需要交换left与i的值
        a[left] = a[i];
        a[i] = key;
        //返回标记位置
        return j;
    }
    /**
     * 交换数组元素 ：采用+ -的方式交换元素；第二是直接传入数组引用，对数组进行操作
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }

}
