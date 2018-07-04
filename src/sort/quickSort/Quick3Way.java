package sort.quickSort;

import sort.base.Basetemplate;

/**
 * @Author: leaderHoo
 * @Date: 2018/7/3 17:26
 * @Desc： 三项切分快速排序
 *     每次切分之后，位于gt指针和lt指针之间的元素的位置都已经被排定，不需要再去处理了。
 *          之后将（lo,lt-1）,（gt+1,hi）分别作为处理左子数组和右子数组的递归函数的参数传入
 *
 *    维护 三个指针 lt  i  gt  如果 a[i] < temp  , exch(a,i++,lt++) ; 如果 a[i] > temp  exch(a,i,gt--) ;
 *          如果相同 i++ ; i小于gt一直循环</>
 */
public class Quick3Way extends Basetemplate {

    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length <=1)
            return;
        sort(a,0,a.length-1);
    }
    //三项切分 ：每次递归都保证 lt - gt 是有序的。
    private void sort(Comparable[] a, int left, int right) {
        if (left >= right)
            return;
        int lt = left,gt=right,i=left+1;
        Comparable v = a[left];
        // 切分成为 小于a[i] + 等于a[i] + 大于a[i] 。a[left]- a[i] ; a [i] - a[gt] ; a[gt]-a[right]
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
