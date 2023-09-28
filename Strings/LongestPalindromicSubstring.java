package Strings;
//Problem : https://leetcode.com/problems/longest-palindromic-substring/description/
// Solution Approach : https://www.youtube.com/watch?v=XYQecbcd6_c&t
public class LongestPalindromicSubstring {
    String isPalin(int l, int r, String s){
        String res = "";
        int n = s.length();
       while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
           res = s.substring(l,r+1);
           l--;
           r++;
       }
       return res;
    }
    public String longestPalindrome(String s) {
        String longPalin = "";
        String oddPalin  = "";
        String evenPalin = "";
        // For Each Chacter We are assuming it Might be a Middle of the Palindrome, Getting the Longest Palindrome
        // We Might have the Palindrome to be of Even and Odd length; So considering both Scenarios
        for(int i=0;i<s.length();i++){
            oddPalin = this.isPalin(i,i,s);
            evenPalin = this.isPalin(i,i+1,s);
            String currPalin = evenPalin;
            if(oddPalin.length()>evenPalin.length()) currPalin = oddPalin;
            if(currPalin.length()>=longPalin.length()) longPalin = currPalin;
        }
        return longPalin;
    }
}
