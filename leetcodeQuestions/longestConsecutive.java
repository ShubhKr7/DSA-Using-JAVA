/*
 128. Longest Consecutive Sequence

 Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 */

package leetcodeQuestions;
import java.util.*;

public class longestConsecutive {
    
    //Function to solve the question
    public static int solve(int []nums){

        //If null array is passed then return 0
        if(nums.length==0) return 0;

        //Res to store result and max to store maximum consecutive sequence
        int res=0,max=0;

        //HashSet to store and fetch elements
        HashSet<Integer> list=new HashSet<>();
        for(int i:nums) list.add(i);

        //Iterating over the HashSet
        for(int i:list){

            //If current element is the starting element
            if(!list.contains(i-1)) {

                //increase the length by 1
                res+=1;

                //Now repeat finding consecutive elements and increase the length by 1 in each iteration
                while(list.contains(i+res)) res+=1;
            }

            //Store the mnaximum sequence after each if iteration
            max=Math.max(max,res);

            //Reset the length to 0
            res=0;
        }

        //Return result
        return max;
    }

    //Main function
    public static void main(String[] args) {
        int nums[]={0,0,-1,-2,-4,2,3,4,5,6};
        // int nums[]={100,4,200,101,3,2};
        // int nums[]={100,4,200,1,3,2};
        // int nums[]={0,3,7,2,5,8,4,6,0,1};
        int res=solve(nums);
        System.out.println("Res:"+res);
    }
}
