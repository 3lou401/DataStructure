package com.Algorithm.recursive;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/20 14:11
 */
public class GetRecursiveUseCase {
    public String recursive(int n){
      if (n <= 0)
          return "";
      return recursive(n-3)+n+recursive(n-2)+n;
    }
    //TODO 此方法是错误方法：递归一定将结束条件放到最开始，否则会无限递归一直到栈溢出
    public String recursive2(int n){
        String s = recursive2(n-3)+n+recursive2(n-2)+n;
        if (n <= 0)
            return "";
        return  s;
    }

    public static void main(String[] args) {
        GetRecursiveUseCase grs = new GetRecursiveUseCase();
        System.out.printf(grs.recursive2(6));
    }
}
