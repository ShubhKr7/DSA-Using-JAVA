/*
 209. Minimum Size Subarray Sum

 Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Constraints:
1 <= target <= 10^9
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^4

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */

package leetcodeQuestions;
public class minimumSizeSubarraySum {

    //Function to find the minimum size of subarray
    static int min(int[] nums, int target){
        int res=Integer.MAX_VALUE;
        int sum=0;
        int i=0;

        //Iterate over the array
        for(int j=0;j<nums.length;j++){
            //Add the elements to sum
            sum+=nums[j];
            //Check if sum is greater than or equal to target
            while(sum>=target){
                //Update the result
                res=Math.min(res,j-i+1);
                //Subtract the element from sum
                sum-=nums[i++];
            }
        }
        //Return the result
        return res==Integer.MAX_VALUE?0:res;
    }
    
    //Main Function
    public static void main(String[] args) {
        int []nums={2,3,1,2,4,3};
        int target=7;
        int res=min(nums,target);
        System.out.println("Res:"+res);
    }
}
