/*
 39. Combination Sum
 Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []
 */

package leetcodeQuestions;
import java.util.*;
public class combinationSum {
    
    public static List<List<Integer>> com(int []candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        recur(res, new ArrayList<>(),candidates, target, 0);
        return res;
    }

    public static void recur(List<List<Integer>> res, ArrayList<Integer>list, int []candidates, int sum, int n){
         if(sum==0) {
            res.add(new ArrayList<>(list));
            return;
         }
         else if(n==candidates.length) { return;}
         else if(candidates[n]>sum) recur(res,list,candidates,sum,n+1);
         else{
             list.add(candidates[n]);
             recur(res,list,candidates,sum-candidates[n],n);
             list.remove(list.size()-1);
             recur(res,list,candidates,sum,n+1);
         }
    }

    public static void main(String[] args) {
        int candidates[]={2,3,5}; int target = 8;
        List<List<Integer>> res= com(candidates,target);
        System.out.println("Res:"+res);
    }
}
