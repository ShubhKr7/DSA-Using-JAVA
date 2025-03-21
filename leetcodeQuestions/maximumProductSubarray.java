/*
 152. Maximum Product Subarray

 Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Constraints:
1 <= nums.length <= 2 * 10^4
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
 */

package leetcodeQuestions;
public class maximumProductSubarray {

    //Function to find the maximum product of a subarray
    //Time complexity is O(n) where n is the length of the array nums
    static int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];
        int currMax=1,currMin=1,res=-11;
        for(int i: nums) res=Math.max(res,i);
        for(int i:nums){
            int temp = currMax * i;
            currMax = Math.max(temp, Math.max(currMin * i, i));
            currMin = Math.min(temp, Math.min(currMin * i, i));
            res = Math.max(res, currMax);
        }
        return res;
    }
    
    //Main function
    public static void main(String[] args) {
        int nums[]={2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
}
