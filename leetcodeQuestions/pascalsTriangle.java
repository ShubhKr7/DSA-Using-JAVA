/*
 118. Pascal's Triangle

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]

Constraints:
1 <= numRows <= 30
 */

package leetcodeQuestions;
import java.util.*;
public class pascalsTriangle {

    //Function to print pascals triangle
    public static List<List<Integer>> generate(int numRows){

        //List of lists to store resulting values of triangle
        List<List<Integer>> res= new ArrayList<>();

        //A loop to iterate for number of rows
        for(int i=0; i<=numRows-1; i+=1){

            //Taking a variable number to print numbers from 1
            int j=0,number=1;

            //Making an array list to store numbers of pascals triangle
            ArrayList<Integer> list = new ArrayList<>();

            //A while loop to iterate for each number in a specific row
            while(j<=i){

                //A list to add elements to pascals triangle
                list.add(number);

                //Formula to calculate next number of series
                number = number * (i-j)/(j+1);

                //Incrementing j
                j+=1;
            }

            //Adding list to result
            res.add(list);
        }

        //Returning result
        return res;
    }
    
    //Main Function
    public static void main(String[] args) {
        int numRows=5;
        List<List<Integer>> res=generate(numRows);
        System.out.println(res);
    }
}
