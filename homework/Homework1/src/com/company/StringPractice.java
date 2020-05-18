package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringPractice {
    public static void main(String[] args) {
        String str1 = "Algorithms";
        String ans1 = str1.substring(2, 4);
        String ans2 = str1.substring(0, 4);
        System.out.println(ans1);
        System.out.println(ans2);

        System.out.println(compareString("abcd", "abcd"));
        System.out.println(compareString("abc", "abcd"));

        String str2 = "https://www.amazon.com/demo?test=abc";
        System.out.println(URL(str2));
    }

    public static List<String> URL (String s) {
        StringTokenizer st = new StringTokenizer(s, ":/.?=");
        List<String> res = new ArrayList<>();
        while(st.hasMoreTokens()) {
            res.add(st.nextToken());
        }
        return res;
    }

    public static boolean compareString (String s1, String s2) {
        if (s1 == null && s2 == null)
            return true;

        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }

    public static String combineStrings(List<String> words) {
        StringBuilder sb = new StringBuilder();
        for (String word: words) {
            sb.append(word);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
