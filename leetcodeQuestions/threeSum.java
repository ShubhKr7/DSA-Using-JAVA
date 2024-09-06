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

        //Using a HashSet removes the TLE Error
        Set<List<Integer>>res=new HashSet<>();

        //Sorting the Array
        Arrays.sort(nums);

        //Iterating for each element
        for(int i=0; i<nums.length; i+=1){

            //Skipping for the same elements
            if(i!=0&&nums[i]==nums[i-1]) continue;

            //Taking two more pointers one at last and one from next of current iterating element
            int p=i+1,q=nums.length-1;

            //Running while loop to find next 2 elements of triplet
            while(p<q){

            //If found add to HashSet
            if((nums[i]+nums[p]+nums[q])==0){
                res.add(Arrays.asList(nums[i],nums[p],nums[q]));

                //And increase both pointers by one
                p+=1;q-=1;
            }

            //If the sum is less than 0 then increase the left pointer as it is on smaller side so it can increase the sum value
            else if((nums[i]+nums[p]+nums[q])<0) p+=1;

            //If sum if greater than 0 then decrease the right pointer as it is on the larger side so it can decrease the sum
            else q-=1;
            }
        }

            //Return the answer as an ArrayList
            return new ArrayList<>(res);
        }

    //Main Function
    public static void main(String[] args) {
        int nums[]={-4,0,1,-1,-1,2,3};
        List<List<Integer>>res=calc(nums);
        System.out.println("Res:"+res);
    }
}
