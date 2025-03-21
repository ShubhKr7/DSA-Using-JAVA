/*
 91. Decode Ways

You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:

"1" -> 'A'
"2" -> 'B'
...
"25" -> 'Y'
"26" -> 'Z'

However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").

For example, "11106" can be decoded into:

"AAJF" with the grouping (1, 1, 10, 6)
"KJF" with the grouping (11, 10, 6)
The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
Note: there may be strings that are impossible to decode.

Given a string s containing only digits, return the number of ways to decode it. If the entire string cannot be decoded in any valid way, return 0.

The test cases are generated so that the answer fits in a 32-bit integer.

Example 1:
Input: s = "12"
Output: 2
Explanation:
"12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: s = "226"
Output: 3
Explanation:
"226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Example 3:
Input: s = "06"
Output: 0
Explanation:
"06" cannot be mapped to "F" because of the leading zero ("6" is different from "06"). In this case, the string is not a valid encoding, so return 0.

Constraints:
1 <= s.length <= 100
s contains only digits and may contain leading zero(s).
 */

package leetcodeQuestions;
import java.util.Arrays;

public class decodeWays {

    //Function to implement memoization
    static int solve(String s, int i, int []memo){
        if(i==s.length()) return memo[i]=1;
        if(memo[i]!=-1) return memo[i];
        if(s.charAt(i)=='0') return memo[i]=0;
        int res=solve(s,i+1,memo);
        if(i+1<s.length())
        if(s.charAt(i)=='1'||(s.charAt(i)=='2'&&s.charAt(i+1)<'7'))
            res+=solve(s,i+2,memo);
    return memo[i]=res;
    }

    //Function to decode the string
    static int decode(String s){
        if(s.charAt(0)=='0') return 0;

        //Memoization solution
        // int []memo=new int[s.length()+1];
        // Arrays.fill(memo,-1);
        // return solve(s,0,memo);

        //DP solution  (Bottom up approach)
        int []dp=new int[s.length()+1];
        Arrays.fill(dp, 0);
        dp[s.length()]=1;
        for(int i=s.length()-1;i>=0;i-=1){
            if(s.charAt(i)=='0') dp[i]=0;
            else{
                dp[i]=dp[i+1];
                if(i+1<s.length())
                if(s.charAt(i)=='1'||(s.charAt(i)=='2'&&s.charAt(i+1)<'7'))
                    dp[i]+=dp[i+2];
            }
        }
        return dp[0];
    }

    //Main function
    public static void main(String[] args) {
        String s="2261";
        //2 26 1, 22 6 1, 2 2 6 1
        // String s="301";
        System.out.println(decode(s));
        
    }
}
