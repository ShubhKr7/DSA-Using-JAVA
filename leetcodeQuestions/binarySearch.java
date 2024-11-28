/*
 704. Binary Search

 Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. 
If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

Constraints:
1 <= nums.length <= 10^4
-10^4 < nums[i], target < 10^4
All the integers in nums are unique.
nums is sorted in ascending order.
 */

package leetcodeQuestions;

public class binarySearch {
    
    //Function to implement binary search 
    public static int binary(int []nums, int target){

        //Taking three pointers
        int s=0,l=nums.length-1,mid=(s+l)/2;

        //Looping through the array
        while(s<=l){

            if(nums[mid]==target) 
            //Return index if element found
            return mid;

            else if(nums[mid]>target) l=mid-1;

            else s=mid+1;

            //Updating mid
            mid=(s+l)/2;
        }

        //Return -1 if element not found
        return -1;
    }

    //Main function
    public static void main(String[] args) {
        int nums[]={-1,0,3,5,9,12};
        int target=90;
        System.out.println(binary(nums, target));
    }
}
