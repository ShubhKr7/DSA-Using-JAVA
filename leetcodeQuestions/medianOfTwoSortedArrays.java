/*
 4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, 
return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */

package leetcodeQuestions;

public class medianOfTwoSortedArrays {
    
    //Function to find median
    public static double median(int []nums1, int []nums2){

        //Array to store sorted elements of both arrays
        int res[]=new int[nums1.length+nums2.length];

        //Array indexes of both arrays res, nums1, and nums2
        int z=0,p=0,q=0;

        //Storing elements in res in sorted manner
        while(z!=res.length) {
            int n1=p<nums1.length?nums1[p]:Integer.MIN_VALUE;
            int n2=q<nums2.length?nums2[q]:Integer.MIN_VALUE;

            //If nums2 is smaller than nums1
            if(n2==Integer.MIN_VALUE){res[z]=n1;z+=1;p+=1;}

            //If nums1 is smaller than nums2
            else if(n1==Integer.MIN_VALUE){res[z]=n2;z+=1;q+=1;}

            //If n1 is smaller store n1 and increase nums1 index by 1
            else if(n1<n2) {res[z]=n1;;z+=1;p+=1;}

            ////If n2 is smaller store n2 and increase nums2 index by 1
            else if(n1>n2) {res[z]=n2;z+=1;q+=1;}

            //If both are equal store both and increase pointer of both
            else if(n1==n2){res[z]=n1;res[z+1]=n2;z+=2;p+=1;q+=1;}
        }

        //If total odd elements are there then directly return middle element
        if(res.length%2!=0)
            return res[(res.length-1)/2];
        
        //Else calculate mean of two elements around middle 
        return (double)(res[res.length/2]+res[(res.length/2)-1])/2;
    }

    //Main function
    public static void main(String[] args) {
        int nums1[]={1,3};
        int nums2[]={2};
        double res=median(nums1,nums2);
        System.out.print("Res:"+res);
    }
}
