package StackAndQueue.CandyCrush1D.RecursivelyRemoveAdjacentDuplicates;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexApproach {
    public static void main(String[] args) {
        String str1 = "geeksforgeek";
        System.out.println(rremove(str1));

        String str2 = "abccbccba";
        System.out.println(rremove(str2));
    }

    public static String remove(String s) {
        Pattern pattern = Pattern.compile("(.)\\1*");
        Matcher matcher = pattern.matcher(s);
        String str = "";
        while (matcher.find()) {
            if (matcher.group().length() > 1) {
                s = matcher.replaceFirst("");
                matcher = pattern.matcher(s);
            } else {
                str += matcher.group();
                s = matcher.replaceFirst("");
                matcher = pattern.matcher(s);
            }
        }
        return str;
    }

    public static String rremove(String s) {
        String temp;
        while (s.length() != (temp = remove(s)).length()) {
            s = temp;
        }
        return s;
    }
}
