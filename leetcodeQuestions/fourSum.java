/*
18. 4Sum

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that: 0 <= a, b, c, d < n where a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
*/

package leetcodeQuestions;
import java.util.*;
public class fourSum {
    
    public static List<List<Integer>> quad(int []nums, int target){
        List<List<Integer>> res= new ArrayList<>();
        if(nums.length<4) return res;
        Arrays.sort(nums);
        int p=2,q=nums.length-1;
        for(int i=0; i<nums.length-3;i+=1){
            for(int j=i+1;j<nums.length-2;j+=1){
                p=j+1;q=nums.length-1;
                while(p<q){
                    System.out.println("Sum:"+(nums[p]+nums[q]+nums[i]+nums[j]));
                    if(p==q||q==i||i==j||p==j) break;
                    try{
                        int r=Math.addExact(Math.addExact(nums[p],nums[q]),Math.addExact(nums[i],nums[j]));
                    }
                    catch(ArithmeticException e){
                        break;
                    }
                    if((nums[p]+nums[q]+nums[i]+nums[j])==target) {
                        System.out.println("i:"+i+" j:"+j+" p:"+p+" q:"+q);
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[p]); list.add(nums[q]); list.add(nums[i]); list.add(nums[j]);
                        if(!res.contains(list))
                        res.add(list);
                        p+=1;q-=1;
                    }
                    else if((nums[p]+nums[q]+nums[i]+nums[j])>target) q-=1;
                    else p+=1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[]={1000000000,1000000000,1000000000,1000000000}; int target=-294967296;
        List<List<Integer>> res=quad(nums,target);
        System.out.println("Res:"+res);
    }
}
