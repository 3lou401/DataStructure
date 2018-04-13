package com.base;

/**
 * Created by LeaderHoo on 2018/3/27
 */
public class PrintJiShu {
    int ones(int n){
        if(n  < 2){
            return  n;
        }
        return  n%2+ ones(n/2);
    }
}
