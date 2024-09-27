/*
 136. Single Number

Given a non-empty array of integers nums, every element appears twice except for one. 
Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1

Constraints:
1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
 */

package leetcodeQuestions;
import java.util.*;
public class singleNumber {

    public static int calc(int []nums){

        //Create a hashmap to store each number and its frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        //Iterate over the array
        for(int i:nums){

            //If the number is already there then update its frequency count by 1
            if(map.containsKey(i)) {map.put(i, map.get(i)+1);}

            //Else add the number to the hashmap
            else map.put(i, 1);
        }

        //Iterating over the hashmap to check for number with frequency 1
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){

            //If frequency is 1 then return that number
            if(entry.getValue()==1) return entry.getKey();
        }
        return -1;
    }

    //Main function
    public static void main(String[] args) {
        int nums[]={4,1,2,1,2};
        int res=calc(nums);
        System.out.println("Res:"+res);
    }
}
