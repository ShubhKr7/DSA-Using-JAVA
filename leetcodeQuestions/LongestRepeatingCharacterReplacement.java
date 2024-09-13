/*
 424. Longest Repeating Character Replacement

 You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. 
 You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 */

package leetcodeQuestions;

public class LongestRepeatingCharacterReplacement {
    
    public static int replace(String s, int k){
        if(s.length()==1) return 1;
        int res=0,right=1,left=0,K=k;
        while(right<s.length()){
            if(s.charAt(left)!=s.charAt(right)&&K==0){
                res=Math.max(res,right-left);
                K=k;
                left=right; right+=1;
            }
            else if(s.charAt(left)!=s.charAt(right)&&K>0){
                K-=1;
                right+=1;
            }
            else right+=1;
            res=Math.max(res,right-left);
        }
        K=k;
        right=s.length()-1;left=right-1;
        while(left>=0){
            if(s.charAt(left)!=s.charAt(right)&&k==0){
                res=Math.max(res,right-left);
                k=K;
                right=left; left-=1;
            }
           else if(left==0&&s.charAt(left)!=s.charAt(right)&&k>0){res=Math.max(res,right-left+1);k-=1;}

            else if(s.charAt(left)!=s.charAt(right)&&k>0){
                res=Math.max(res,right-left);
                k-=1;
                left-=1;
            }
            else {left-=1;
            res=Math.max(res,right-left);}
        }

        return res;
    }

    public static void main(String[] args) {
        String a="ABBBA";
        int k=1;
        int res=replace(a,k);
        System.out.println("Res:"+res);
    }
}
