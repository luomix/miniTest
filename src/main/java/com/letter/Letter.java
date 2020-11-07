package com.letter;

import java.util.ArrayList;
import java.util.List;

public class Letter {
    public static List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0) {
            return new ArrayList<String>();
        }
        //一个映射数组，分别映射数字0到9对应的字母
        String[] letter_map = {
                "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        List<String> res = new ArrayList<String>();
        //先往队列中加入一个空字符
        res.add("");
        for(int i=0;i<digits.length();i++) {
            //从第一个数字开始遍历，取出对应的字母串
            String letters = letter_map[digits.charAt(i)-'0'];
            //当数字是0或者1时，对应的字母串是"",跳过这次循环
            if("".equals(letters)){
                continue;
            }
            int size = res.size();
            //和队列种的每个字符进行组合
            for(int j=0;j<size;j++) {
                String tmp = res.remove(0);
                for(int k=0;k<letters.length();k++) {
                    res.add(tmp+letters.charAt(k));
                }
            }
        }
        return res;
    }

}
