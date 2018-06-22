package sort.hillSort;
import java.util.Arrays;
import java.util.GregorianCalendar;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/22 10:19
 * @desc： 希尔排序:在数组中采用跳跃式分组的策略，通过某个增量将数组元素划分为若干组
 *          然后逐渐缩小增量。实际使用时，便可以避免出现直接插入排序移动元素过多的问题
 *      注意：希尔排序为不稳定性排序。因为相同的元素可能在各自的插入排序中移动
 */

public class SortByHill {
    public static void main(String []args){
        int []arr ={1,4,2,7,9,8,3,4};
        sortUseGap(arr);
        System.out.println(Arrays.toString(arr));
//        int []arr1 ={1,4,2,7,9,8,3,6};
//        sort1(arr1);
//        System.out.println(Arrays.toString(arr1));
    }

    /**
     * 采用交换的方式进行希尔排序，增量模式默认是2
     * 第一次 grap 7 9 8 3 4 2 1  (grap = 3 ，间隔是3 )
     * 第二次 grap =1 i = 1 -> 6 ; j-grap 0-> 5 (此时 while循环可能执行多次)
     * @param a
     */
    public static void sort(int [] a){
        int n = a.length;
        for (int gap = n/2 ; gap > 0; gap/=2){
            for (int i = gap;i < a.length; i++){
                int j = i;
                while (j-gap > 0 && a[j] < a[j-gap]){
                    swap(a,j-gap,j);
                    j-=gap;
                }
            }
        }
    }

    /**
     * 2与增量值有关 ，如果设为2，增量值就是 N/2,就是每隔N/2个元素比较
     * @param a
     */
    public static void sortUseGap(int [] a){
        int len =a.length;
        int h = 1;
        //下面循环是为了确定初始的的变量
        while (h < len/2) h = 2*h+1;
        while (h >=1){
            for (int i = h; i<len;i++){
                for(int j =i;j-h>=0 && a[j] < a[j-h];j-=h){
                    swap(a,j,j-h);
                }
            }
            h/=2;
        }
    }

    /**
     * 希尔排序 针对有序序列在插入时采用移动法。
     * @param arr
     */
    public static void sort1(int []arr){
        //增量gap，并逐步缩小增量
        for(int gap=arr.length/2;gap>0;gap/=2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i=gap;i<arr.length;i++){
                int j = i;
                int temp = arr[j];
                if(arr[j]<arr[j-gap]){
                    while(j-gap>=0 && temp<arr[j-gap]){
                        //移动法
                        arr[j] = arr[j-gap];
                        j-=gap;
                    }
                    arr[j] = temp;
                }
            }
        }
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