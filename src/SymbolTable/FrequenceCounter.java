package SymbolTable;

import Utils.StdIn;

/**
 * @Author: leaderHoo
 * @Date: 2018/7/14 14:54
 * @Desc:统计出现频率高的字符串
 */
public class FrequenceCounter {
    public static void main(String[] args) {
        OrderedST<String,Integer> orderedST = new OrderedST<>(24);
        int minLen = 2;
        while (!StdIn.isEmpty() ){
            String word = StdIn.readString();

            if (word.endsWith("#")) break; //输入终止条件

            if (word.length() < minLen) continue; //忽略长度小的单词
            if (!orderedST.contain(word))
                orderedST.put(word,1);
            else
                orderedST.put(word,orderedST.get(word)+1);


        }

        //找到频率最高的单词
        String maxFrequencyWord="";

        orderedST.put(maxFrequencyWord,0);

        for (String key:
             orderedST.keys()) {
            System.out.println("key is "+key+" and the time is "+orderedST.get(key));
        }

    }
}
