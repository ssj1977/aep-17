package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseStringtest {
    @Test
    public void ReverseABCDtoDCBA() {
        String original = "ABCD";
        String reversed = ReverseString.reverse(original);
        assertEquals(reversed, "DCBA");
        System.out.print(original + "=>" + reversed + "\n");
    }

    @Test
    public void ReverseAtoA(){
        String original = "A";
        String reversed = ReverseString.reverse(original);
        assertEquals(reversed, "A");
        System.out.print(original + "=>" + reversed + "\n");
    }

    @Test
    public void ReverseEmpty(){
        String original = "";
        String reversed = ReverseString.reverse(original);
        assertEquals(reversed, "");
        System.out.print(original + "=>" + reversed + "\n");
    }
}