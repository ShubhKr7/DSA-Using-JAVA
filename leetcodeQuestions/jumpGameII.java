/*
 45. Jump Game II

You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2

Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
 */

package leetcodeQuestions;
public class jumpGameII {
    
    //Function to calculate the number of jumps
    public static int jump(int[] nums) {

        //If there is only single element in the array then return 0 as no jumps are required
        if(nums.length==1) return 0;

        //Take three variables
        int near=0,far=0,jumps=0;

        //Loop through the array till the far variable becomes the last element or greater than that
        while(far<nums.length-1){

            //Make a new farthest pointer
            int farthest=0;

            //Loop through the array between the near and far pointers inclusive
            for(int i=near; i<=far; i+=1)

                //Find the farhtest jumps we can make from a single point in the range
                farthest=Math.max(farthest, i+nums[i]);

            //When all the possibilities are calculated within the range update the near and far pointers
            near=far+1;
            far=farthest;

            //Update the jumps by 1 as we will make a jump in each iteration 
            jumps+=1;
        }

        //Return the number of jumps
        return jumps;
    }

    public static void main(String[] args) {
        int nums[]={2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
