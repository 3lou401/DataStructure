package StringUseCase;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/21 16:06
 * @desc： 判断字符串是否为回环变位
 */
public class GetCircularRoatation {
    //判断字符串s1和s2是否字符一致
    public static boolean isCircular(String s1,String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        int index = 0;
        if (len1 == len2){
            for (int  i= 0; i < len1;i++){
                if (s2.contains(s1.charAt(i)+"")){
                    index++;
                }
            }
            if (index == len1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ABDS";
        String s2 = "BDSD";
        System.out.printf("s1==s2 is "+isCircular(s1,s2));
    }
}
