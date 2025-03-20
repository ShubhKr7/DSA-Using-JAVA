/*
 322. Coin Change

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0

Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 2^31 - 1
0 <= amount <= 10^4
 */

package leetcodeQuestions;
import java.util.Arrays;

public class coinChange {
    static int fun(int []coins, int amount){
        //This approach is based on the greedy algorithm
        // int i=coins.length-1,res=0;
        // if(amount==0) return 0;
        // Arrays.sort(coins);
        // while(i>=0&&amount>0){
        //     while(coins[i]<=amount){
        //         amount-=coins[i];
        //         res+=1;
        //     }
        //     i-=1;
        // }
        // if(amount==0)
        // return res;
        // return -1;

        //This approach is based on the DP
        int dp[]=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i+=1){
            for(int j=0;j<coins.length;j+=1){
                if(coins[j]<=i){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        if(dp[amount]>amount) return -1;
        else return dp[amount];
    }
    
    //Main Function
    public static void main(String[] args) {
        // int[] coins = new int[]{1, 2, 5};
        // int []coins={2,5,10,1};
        int []coins={186,419,83,408};
        int amount = 6249;
        System.out.println(fun(coins, amount));
    }
}
