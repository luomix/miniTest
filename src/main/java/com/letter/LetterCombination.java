package com.letter;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    //using array to improve performance
    private static String[] letterMap = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    //the iteration process stores the results
    private List<String> res = new ArrayList<String>();


    /**
     * combination letter in turn and add to res
     *
     * @param digit
     * @return
     */
    private List<String> combinationLetter(int digit) {
        String letters = letterMap[digit];
        if ("".equals(letters)) {
            return res;
        }
        int size = res.size();
        for (int j = 0; j < size; j++) {
            String tmp = res.remove(0);
            for(int k=0;k<letters.length();k++) {
                res.add(tmp+letters.charAt(k));
            }
        }
        return res;
    }

    /**
     * init res when call digitToLetter()
     */
    private void initRes(){
        res.clear();
        //add a "" string,facilitate the process execution in the future
        res.add("");
    }

    /**
     * function entrance
     *
     * @param digits
     * @return
     */
    public List<String> digitToLetter(int[] digits) {
        initRes();
        if (digits == null || digits.length == 0) {
            return res;
        }
        for (int digit : digits) {
            if (digit < 0 || digit > 99) {
                throw new IllegalArgumentException("the digit must from 0 to 99");
            }
            int tens = digit / 10;
            int single = digit % 10;
            if (tens != 0) {
                combinationLetter(tens);
            }
            combinationLetter(single);
        }

        return res;
    }
}
