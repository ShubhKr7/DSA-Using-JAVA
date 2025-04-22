/*
 34. Find First and Last Position of Element in Sorted Array

 Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non-decreasing array.
-10^9 <= target <= 10^9
 */

package leetcodeQuestions;

public class findFirstAndLastPositionOfAnElementInASortedArray {

    static int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums.length == 0)
            return res;

        int start = 0, last = nums.length - 1;

        while (start <= nums.length - 1 && nums[start] <= target) {
            if (nums[start] == target) {
                res[0] = start;
                break;
            }
            start += 1;
        }

        while (last >= 0 && nums[last] >= target) {
            if (nums[last] == target) {
                res[1] = last;
                break;
            }
            last -= 1;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println("First and last position of " + target + " are: [" + result[0] + ", " + result[1] + "]");
    }
}
