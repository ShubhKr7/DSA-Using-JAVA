/*
 15. 3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that 
i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 */

package leetcodeQuestions;
import java.util.*;
public class threeSum {
    
    public static List<List<Integer>> calc(int []nums){
        Set<List<Integer>>res=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i+=1){
            if(i!=0&&nums[i]==nums[i-1]) continue;
            int p=i+1,q=nums.length-1;
            if(i==p||p==q) break;
            while(p<q){
            if((nums[i]+nums[p]+nums[q])==0){
                // ArrayList<Integer> list = new ArrayList<>();
                // list.add(nums[i]);
                // list.add(nums[q]);
                // list.add(nums[p]);
                // if(!res.contains(list))
                res.add(Arrays.asList(nums[i],nums[p],nums[q]));
                p+=1;q-=1;
            }
            else if((nums[i]+nums[p]+nums[q])<0) p+=1;
            else q-=1;
            }
        }
            return new ArrayList<>(res);
        }

    public static void main(String[] args) {
        int nums[]={-4,0,1,-1,-1,2,3};
        List<List<Integer>>res=calc(nums);
        System.out.println("Res:"+res);
    }
}
