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
Output: [[2,2,2,2]]*/

package leetcodeQuestions;
import java.util.*;
public class fourSum {
    
    //FUnction to find quadruplets
    public static List<List<Integer>> quad(int []nums, int target){

        //List of lists to store quadruplets
        List<List<Integer>> res= new ArrayList<>();

        //If the input array is less than 4 then no quadruplets exist
        if(nums.length<4) return res;

        //Sort array in ascending order
        Arrays.sort(nums);

        //Take a pointer p after 2 inital elements and a pointer q at the last element
        int p=2,q=nums.length-1;

        //Now loop into array from start till fourth last element
        for(int i=0; i<nums.length-3;i+=1){

            //Now loop again from second element to third last element
            for(int j=i+1;j<nums.length-2;j+=1){

                //Make p one element ahead than j and q at end as usual
                p=j+1;q=nums.length-1;
                while(p<q){

                    //If any of the index is same then skip coz we need distinct quadruplets
                    if(p==q||q==i||i==j||p==j) break;

                    //Here we are covering the integer overflow condition
                    try{

                        //This will add numbers as they are and not making integer value overflow and 
                        //As integer value will overflow it will throw an exception
                        //As integer tries to keep value within its range so it will truncate the resulting value
                        Math.addExact(Math.addExact(nums[p],nums[q]),Math.addExact(nums[i],nums[j]));
                    }

                    //Catching the exception and breaking the loop as the nunbers are way too big
                    catch(ArithmeticException e){
                        break;
                    }

                    //If sum of all 4 elements add up to target
                    if((nums[p]+nums[q]+nums[i]+nums[j])==target) {

                        //Make an arraylist
                        ArrayList<Integer> list = new ArrayList<>();

                        //Add all elements into array list
                        list.add(nums[p]); list.add(nums[q]); list.add(nums[i]); list.add(nums[j]);

                        //If such distinct elements are not already covered then add the list to the result
                        if(!res.contains(list))
                        res.add(list);

                        //Now modify the pointers
                        p+=1;q-=1;
                    }

                    //Otherwise if sum is greater than target then decrease the ending pointer
                    else if((nums[p]+nums[q]+nums[i]+nums[j])>target) q-=1;

                    //If sum is smaller than target then increase innermost left pointer by one
                    else p+=1;
                }
            }
        }

        //Return the resulting list
        return res;
    }

    //Main Function
    public static void main(String[] args) {
        int nums[]={1000000000,1000000000,1000000000,1000000000}; int target=-294967296;
        List<List<Integer>> res=quad(nums,target);
        System.out.println("Res:"+res);
    }
}
