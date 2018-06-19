package sort.insert;

import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/14 17:16
 *
 */
public class SortbyInsert {
    public static void main(String[] args) {
        int [] list={1,3,5,2,4,9,6};
        //外层循环控制每一个位置的元素；内层循环负责移位( i =1； j=i & temp < a[j-1])
        for (int i = 1; i < list.length; i++) {
           int j =0;
           int temp = list[i];
           //TODO 之前失败的原因是没有用临时变量存储需要比较的值,因为list是会变化的
           for (j=i-1;j>0 && list[j] > temp ;j--){
               list[j+1] =list[j];
           }
            list[j+1] = temp;
        }
        System.out.printf(Arrays.toString(list));
    }

    public  void SortByInsert(){
        int [] list={1,3,5,2,4,9,6};
        //外层循环控制每一个位置的元素；内层循环负责移位( i =1； j=i & a[j] < a[j-1])
        for (int i = 1; i < list.length; i++) {
            int j = 0;
            int temp = list[i]; // 取出第i个数，和前i-1个数比较后，插入合适位置

            // 因为前i-1个数都是从小到大的有序序列，所以只要当前比较的数(list[j])比temp大，就把这个数后移一位
            for (j = i - 1; j >= 0 && temp < list[j]; j--) {
                list[j + 1] = list[j];
            }
            list[j + 1] = temp;

        }
        System.out.printf(Arrays.toString(list));
    }
}
