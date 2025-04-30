/*
 44. Wildcard Matching

 Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:
Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

Constraints:
0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.
 */

package leetcodeQuestions;
public class wildcardMatching{

    public static boolean isMatch(String s, String p) {
        Boolean dp[][]=new Boolean[s.length()][p.length()];
        return f(s.length()-1,p.length()-1,s,p,dp);
    }

    static boolean f(int i, int j, String s, String p, Boolean [][]dp){
        if(i<0&&j<0) return true;
        if(j<0&&i>=0) return false;

        if(i<0&&j>=0){
            for(int ii=0;ii<=j;ii+=1)
                if(p.charAt(ii)!='*')
                    return false;
                return true;}

        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
            return dp[i][j]=f(i-1,j-1,s,p,dp);
        if(p.charAt(j)=='*')
            return dp[i][j]=f(i-1,j,s,p,dp) || f(i,j-1,s,p,dp);
        return false;
    }


    public static void main(String[] args) {
        String s = "aa";
        String p = "a";
        System.out.println(isMatch(s, p)); // Output: false

        s = "aa";
        p = "*";
        System.out.println(isMatch(s, p)); // Output: true

        s = "cb";
        p = "?a";
        System.out.println(isMatch(s, p)); // Output: false

        s = "adceb";
        p = "*a*b";
        System.out.println(isMatch(s, p)); // Output: true

        s = "acdcb";
        p = "a*c?b";
        System.out.println(isMatch(s, p)); // Output: false
    }
}