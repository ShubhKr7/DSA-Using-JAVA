/*
 78. Subsets
 Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */

package leetcodeQuestions;
import java.util.*;
public class subsets {

    //Making a solve function
    public static List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        //Calling a recursive function
        recur(res,new ArrayList<>(),nums,0);
        return res;
    }

    //Recursive function to find all the possible subsets
    public static void recur(List<List<Integer>> res, ArrayList<Integer>list, int []nums, int n){
        //Adding list to result list
        res.add(new ArrayList<>(list));
        //Iterating from next element in nums
        for(int i=n; i<nums.length; i+=1){
            //adding that element to the list
            list.add(nums[i]);
            //Making a recursive call for next element
            recur(res,list, nums, i+1);
            //Removing current added element from the list
            list.remove(list.size()-1);
        }
    }

    //Main function
    public static void main(String args[]){
      List<List<Integer>> res = new ArrayList<>();
      int []nums={1,2,3};
      res=solve(nums);
      System.out.println(res);
    }
}
