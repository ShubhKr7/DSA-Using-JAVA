/*
 287. Find the Duplicate Number

 Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Example 3:
Input: nums = [3,3,3,3,3]
Output: 3

Constraints:
1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 */

package leetcodeQuestions;

import java.util.HashSet;

public class duplicateNumber {

    public static int duplicate(int []nums){
        HashSet<Integer> list = new HashSet<>();
        for(int i: nums){
            if(list.contains(i)) return i;
            list.add(i);
        }

        return 0;

    }
    

    public static void main(String[] args) {
        int nums[]={1,4,3,5,6,7,1};
        int res=duplicate(nums);
        System.out.println("Res:"+res);
    }
}
