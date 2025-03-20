/*
 647. Palindromic Substrings

 Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

Example 1:
Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

Constraints:
1 <= s.length <= 1000
s consists of lowercase English letters.
 */

package leetcodeQuestions;
public class palindromicSubstring {

    static int countPalindrome(String s){
        int res=0;

        //for even length
        for(int i=0; i<s.length(); i+=1){
            int left=i-1,right=i;
            
            //We will also count each character as a single palindrome
            res+=1;

            //Now we will check for all even length palindromes
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                left-=1;right+=1;
                res+=1;
            }
        }

        //For odd length
        for(int i=1; i<s.length(); i+=1){
            int left=i-1,right=i+1;

            //Now we will just check for all the odd length palindromes
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                left-=1;right+=1;
                res+=1;
            }
        }

        //Return the result
        return res;
    }
    
    //Main Function
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(countPalindrome(s));
    }
}
