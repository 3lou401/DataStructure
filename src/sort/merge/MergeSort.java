package sort.merge;

import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/22 18:53
 * @desc： 归并排序 ：利用内存，创建一个大小是两个子序列之和的数组，进行插入
 *  NlogN
 */
public class MergeSort {
    //将两个数组归并起来
    public  static void merge(int [] a,int left,int mid,int right){
        int [] temp = new int[right-left +1];

        int k=0;
        int i = left,j=mid+1;

        //比较左右两个数组，相同位置，取小的值
        while (i <= mid && j <= right){
            //归并
            if (a[i] < a[j]){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }
        //将a b数组剩余的数值放到数组中
        while ( i <= mid){
            temp[k++] = a[i++];
        }
        while ( j <= right){
            temp[k++] = a[j++];
        }
        //将排序好的temp数组放到a中
        for(int x = 0;x < temp.length;x++)
            a[x+left] = temp[x];

    }
    //归并排序
    public static int []  mergeSort(int [] a,int left,int right){
        if (left <right){
            int mid = (left + right)/2;
            mergeSort(a,left,mid);
            mergeSort(a,mid+1,right);
            merge(a,left,mid,right);
        }
        return  a;
    }
    //最终调用规定排序的地方
    public  static  int[] sort(int [] a){
        if (a.length  <= 1)
            return null;
        return  mergeSort(a,0,a.length-1);
    }

    public static void main(String[] args) {
        int [] a = {21,1,23,34,22,5,6,8,2,4,7,12234,22,44,5667,88,9090,3345,22434,11};

        System.out.printf(Arrays.toString(sort(a)));
    }
}
