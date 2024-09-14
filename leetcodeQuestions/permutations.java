/*
 46. Permutations

Given an array nums of distinct integers, return all the possible permutations.
You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]
 */

package leetcodeQuestions;
import java.util.*;
public class permutations {
    
    //Function to calculate permutations
    public static List<List<Integer>> permute(int []nums){
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length==0) return res;

        //Calling a recursive function
        recur(res,new ArrayList<>(),new HashSet<>(),nums);
        return res;
    }

    //Returning recursive function
    //We added a set as well coz finding element in a HashSet is faster than finding it in ArrayList
    public static void recur(List<List<Integer>> res,ArrayList<Integer>list, HashSet<Integer> set, int []nums){
       
        //If list contains as many elements as nums then add list to res
        if(list.size()==nums.length) res.add(new ArrayList<>(list));

        else{

        //Iterating for each element in array (imagine creating a new node in a tree at each iteration)
        //Iterate from start of array each time
        for(int i=0; i<nums.length; i+=1){

            //If element is already added then skip it to avoid combinations like [1,2,2],[1,1,2] etc
            //This will take O(1) while using arraylist it will take O(n)
            if(set.contains(nums[i])) continue;

            //Add element to the set and list both
            set.add(nums[i]);
            list.add(nums[i]);

            //Recursive call
            recur(res,list,set,nums);

            //Remove elements while backtracking
            //First from set as it is depended on list due to no particular order maintained during insertion order
            set.remove(list.get(list.size()-1));
            list.remove(list.size()-1);
        }
        }
    } 

    //main function
    public static void main(String[] args) {
        int nums[]={1,2,3};
        List<List<Integer>> res=permute(nums);

        //Displaying result
        System.out.println("Res:"+res);
    }
}
