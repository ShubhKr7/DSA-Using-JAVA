/*
 35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4

Constraints:
1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums contains distinct values sorted in ascending order.
-10^4 <= target <= 10^4
 */

package leetcodeQuestions;

public class searchInsertPosition {
    
    //Function to find the position of the number
    public static int calc(int []nums, int target){

        //Take three pointers one at start one at last and one at middle
        int s=0,l=nums.length-1,mid=(s+l)/2;

        //Perform binary search to find the location of that number in O(log n)
        while(s<=l){
            mid=(s+l)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) l=mid-1;
            else if(nums[mid]<target) s=mid+1;
        }

        //if the middle element is greater than target then the target will be placed right at this spot
        if(nums[mid]>target)
        return mid;

        //Else the target will be placed a spot before middle
        else return mid+1;
    }


    //Main Function
    public static void main(String[] args) {
        int nums[]={1,3,5,6};
        int target =4;
        int res=calc(nums,target);
        System.out.println("Res:"+res);
    }
}
