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
    
    //Function to find the common prefix
    public static String prefix(String s[]){

        //Sort the strings lexographically
        Arrays.sort(s); 
        
        //Res to store result
        String res=""; 

        //Iterate over first and last string till shorter one is exhausted or diffrerent character is obtained
        for(int i=0; i<(s[0].length()<s[s.length-1].length()?s[0].length():s[s.length-1].length()); i+=1){

            //If different character is encountered then break
            if(s[0].charAt(i)!=s[s.length-1].charAt(i))  break;

            //else add the common character to result
            res+=s[0].charAt(i);
        }

        //return result
        return res;
    }

    //Main function
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
