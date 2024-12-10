/*
 796. Rotate String

 Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.

Example 1:
Input: s = "abcde", goal = "cdeab"
Output: true

Example 2:
Input: s = "abcde", goal = "abced"
Output: false

Constraints:
1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.
 */

package leetcodeQuestions;
public class rotateString {
    
    //Function to find if rotation is possible or not
    static boolean rotate(String s, String goal){

        //If both strings are not equal then return false
        if(s.length()!=goal.length()) return false;

        //Make the string twice
        s=s.substring(0,s.length())+s.substring(0,s.length());

        //Check if the goal string is a substring of the new string or not
        return s.contains(goal);
    }

    //Main Function
    public static void main(String[] args) {
        String s="abcde"; String goal="eabcd";
        System.out.println(rotate(s,goal));
    }
}
