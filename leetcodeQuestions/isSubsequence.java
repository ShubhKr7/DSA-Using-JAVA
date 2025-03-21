/*
 392. Is Subsequence

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false

Constraints:
0 <= s.length <= 100
0 <= t.length <= 10^4
s and t consist only of lowercase English letters.
 */

package leetcodeQuestions;
public class isSubsequence {
    
    //Function to find if the string s is a subsequence of string t
    public static boolean is(String s, String t) {
        return recur(s,t,0,0);
    }

    //Recursive function to try all possible combinations
    //Time complexity is O(n) where n is the length of the string t
    static boolean recur(String s, String t, int i, int j){
        if(i==s.length()) return true;
        if(j>=t.length()) return false;
        if(s.charAt(i)==t.charAt(j))
        return recur(s,t,i+1,j+1);
        return recur(s,t,i,j+1);
    }

    //Main Function
    public static void main(String[] args) {
        String s="abc";
        String t="adhrbfierjfbjfc";
        System.out.println(is(s,t));
    }
}
