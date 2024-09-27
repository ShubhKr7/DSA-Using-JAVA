/*
 189. Rotate Array

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Constraints:
1 <= nums.length <= 10^5
-2^31 <= nums[i] <= 2^31 - 1
0 <= k <= 10^5
 */

package leetcodeQuestions;
public class rotateArray {
    
    public static int[] rotate(int []nums, int k){

        //Mod k upto the length of array
        k%=nums.length;
        
        //Rotating the whole array
        int l=0,r=nums.length-1;
        while(l<r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l+=1;r-=1;
        }

        //Rotating the first k elements
        l=0;r=k-1;
        while(l<r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l+=1;r-=1;
        }

        //Rotating the remaining array
        l=k;r=nums.length-1;
        while(l<r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l+=1;r-=1;
        }

        //Returned the updated array
        return nums;
    }

    //Main Function
    public static void main(String[] args) {
        // int nums[]={1,2,3,4,5,6,7};
        // int k=3;
        // int nums[]={-1,-100,3,99};
        // int k=2;
        int nums[]={-1};
        int k=2;
        int res[]=rotate(nums,k);
        for(int i:res)
        System.out.print(i+" ");
    }
}
