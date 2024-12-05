/*
 70. Climbing Stairs

 You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:
1 <= n <= 45
 */

package leetcodeQuestions;

public class climbingStairs {
    
    //Function to implement DP Solution
    public static int f(int n){

        //Make a 1-D dp array
        int []dp = new int[n+1];

        //Iterate over the DP array
        for(int i=1; i<=n; i+=1){

            //If number of stairs is one then there are only 1 way to climb the stairs
            if(i==1) dp[i]=1;

            //If number of stairs are two then there are only 2 ways to climb the stairs
            else if(i==2) dp[i]=2;

            //number of ways to climb current stair is number of ways till a stair behind current one
            //plus number of ways to climb the stair one before that
            else dp[i]=dp[i-1]+dp[i-2];
        }

        //Return the last value of DP array
        return dp[n];
    }

    //Recursve solution gives TLE
    public static int recur(int n, int []arr){
        if(n<0) return arr[0]=0;
        if(n==0) return arr[n]=1;
        if(arr[n]!=-1) return arr[n];
        return arr[n]=recur(n-1,arr)+recur(n-2,arr);
    }

    //Main Function
    public static void main(String[] args) {
        int n=1000;
        int arr[]=new int[n+1];
        for(int i=0;i<n+1; i+=1) arr[i]=-1; 
        // System.out.println(f(n));
        System.out.println(recur(n,arr));
    }
}
