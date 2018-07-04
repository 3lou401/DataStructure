package sort.merge;

import sort.base.Basetemplate;

/**
 * @Author: leaderHoo
 * @Date: 2018/7/2 16:49
 * @Desc： 优化，采用辅助数组实现归并排序 当数据量大时，创建数组也会消耗内存
 */
public class Mergee extends Basetemplate {

    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length <=1)
            return;
         Comparable [] temp = new Comparable[a.length];
         mergeSort(a,temp,0,a.length-1);
         a=temp;
    }

    private void mergeSort(Comparable[] a, Comparable[] temp, int left, int right) {
        if (left < right){
            int mid = (left +right)/2;
            mergeSort(a,temp,left,mid);
            mergeSort(a,temp,mid+1,right);
            mergeArray(a,temp,left,mid,right);
        }
    }

    private void mergeArray(Comparable[] a, Comparable[] temp, int left, int mid, int right) {
        int i=left,j=mid+1,k=0;
        while (i <= mid && j <= right){
            if (less(a[i],a[j]))
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }
        while ( i <= mid )
            temp[k++] = a[i++];
        while ( j <= mid )
            temp[k++] = a[j++];

        //copy数组
        for(i = 0;i < k;i++)
            a[i+left] = temp[i];
    }
}
