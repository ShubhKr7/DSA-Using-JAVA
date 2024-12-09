/*
 350. Intersection of Two Arrays II

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 
Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

package leetcodeQuestions;
import java.util.*;
public class intersectionOfTwoArrays {
    
    //Function to find the intersection of two arrays
    static int[] inter(int []nums1, int []nums2){
        ArrayList<Integer> res=new ArrayList<>();
        if(nums1.length<nums2.length){

            //Sort larger array
            Arrays.sort(nums2);

            //Iterate through smaller array
            for(int i=0; i<nums1.length; i+=1){

                //If the element is present
                if(isThere(nums1[i],nums2)>-1) {
                    
                    //Add it to resulting list
                    res.add(nums1[i]);
                    
                    //Change the number to -1
                    nums2[isThere(nums1[i],nums2)]=-1; 
                    
                    //Again sort the array as an element from the middle has been changed to -1
                    Arrays.sort(nums2);}
            }
        }
        else{
            Arrays.sort(nums1);
            for(int i=0; i<nums2.length; i+=1){
                if(isThere(nums2[i],nums1)>-1) {res.add(nums2[i]);nums1[isThere(nums2[i],nums1)]=-1; Arrays.sort(nums1);}
            }
        }

        //Return the arraylist as an array using stream API
        return res.stream().mapToInt(i -> i).toArray();
    }

    //Function to find the element using binary search
    static int isThere(int n, int []arr){
        int start=0,last=arr.length-1,mid=(start+last)/2;

        while(start<=last){

            //Using this formula to find middle index to avoid overflow condition
            mid=start+(last-start)/2;
            if(arr[mid]==n) 
            
            //If element found then return the index of the element where it is found
            return mid;


            else if(arr[mid]>n) last=mid-1;
            else start=mid+1;
        }

        //If element not found return -1
        return -1;
    }

    public static void main(String[] args) {
        // int nums1[]={1,2,2,1};
        // int nums2[]={2,2};

        // int[] nums1={1,1};
        // int []nums2={1,2};

        int nums1[]={61,24,20,58,95,53,17,32,45,85,70,20,83,62,35,89,5,95,12,86,58,77,30,64,46,13,5,92,67,40,20,38,31,18,89,85,7,30,67,34,62,35,47,98,3,41,53,26,66,40,54,44,57,46,70,60,4,63,82,42,65,59,17,98,29,72,1,96,82,66,98,6,92,31,43,81,88,60,10,55,66,82,0,79,11,81};
        int nums2[]={5,25,4,39,57,49,93,79,7,8,49,89,2,7,73,88,45,15,34,92,84,38,85,34,16,6,99,0,2,36,68,52,73,50,77,44,61,48};

        // int nums1[] = {4,9,5};
        // int nums2[] = {9,4,9,8,4};

        int res[]=inter(nums1,nums2);

        for(int i: res) System.out.print(i+" ");
    }
}
