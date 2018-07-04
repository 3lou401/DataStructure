package sort.quickSort;

import sort.base.Basetemplate;

/**
 * @Author: leaderHoo
 * @Date: 2018/7/3 17:26
 * @Desc： 三项切分快速排序
 */
public class Quick3Way extends Basetemplate {

    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length <=1)
            return;
        sort(a,0,a.length-1);
    }
    //三项切分
    private void sort(Comparable[] a, int left, int right) {
        if (left >= right)
            return;
        int lt = left,gt=right,i=left+1;
        Comparable v = a[left];
        while (i <= gt){
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a,lt++,i++);
            else if (cmp > 0) exch(a,i,gt--);
            else i++;
        }
        sort(a,left,lt-1);
        sort(a,gt+1,right);
    }
}
