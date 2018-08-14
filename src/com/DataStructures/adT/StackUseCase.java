package com.DataStructures.adT;

import java.util.Stack;

/**
 * Created by LeaderHoo on 2018/3/24
 * 写一个中缀式转后缀式
 */
public class StackUseCase {
    public static void main(String[] args) {
        String s = "1+2*3-4/5+23";
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i= 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == Oper.ADD.getName()||
                    c == Oper.DEL.getName()||
                    c == Oper.CHEN.getName()||
                    c == Oper.CHU.getName()
                    ){
                if (stack.empty()){
                    stack.push(c);
                }else{
                    char top = stack.peek();
                    //TODO 比较大小需要微调
                    if(top > c){
                        sb.append(c);
                    }else{
                        stack.push(c);
                    }
                }
            }else {
                sb.append(c);
            }
        }
    }
}
enum Oper implements Comparable<Oper>{
   ADD(1,'+'),DEL(1,'-'),CHEN(2,'*'),CHU(2,'/');
   private int id;
   private char name;
    Oper(int id,char name) {
        this.id = id;
        this.name = name;
    }

    public char getName() {
        return name;
    }
}
class TestEnum{
    public static void main(String[] args) {
        char c = '+';
    }
}