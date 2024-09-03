/*
 These are not leetcode quesitons
 Just trying random recursion quesitons on my own!
 */
package leetcodeQuestions;

public class longestSubsequence {
    
    //Function to find the longest subsequence between 2 strings
    public static int recur(String s1, String s2, int i1, int i2){
        if(i1==s1.length()||i2==s2.length()) return 0;
        else if(s1.charAt(i1)==s2.charAt(i2))
            {
            return 1+recur(s1,s2,i1+1,i2+1);
        }
        else 
            return Math.max(recur(s1,s2,i1+1,i2),recur(s1,s2,i1,i2+1));
    }

    //To find number of paths in a maze/matrix/checkboard
    //from bottom right to top left
    public static int numOfPaths(int m, int n){
        if(m==0&&n==0) return 0;
        else if(m==0||n==0) return 1;
        else
            return numOfPaths(m-1, n) + numOfPaths(m, n-1);
    }

    public static void main(String[] args) {
        // String s1="ABC";
        // String s2="ACB";
        // int r=recur(s1,s2,0,0);
        int m=2,n=2;
        int r=numOfPaths(m, n);
        System.out.println("Res:"+r);
    }
}
