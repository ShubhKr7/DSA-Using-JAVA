/*
 55. Jump Game

 You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

Constraints:
1 <= nums.length <= 10^4
0 <= nums[i] <= 10^5
 */

package leetcodeQuestions;

public class jumpGame {
    
    //Function to find the jumps are possible or not
    static boolean canJump(int []nums){

        //If there is only 1 element in the array then we are already at the end of the array so return true
        if(nums.length==1) return true;

        //Take the last index of the array
        int l=nums.length-1;

        //Let that index be the goal where we want to reach
        int goal=l;

        //Now loop backwards through the array
        for(int i=l-1; i>=0; i-=1){

            //Check if the value at current index is enough to reach to the goal index or not
            if(nums[i]>=goal-i) 
            
            //If yes then this current index is the new goal index where we have to reach from the remaining array
            goal=i;
        }

        //Now check is the goal index 0 or not if yes then we have reached to the start of the array from the last so yes there exists a possibility where we do get enough jumps to reach the end of array from the start
        return goal==0;
    }

    //Main function
    public static void main(String[] args) {
        // int nums[]={3,2,1,0,4};
        // int []nums={2,3,1,1,4};
        int []nums={2,5,0,0};
        // int nums[]={2,0,0};
        // int nums[]={0,1};
        // int nums[]={0,0,0};
        // int []nums={0};
        System.out.println(canJump(nums));
    }
}
