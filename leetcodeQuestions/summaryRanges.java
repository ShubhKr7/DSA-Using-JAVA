/*
 228. Summary Ranges

 You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b

Example 1:
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

Example 2:
Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"

Constraints:
0 <= nums.length <= 20
-2^31 <= nums[i] <= 2^31 - 1
All the values of nums are unique.
nums is sorted in ascending order.
 */

package leetcodeQuestions;
import java.util.ArrayList;

public class summaryRanges {
    
    //Function to find the ranges
    static ArrayList<String> ranges(int []nums){
        ArrayList<String> result = new ArrayList<>();
        if (nums.length == 0) return result;

        //Start with first element
        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {

            //If we have reached end of array or found a number that is not consecutive
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {

                //Check if the start is same as the previous element
                //If yes, add the start to result
                if (start == nums[i - 1]) 
                    result.add(String.valueOf(start));
                
                //Otherwise add the range from start to previous element
                else 
                    result.add(start + "->" + nums[i - 1]);
                
                //If we have not reached end of array, update start
                if (i < nums.length) start = nums[i];
            }
        }

        //Return the result
        return result;
    }

    //Main function
    public static void main(String[] args) {
        int nums[]={ 0,1,2,4,5,7};
        // int nums[]={0,2,3,4,6,8,9};
        System.out.println(ranges(nums));
    }
}
