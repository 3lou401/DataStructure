package String.withNumber;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/19 14:16
 */
public class StringAndNum {
    public String showBinaryNum(int a){
        String s = "";
        //循环的时候，一定注意循环变量的每次更改（while循环内每次操作）；
        while (a/2 > 0){
            s=(a % 2) + s;
            a = a/2;
        }
        return s;
    }

    public static void main(String[] args) {
        StringAndNum san = new StringAndNum();
        System.out.printf(san.showBinaryNum(124));
    }
}
