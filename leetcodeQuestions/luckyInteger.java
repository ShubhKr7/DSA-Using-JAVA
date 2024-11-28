/*
 1394. Find Lucky Integer in an Array
 Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.

Return the largest lucky integer in the array. If there is no lucky integer return -1.

Example 1:
Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.

Example 2:
Input: arr = [1,2,2,3,3,3]
Output: 3
Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.

Example 3:
Input: arr = [2,2,2,3,3]
Output: -1
Explanation: There are no lucky numbers in the array.

Constraints:
1 <= arr.length <= 500
1 <= arr[i] <= 500
 */

package leetcodeQuestions;

import java.util.*;

public class luckyInteger {
    
    //Function to find lucky number
    public static int lucky1(int []arr){

        //Creating a Hashmap to store frequency of a number
        HashMap<Integer,Integer> map=new HashMap<>();

        //Storing frequency of all the numbers in the array
       for(int i=0;i<arr.length;i++){
        if(map.containsKey(arr[i])){
            map.put(arr[i],(map.get(arr[i])+1));
        }
        else{
            map.put(arr[i],1);
        }}

        //Max to store the maximum Lucky number
       int max=Integer.MIN_VALUE;

       //Using entryset to iterate over the hashmap
       for(Map.Entry<Integer,Integer> entry:map.entrySet()){
        if((entry.getValue()==entry.getKey())){

            //If the lucky number is greater than the existing max value then update it
            max=Math.max(max, entry.getKey());
        }
    }

    //If there is any lucky number then return that
    if(max!=Integer.MIN_VALUE) return max;
        
    //If there is no lucky number then return -1
        return -1;
    }

    //Another Solution [Better one]
    public static int lucky2(int []nums){

        //Create an array to store frequency of each element
        int a[]=new int[501];

        //Set all frequencies to -1
        for(int i=0;i<500; i+=1) 
            a[i]=-1;

        //adding the frequencies of each element
        for(int i=0; i<nums.length; i+=1) 
            a[nums[i]]+=1;
        
        //Searching for a lucky number from the end as we have to return the largest lucky number
        for(int i=500; i>-1; i-=1) 
            if(a[i]==i-1&&i>0) 
                return i;

        //If no lucky number found then return -1
        return -1;
    }

    //Main Function
    public static void main(String[] args) {
        int nums[]={1,2,2,3,3,3};
        // int []nums={2,2,2,3,3};
        // System.out.println(lucky1(nums));
        System.out.println(lucky2(nums));
    }
}
