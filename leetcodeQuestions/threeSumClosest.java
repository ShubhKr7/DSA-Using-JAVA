/*
16. 3Sum Closest

Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:
Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

Constraints:
3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-10^4 <= target <= 10^4
 */

package leetcodeQuestions;
import java.util.Arrays;
public class threeSumClosest {

    //Find the closest sum from target
    public static int closest(int []nums, int target){

        //Take two variables to store difference and to store the result
        int diff=Integer.MAX_VALUE,res=0;

        //Loop through the array for first number
        for(int i=0; i<nums.length ;i+=1){

            //Again loop through the array for second number
            for(int j=i+1; j<nums.length-2; j+=1){

                //Again loop through the array to find the third number
                for(int k=j+1; k<nums.length-1; k+=1){

                    //Find sum
                    int sum=nums[i]+nums[j]+nums[k];

                    //Find the absolute value of the difference from the sum and store minimum value
                    if(Math.abs(target-sum)<diff){

                            //Update res
                            res=sum;

                            //Update diff
                            diff=Math.abs(target-sum);
                        }}}}

        //Return the result
        return res;
    }
    
    //Main function
    public static void main(String[] args) {
        int []nums = {-1,2,1,-4};
        // int []nums={0,0,0};
        int target = 1;

        // int []nums={4,0,5,-5,3,3,0,-4,-5};
        // int target=-2;

        System.out.println("Res:"+closest(nums,target));
    }
}
