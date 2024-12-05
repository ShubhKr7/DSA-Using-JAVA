/*
 198. House Robber

 You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 400
 */

package leetcodeQuestions;

public class houseRobber {

    //Function to calculate max value
    public static int fun(int []nums){

        //Recursive approach
        // return recur(nums,0,0);

        //Using DP
        //If array length is 1 the return the first element
        if(nums.length<=1) return nums[0];

        //Else create a DP array
        int dp[]=new int[nums.length];

        //Initialize the first two element of dp array
        dp[0]=nums[0]; dp[1]=Math.max(nums[0],nums[1]);

        //If nums.length>2 then do further calculations
        if(nums.length>2){

        //Iterate through the nums array
        for(int i=2; i<nums.length; i+=1){

            //There are 2 ways to reach to a house
            //Either by robbing the house before the previous one
            //Or by not robbing the house 
            //We will use the maximum of both the values and then store it at that position in dp array
            //This way we get the maximum amount robbed till that particular house
           dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]);
        }}

        //Now return the last element of dp array which store the maximum amount robbed till last house
        return dp[nums.length-1];
      }
    
    //Recursive approach gives TLE
      public static int recur(int []nums, int i, int sum){
        if(i>=nums.length) return sum;
        return Math.max(recur(nums,i+2,sum+nums[i]), recur(nums, i+1, sum));
      }
    
      //Main function
      public static void main(String args[]){
        // int nums[]={114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        int nums[]={1,2,3,1};
        // int []nums={2,1};
        // int nums[]={0};
        System.out.println(fun(nums));
      }
}
