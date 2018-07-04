package sort.merge;

import sort.base.Basetemplate;
import sort.insert.Insertion;

/**
 * @Author: leaderHoo
 * @Date: 2018/7/3 11:59
 */
public class MergeUInsert extends Basetemplate {

    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length <= 1)
            return;
        mergeSort(a, 0, a.length - 1);
    }

    private void mergeSort(Comparable[] a, int r, int p) {
        int len = a.length;
        int k = (int) Math.log(len);
        int q = (r + p) / 2;

        if ((r - p) > (2 * k)) {
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
        } else {
            insertSort(a, p, q);
            insertSort(a, q + 1, r);
        }
        merge(a, p, q, r);
    }


    private void insertSort(Comparable[] elements,int p,int q){
        Comparable[] temp=new Comparable[q-p+1];
        System.arraycopy(elements, p, temp, 0, q-p+1);
        new  Insertion().sort(temp);
        System.arraycopy(temp, 0, elements, p, q-p+1);
    }

    private void merge(Comparable[] a, int left, int center, int right) {
        int i = left;
        int j = center + 1;
        Comparable [] temp = new Comparable[right-left+1];
        int k = 0;
        while (i <= center && j <= right){
            if (less(a[i],a[j])){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }
        while (i <= center){
            temp[k++] = a[i++];
        }
        while (j <=right){
            temp[k++] = a[j++];
        }
        for (int l = 0;l<temp.length;l++){
            a[left+l] = temp[l];
        }
    }
}
