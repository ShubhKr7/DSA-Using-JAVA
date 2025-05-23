/*
48. Rotate Image

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Constraints:
n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
 */

package leetcodeQuestions;

public class rotateImage {

    public static void rotate(int[][] matrix) {
        int edge=matrix.length;
        int start=0,last=edge-1;

        //Vertical Reversal
        while(start<last){
            for(int i=0;i<edge;i+=1){
                int temp=matrix[start][i];
                matrix[start][i]=matrix[last][i];
                matrix[last][i]=temp;
            }
            start+=1;last-=1;
        }

        //Transpose
        for(int i=0;i<edge;i+=1){
            for(int j=i+1;j<edge;j+=1){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
    
    public static void main(String[] args) {
        int [][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
