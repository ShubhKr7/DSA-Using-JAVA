/*
 283. Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
 */

package leetcodeQuestions;
class zeroAtLast{

    //Function to sort 0s at end
    public static int[] sort(int nums[]){
        int j=0;

        //Iterate through the array nums
        for(int i=0;i<nums.length;i+=1){

            //if it is a zero then do nothing
            if(nums[i]==0) continue;

            //if it is not a zero then replace the number at j with the number at i
            else if(nums[i]!=0) 
                nums[j]=nums[i];

                //increase j by one
                j+=1;
        }

        //Now convert the remaining elements of the array to 0
        for(int i=j;i<nums.length;i+=1) nums[i]=0;

        //Return the array
        return nums;
    }

    //Main function
    public static void main(String[] args) {
        // int nums[]={1,0,0,2,3,0,4};
        // int nums[]={0};
        int nums[]={101};
        int res[]=sort(nums);
        System.out.print("Res:");
        for(int i:res)
        System.out.print(i+" ");
    }
}