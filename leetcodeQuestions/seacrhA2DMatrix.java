/*
 74. Search a 2D Matrix

 You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
 */

package leetcodeQuestions;
public class seacrhA2DMatrix {
    
    //Function to find the element
    public static boolean search(int [][]matrix, int target){

        //res to store the result. Initially set it to false
        boolean res=false;

        //Looping through the matrix
        for(int i=0;i<matrix.length; i+=1){

            //Checking the last element of the matrix. If the element is greater than or equal to target then target will be in that row
            //Else skip that row
            if(matrix[i][matrix[0].length-1]<target) continue;

            //If found then perform binary search on that row to achieve O(log(m*n)) complexity
            res=binary(matrix, target, i);

            //If element found then stop iterating on the left over matrix
            if(res==true) break;}

        //Return result
        return res;
    }

    //Function to perform binary search
    public static boolean binary(int [][]matrix, int target, int row){
        int s=0,l=matrix[0].length-1;
        int mid=(matrix[0].length)/2;
        while(s<=l){
            mid=(s+l)/2;
        if(matrix[row][mid]==target) return true;
        else if(matrix[row][mid]<target) s=mid+1;
        else l=mid-1;
        }
        return false;
    }

    //Main function
    public static void main(String[] args) {
        int nums[][]={{-10,3,5,7},{10,11,16,20},{23,30,34,60}}; int target = -10;
        boolean res = search(nums,target);
        System.out.println("Res:"+res);
    }
}
