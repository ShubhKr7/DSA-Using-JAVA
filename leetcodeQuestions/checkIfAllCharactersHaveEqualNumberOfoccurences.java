/*
 1941. Check if All Characters Have Equal Number of Occurrences

 Given a string s, return true if s is a good string, or false otherwise.

A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).

Example 1:
Input: s = "abacbc"
Output: true
Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.

Example 2:
Input: s = "aaabb"
Output: false
Explanation: The characters that appear in s are 'a' and 'b'.
'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of times.

Constraints:
1 <= s.length <= 1000
s consists of lowercase English letters.
 */

package leetcodeQuestions;
import java.util.Arrays;

public class checkIfAllCharactersHaveEqualNumberOfoccurences {
    
    //Function to check if all characters have equal number of occurences
    static boolean occur(String s){
        int a[]=new int [26];
        for(char c:s.toCharArray()){
            a[c-'a']+=1;
        }
        Arrays.sort(a);
        for(int i:a) {
            if(i>0&&i!=a[a.length-1]) return false;
        }
        return true;
    }

    //Main function
    public static void main(String[] args) {
        String s="abdfn";
        System.out.println(occur(s));
    }
}
