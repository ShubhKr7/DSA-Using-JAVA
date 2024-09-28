/*
 88. Merge Sorted Array

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, 
where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

Constraints:
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-10^9 <= nums1[i], nums2[j] <= 10^9
 */

package leetcodeQuestions;
public class mergeSortedArrays {

    //Function to merge two arrays
    public static void merge(int []nums1, int []nums2, int m, int n){

        //If there are no numbers in nums1 then push all elements of nums2 in nums1
        if(m==0) {
            for(int i=0; i<n; i+=1)
                nums1[i]=nums2[i];
            for(int i:nums1) System.out.println(i+" ");
            return;}

        //Take a pointer at the end of nums1
        int last=m+n-1;

        //And two pointers at the ending numbers of both arrays
        m-=1; n-=1;

        //Iterate till any one of the array is exhausted
        while(m>=0&&n>=0){

            //If ending element of nums1 is greater then push that at the end of nums1
            if(nums1[m]>nums2[n]){
                nums1[last]=nums1[m];
                m-=1;}

            //If ending element of nums2 is greater than nums1 then push that at the end of nums1
            else if(nums1[m]<=nums2[n]){
                nums1[last]=nums2[n];
                n-=1;
            }

            //Update last pointer either ways
            last-=1;
        }

        //If there are any elements remaining in nums2 then push them in nums1
        while(n>=0){
            nums1[last]=nums2[n];
            n-=1; last-=1;
        }
        for(int i:nums1)
            System.out.print(i+" ");
    }

    //Main Function
    public static void main(String[] args) {
        // int nums1[]={1,2,3,0,0,0};
        // int nums2[]={2,5,6};
        int nums1[]={2,0};
        int nums2[]={1};
        merge(nums1,nums2,1,1);
    }
}
