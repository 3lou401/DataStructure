package RetrciveUseCase;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/20 22:31
 * @Desc:
 */
public class RecursionCase {
  public static int fn(int a, int b){
      if (b == 0) return 0;
      if (b%2 ==0) return fn(a+a,b/2);
      return fn(a+a,b/2)+a;
  }

    public static void main(String[] args) {
        System.out.printf("=="+fn(2,25));
    }
}
