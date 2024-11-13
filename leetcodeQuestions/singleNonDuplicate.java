/*
540. Single Element in a Sorted Array

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Example 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10

Constraints:
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5
 */

package leetcodeQuestions;

public class singleNonDuplicate {
    
    //Function to find non duplicate element
    public static int NonDuplicate(int []nums){

        //If array is of only length 1 then return that number
        if(nums.length==1) return nums[0];

        //Otherwise iterate through the array
        for(int i=1; i<nums.length; i+=2)

            //If at any point the current number is not equal to previous then return that previous number
            if(nums[i]!=nums[i-1]) return nums[i-1];

        //If end of array reached then return the last number
        return nums[nums.length-1];
    }

    //Main function
    public static void main(String[] args) {
        // int nums[]={3,3,7,7,10,11,11};
        // int nums[]={1};
        int nums[]={1,1,2,2,3};

        System.out.println("Res:"+NonDuplicate(nums));
    }
}
