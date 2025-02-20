/*
 215. Kth Largest Element in an Array

 Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:
1 <= k <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
 */

package leetcodeQuestions;
import java.util.Collections;
import java.util.PriorityQueue;
public class kthLargestElementInAnArray {
    
    //Function to find the kth largest element
    public static int largest(int []nums, int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums) pq.offer(i);
        while(k>1) {pq.poll();k-=1;}
        return pq.poll();
    }

    //Main Function
    public static void main(String[] args) {
        int []nums={3,2,1,5,6,4};
        int k=2;
        System.out.println(largest(nums,k));
    }
}
