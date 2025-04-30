/*
 1790. Check if One String Swap Can Make Strings Equal

 You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.

Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.

Example 1:
Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".

Example 2:
Input: s1 = "attack", s2 = "defend"
Output: false
Explanation: It is impossible to make them equal with one string swap.

Example 3:
Input: s1 = "kelb", s2 = "kelb"
Output: true
Explanation: The two strings are already equal, so no string swap operation is required.

Constraints:
1 <= s1.length, s2.length <= 100
s1.length == s2.length
s1 and s2 consist of only lowercase English letters.
 */
package leetcodeQuestions;
public class checkIfOneStringSwapCanMakeStringsEqual {
    
    public static boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length()!=s2.length()) return false;
        int c=0; int []freq1=new int[26]; int []freq2=new int[26];
        for(int i=0;i<s1.length();i+=1){
            freq1[s1.charAt(i)-'a']+=1;
            freq2[s2.charAt(i)-'a']+=1;
        }
        for(int i=0;i<26;i+=1) if(freq1[i] != freq2[i]) return false;
        for(int i=0;i<s1.length();i+=1){
            if(c>2) return false;
            if(s1.charAt(i)!=s2.charAt(i)){
            if(s1.indexOf(s2.charAt(i))==-1) return false;
            if(s2.indexOf(s1.charAt(i))==-1) return false;
            else c+=1;}
        }
        return c<=2;
    }


    public static void main(String[] args) {
        String s1 = "bank";
        String s2 = "kanb";
        System.out.println(areAlmostEqual(s1, s2)); // Output: true

        s1 = "attack";
        s2 = "defend";
        System.out.println(areAlmostEqual(s1, s2)); // Output: false

        s1 = "kelb";
        s2 = "kelb";
        System.out.println(areAlmostEqual(s1, s2)); // Output: true
    }
}
