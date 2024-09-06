/*
 90. Subsets II

Given an integer array nums that may contain duplicates, return all possible 
subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
 */

package leetcodeQuestions;
import java.util.*;
public class subsetsII {
    
    //Function to calculate result
    public static List<List<Integer>> subsets(int []nums){

        //ArrayList to store result
         List<List<Integer>> res=new ArrayList<>();

         //Calling recursive function
         recur(res,new ArrayList<>(), nums,0);

         return res;
    }

    //Recursive Function
    public static void recur(List<List<Integer>> res, ArrayList<Integer>list, int [] nums, int k){

        //If list already does not exist then add list to res
        if(!res.contains(list))
        res.add(new ArrayList<>(list));

        //Iterate for each element from the kth index
        for(int i=k; i<nums.length; i+=1){

            //Add element to list
            list.add(nums[i]);

            //Recursive call
            recur(res,list,nums,i+1);

            //Remove element while backtracking
            list.remove(list.size()-1);
        }
    }

    //Main Function
    public static void main(String[] args) {
        int nums[]={1,2,2};
        List<List<Integer>> res=subsets(nums);
        System.out.println("Res:"+res);
    }
}
