/*
 1346. Check If N and Its Double Exist

Given an array arr of integers, check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]

Example 1:
Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]

Example 2:
Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.

Constraints:
2 <= arr.length <= 500
-10^3 <= arr[i] <= 10^3
 */

package leetcodeQuestions;
import java.util.ArrayList;

public class checkIfNAndItsDoubleExists {
    
    //Function to find if double exists or not
    static boolean exists(int []arr){

        //Use an array list to store elements till now
        ArrayList<Integer> list= new ArrayList<>();

        //Iterate through the array
        for(int i=0; i<arr.length; i+=1){

                //If it is odd number then check if its double exists or not
                if(arr[i]%2!=0&&list.contains(arr[i]*2)) return true;

                //If it is an even number then check either double or half exists or not
                if(arr[i]%2==0) if(list.contains(arr[i]*2)||list.contains(arr[i]/2)) return true;

                //Now add this current number to the list
                if(!list.contains(arr[i])) list.add(arr[i]);
        }

        //Return false if no such number is found
        return false;
    }

    //Main Function
    public static void main(String[] args) {
        // int nums[]={-2,0,10,-19,4,6,-8};

        int nums[]={10,2,5,3};
        System.out.println(exists(nums));
    }
}
