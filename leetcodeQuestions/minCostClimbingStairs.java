/*
 746. Min Cost Climbing Stairs

 You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

Example 1:
Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.

Example 2:
Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.

Constraints:
2 <= cost.length <= 1000
0 <= cost[i] <= 999
 */

package leetcodeQuestions;
public class minCostClimbingStairs {

    //Function to find the minimum cost for climbing the stairs 
    static int Cost(int[] cost) {

        //DP array to store the min cost of climbing the stairs upto the ith stair
        int dp[]=new int[cost.length];

        //Base case
        dp[0]=cost[0]; dp[1]=cost[1];

        //Iterating through the cost array and storing the min cost of climbing the stairs upto the ith stair
        for(int i=2;i<cost.length;i+=1)

            //The min cost of climbing the ith stair is the cost of the ith stair plus the min of the cost of climbing the (i-1)th stair and the (i-2)th stair
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);

        //Returning the min cost of climbing the last stair or the second last stair
        return Math.min(dp[dp.length-1],dp[dp.length-2]);
    }

    //Main Function
    public static void main(String[] args) {
        // int[] cost = new int[]{10, 15, 20};
        // int cost[]={1,100,1,1,1,100,1,1,100,1};
        int []cost={0,1,1,1};
        System.out.println(Cost(cost));
    }
}