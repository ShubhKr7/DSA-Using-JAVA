/*
 14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */

package leetcodeQuestions;
import java.util.*;
public class longestCommonPrefix {
    
    public static String prefix(String s[]){
        Arrays.sort(s); String res=""; 
        for(int i=0; i<(s[0].length()<s[s.length-1].length()?s[0].length():s[s.length-1].length()); i+=1){
            if(s[0].charAt(i)!=s[s.length-1].charAt(i))  break;
            res+=s[0].charAt(i);
        }
        return res;
    }

    public static void main(String[] args) {
        // String s[]={"flower","flow","flight"};
        // String s[]={"dog","racecar","car"};
        // String s[]={"String","Strong","Shubhankar"};
        // String s[]={"a"};
        String s[]={"","b"};
        String res = prefix(s);
        System.out.println("Res:"+res);
    }
}
