/*
 2221. Find Triangular Sum of an Array

You are given a 0-indexed integer array nums, where nums[i] is a digit between 0 and 9 (inclusive).

The triangular sum of nums is the value of the only element present in nums after the following process terminates:

Let nums comprise of n elements. If n == 1, end the process. Otherwise, create a new 0-indexed integer array newNums of length n - 1.
For each index i, where 0 <= i < n - 1, assign the value of newNums[i] as (nums[i] + nums[i+1]) % 10, where % denotes modulo operator.
Replace the array nums with newNums.
Repeat the entire process starting from step 1.
Return the triangular sum of nums.

Example 1:
Input: nums = [1,2,3,4,5]
Output: 8
Explanation:
The above diagram depicts the process from which we obtain the triangular sum of the array.

Example 2:
Input: nums = [5]
Output: 5
Explanation:
Since there is only one element in nums, the triangular sum is the value of that element itself.

Constraints:
1 <= nums.length <= 1000
0 <= nums[i] <= 9
 */

package leetcodeQuestions;

public class findTriangularSumOfAnArray {

    //Function to find the triangular sum of an array
    //Time Complexity: O(n^2)
    static int triangularSum(int[] nums) {
        int n = nums.length;

        //Iterate until the length of the array is greater than 1
        while (n > 1) {

            //Find sum at that particular level
            for (int i = 0; i < n - 1; i += 1) {

                //Find the sum of the current and next element and take modulo 10
                //to get the new value of the current element
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }

            //Reduce the size of the array by 1
            //as we have already calculated the sum of the last element
            n -= 1;
        }

        //Return the first element of the array as the triangular sum
        //as it will be the only element left in the array
        return nums[0];
    }

    //Main Function
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(triangularSum(nums));
    }
}
