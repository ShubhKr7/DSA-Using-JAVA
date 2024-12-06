/*
 219. Contains Duplicate II

 Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

Constraints:
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
0 <= k <= 10^5
 */

package leetcodeQuestions;
import java.util.*;
public class containsDuplicateII {

    //Function to find the result
    static boolean fun(int []nums, int k){

        //Create a HashMap to store an element and its index
        HashMap<Integer,Integer> map = new HashMap<>();

        //Loop through the array
        for(int i=0; i<nums.length; i+=1){

            //Find if a particular element already exists or not
            if(map.containsKey(nums[i]))

                //Now check if the difference is less than or equal to k or not
                if(i-map.get(nums[i])<=k) 
                
                //If so then reutrn true
                return true;

            //Now add that elements updated value
            map.put(nums[i],i);
        }

        //If not found any such element then return false
        return false;
    }
    
    //Main function
    public static void main(String[] args) {
        // int nums[]={1,2,3,1};
        // int k=3;

        // int nums[]={1,2,3,1,2,3};
        // int k=2;

        // int nums[]={1,0,1,1};
        // int k=1;

        int nums[]={99,99};
        int k=2;
        System.out.println(fun(nums,k));
    }
}
