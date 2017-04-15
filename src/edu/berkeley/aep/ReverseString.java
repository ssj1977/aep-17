package edu.berkeley.aep;

// Perform string reversal
public class ReverseString {
    public static String reverse(String original) {
        if (original.length()<=0) return "";
        char firstCharacter = original.charAt(0);
        String subString = original.substring(1);
        return reverse(subString) + firstCharacter;
    }
}
