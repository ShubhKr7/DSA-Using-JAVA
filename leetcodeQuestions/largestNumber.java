/*
179. Largest Number

Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

Example 1:
Input: nums = [10,2]
Output: "210"

Example 2:
Input: nums = [3,30,34,5,9]
Output: "9534330"

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 10^9
 */

package leetcodeQuestions;

public class largestNumber {

    public static String largest(int []nums){
        String res="";
        int a[]=new int[nums.length];
        for(int i=0; i<nums.length; i+=1){
            if(nums[i]<=9) a[i]=nums[i];
            else{
                int n=nums[i];
                while(n>9) n/=10;
                a[i]=n;
            }
        }

        for(int i:a) System.out.print(i+" ");
        System.out.println();
        for(int i:nums)System.out.print(i+" ");

        for(int i=0; i<nums.length-1; i+=1){
            for(int j=0; j<nums.length-i-1; j+=1){
                if(a[j]<a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;

                    int temp1=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp1;
                }
            }
        }
        for(int i:nums) res+=i;
        return res;
    }
    
    //Main function
    public static void main(String[] args) {
        // int nums[]={3,30,34,5,9};
        int []nums={2,10};
        System.out.println(largest(nums));
    }
}
