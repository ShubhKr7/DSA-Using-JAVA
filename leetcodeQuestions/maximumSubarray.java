/*
 53. Maximum Subarray

 Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */

package leetcodeQuestions;

public class maximumSubarray {
    

    public static int calc(int []nums){

        //Two variables one to calculate sum and other to store max sum till now
        int sum=nums[0],max=nums[0];

        //Iterating over the array
        for(int i=1; i<nums.length; i+=1){

           //If the sum is negative then we will discard it and replace it with current element
            if(sum>=0) sum+=nums[i]; 
            else sum=nums[i];
            
            //now we will store the max sum till now into max
            max=Math.max(sum,max);
        }

        //Returning maximum sum possible
        return max;
    }

    public static void main(String[] args) {
        // int nums[]={-2,1,-3,4,-1,2,1,-5,4};
        // int []nums={5,4,-1,7,8};
        // int []nums={0};
        int []nums={-2,-3,-4,-1};
        int res=calc(nums);
        System.out.println("Res:"+res);
    }
}

