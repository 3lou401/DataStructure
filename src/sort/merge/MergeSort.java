package sort.merge;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/22 18:53
 * @desc： 归并排序 ：利用内存，创建一个大小是两个子序列之和的数组，进行插入
 */
public class MergeSort {
    //将两个数组归并起来
    public  static void merge(int [] a,int left,int mid,int right){
        //比较两个数组

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
    public  static  void sort(int [] a){
        if (a.length  <= 1)
            return;
        mergeSort(a,0,a.length-1);
    }
}
