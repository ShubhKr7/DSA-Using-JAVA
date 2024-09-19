/*
 66. Plus One

You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 
Constraints:
1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.
 */

package leetcodeQuestions;
public class plusOne{

    //Function to calculate the required
    public static int[] plus(int []digits){

        //l to store length of resulting array
        int l=1;

        //Finding the length of resulting array 
        for(int i:digits){

            //If any non 9 number is there then resulting array will be of same length as digits coz extra space is required in cases
            //like 99, 999, 99999 etc.
            if(i!=9) {
                l=digits.length; break;
            }

            //else increase the count by 1
            else l+=1;
        }

        //a variable to store the length of original array
        int p=digits.length-1;

        //resulting array
        int []arr=new int [l];

        //Take carry as 1 and sum as 0
        int c=1,sum=0;

        //Iterate for resulting array
        for(int i=l-1; i>=0; i-=1){

            //update sum till valid
            if(p>=0) sum=digits[p]+c;

            //if sum is of 2 digits then reduce it to 1 digit and take an extra carry
            if(sum>9){
                arr[i]=sum%10;
                c=1;
            }

            //else take carry as 0
            else{
                arr[i]=sum; c=0;
            }

            //Reduce p
            p-=1;
        }

        //If any carry is left then there will be an extra space as well in the array so put it in first place
        if(c==1) arr[0]=1; 
        
        //Return result
        return arr;
    }

    //Main function
    public static void main(String[] args) {
        // int digits[]={7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
        int []digits={0};
        // int digits[]={9,0};
        int res[]=plus(digits);
        for(int i:res)
        System.out.print(i+" ");
    }
}