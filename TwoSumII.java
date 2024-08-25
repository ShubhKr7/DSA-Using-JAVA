/*
 Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 */

package leetcodeQuestions;
class TwoSumII{

    public static int[] calcTwoSum(int []numbers, int target){
        int p=0,q=numbers.length-1,sum=0,res[]={0,0};
        while(p<q){
            sum=numbers[p]+numbers[q];
            if(sum>target) q-=1;
            else if(sum<target) p+=1;
            else if(sum==target) {res[0]=p+1; res[1]=q+1; return res;}
        }
        return res;
    }

    public static void main(String args[]){
        int numbers[]={2,7,11,15};
        int target=9;
        int res[]=new int[2];
        res=calcTwoSum(numbers,target);
        System.out.println("Res:");
        for(int i:res)
        System.out.print(i+" ");
    }
}