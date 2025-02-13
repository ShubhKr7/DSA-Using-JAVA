/*
 33. Search in Rotated Sorted Array  

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 

For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1

Constraints:
1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-10^4 <= target <= 10^4
 */

package leetcodeQuestions;

public class searchInRotatedSortedArray {

    //Function to find if target exists in nums or not
    public static int f(int[] nums, int target) {

        //Take three pointers to apply binary seach
        int start=0,last=nums.length-1,mid=(last+start)/2;

        //If array is sorted then apply binary seach directly
        if(nums[start]<target&&nums[last]>target){
            while(start<=last){

                //Update mid
                mid=(last+start)/2;

                //If found then return index
                if(nums[mid]==target) return mid;

                //Otherwise update pointers likewise
                else if(nums[mid]<target) start=mid+1;
                else last=mid-1;
            }

            //If not found then return -1
            return -1;
        }

        //Else loop from both sides of the array until the element is found or not
        while(start<=last){

            //Check if target is found or not. If found then return the index
            if(nums[start]==target) return start;
            if(nums[last]==target) return last;

            //Update pointers
            start+=1; last-=1;
        }

        //If not return -1
        return -1;
    }
    
        //Main Function
        public static void main(String args[]){
            int nums[]={1,2,3,4,5,6,7,8,9,10};
            int k=3;
            System.out.println(f(nums,k));
          }
    }
