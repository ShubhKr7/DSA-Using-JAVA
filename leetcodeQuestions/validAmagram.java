/*
 242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 10^4
s and t consist of lowercase English letters.
 */

package leetcodeQuestions;
import java.util.*;
public class validAmagram {
    
    //Function to check if the two strings are amagrams or not?
    public static boolean isAnagram(String s, String t) {

        //Store characters of one string into an arraylist
        ArrayList<Character> list = new ArrayList<>();

        //Make an empty string
        String k="";

        //Iterate over the first string and add its characters to the arraylist
        for(int i=0; i<s.length(); i+=1) list.add(s.charAt(i));

        //Iterate over the second string
        for(int i=0; i<t.length(); i+=1){

            //Check if the character exists or not
            if(list.contains(t.charAt(i))){

                //Add that character to the empty string k and remove it from arraylist
                k+=t.charAt(i);
                list.remove(list.indexOf(t.charAt(i)));
            }
        }

        //If k becomes exactly equal to second string and the arraylist becomes empty then it's an amagram or not
        if(list.size()==0&&k.equals(t)) return true;
        return false;
    }

    //Main function
    public static void main(String[] args) {
        String s="abc";
        String t="bca";
        System.out.println(isAnagram(s,t));
    }
}
