package com.letter;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;


import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

public class LetterCombinationTest {
    private static LetterCombination l = null;

    @BeforeClass
    public static void before(){
        l = new LetterCombination();
    }

    @Test
    public void combinationLetter() {

    }

    /**
     * stage1: convert the digits from 0 to 9 into letters
     */
    @Test
    public void digitToLetterForStage1() {

        int[] a = {2,3};
        assertThat(l.digitToLetter(a), Matchers.hasItems("ad"));

        int[] b = {2,3,0,3};
        assertThat(l.digitToLetter(b), Matchers.hasItems("add","adf","ade"));

        int[] c = {2,3,0,3};
        assertThat(l.digitToLetter(c), not(Matchers.hasItems("esf")));


    }

    /**
     * stage2: converting the digits from 0 to 99 into letters
     */
    @Test
    public void digitToLetterForStage2() {

        int[] a = {12,33};
        assertThat(l.digitToLetter(a), Matchers.hasItems("add"));
        int[] b = {0,99,99};
        assertThat(l.digitToLetter(b), Matchers.hasItems("zzzz"));
    }

    @Test(expected=IllegalArgumentException.class)
    public void digitToLetterForStage2ForException() {

//        int[] a = {12,133};
//        assertThat(l.digitToLetter(a), Matchers.hasItems("add"));

        int[] b = {-12,33};
        assertThat(l.digitToLetter(b), Matchers.hasItems("add"));
    }


}