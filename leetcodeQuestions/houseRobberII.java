/*
 213. House Robber II

 You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

Example 2:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 3:
Input: nums = [1,2,3]
Output: 3

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 1000
 */

package leetcodeQuestions;

public class houseRobberII {

    //Function to find max loot from the original array
    public static int fun(int []nums){

        //If there is only 1 element then return it as max loot
        if(nums.length==1) return nums[0];

        //If you loot the first house then you can't loot the last house
        //If you loot the last house then you can't loot the first house
        //So we will find max loot while considering each scenario each time

        //Make an array without first house
        int []skipFirst=new int[nums.length-1];

        //Make an array without last house
        int []skipLast=new int[nums.length-1];

        //Store the elements likewise in each array
        for(int i=0; i<nums.length; i+=1){
            if(i>0) skipFirst[i-1]=nums[i];
            if(i<nums.length-1) skipLast[i]=nums[i];
        }

        //Return the max loot from either of the arrays
        return Math.max(calc(skipFirst),calc(skipLast));
    }

    //Function to find the maximum loot in an array
    public static int calc(int []nums){

        //If array is of single length then return that element as max loot
        if(nums.length==1) return nums[0];

        //Make a dp array to store max loot till a particular house
        int dp[]=new int[nums.length];

        //Max loot till first house if that house itself
        dp[0]=nums[0];

        //Max loot till second house if either the loot of first house or second house
        dp[1]=Math.max(nums[0],nums[1]);

        //If there are more than 2 houses then loop through the array
        if(nums.length>2){
            for(int i=2; i<nums.length; i+=1){

                //if the loot from a house before than last is more than the loot till last house then update the dp array likewise
                dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
            }
        }

        //Return the last element of dp array
        return dp[nums.length-1];
    }
    

    //Main function
    public static void main(String[] args) {
        // int nums[]={1,2,3,1};
        int []nums={2,3,2};
        System.out.println(fun(nums));
    }
}
