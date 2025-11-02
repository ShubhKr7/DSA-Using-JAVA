/*
 214. Shortest Palindrome

You are given a string s. You can convert s to a palindrome by adding characters in front of it.

Return the shortest palindrome you can find by performing this transformation.

Example 1:
Input: s = "aacecaaa"
Output: "aaacecaaa"

Example 2:
Input: s = "abcd"
Output: "dcbabcd"

Constraints:
0 <= s.length <= 5 * 10^4
s consists of lowercase English letters only.
 */

package leetcodeQuestions;
public class shortestPalindrome {
    
    
    public static String palindrome(String s){
        String pal=longestString(s);
        String res=s;
        System.out.println(s.indexOf(pal)==0);
        if(s.indexOf(pal)==0){
            int i=pal.length();
            while(i<s.length()){
                res=s.charAt(i)+res;
                i+=1;
            }
        }
        else{
            int i=1;
            while(s.charAt(i)==s.charAt(i-1)) i+=1;
            while(i<s.length()){
                res=s.charAt(i)+res;
                i+=1;
            }
        }
        System.out.println("Longest Palindrome: "+pal);
        return res;
       
    }

    static String longestString(String s){
        if(s.length()==1) return s;
        int x=0,y=0,size=0;

        //For even length
        for(int i=1; i<s.length(); i+=1){
            int curr=0,left=i-1,right=i;
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                curr+=2;
                left-=1;right+=1;
                if(curr>size){
                    size=curr; x=left+1;y=right-1;
                }
            }
        }

        //For odd length
        for(int i=1; i<s.length(); i+=1){
            int curr=1,left=i-1,right=i+1;
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                curr+=2;
                left-=1;right+=1;
                if(curr>size){
                    size=curr; x=left+1;y=right-1;
                }
            }
        }
        return s.substring(x, y+1);
    }

    public static void main(String[] args) {
        // String s="aacecaaa";
        // String s="abcd";
        // String s="abbc";
        String s="ababbbabbaba";
        // String s="aabba";
        String res = palindrome(s);
        // System.out.println("ababbabbbabababbbabbaba".equals(res));
        // System.out.println(res.equals("ababbabbbababbbabbaba"));
        System.out.println(res);
    }
}
