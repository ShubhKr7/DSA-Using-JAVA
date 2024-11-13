/*
1323. Maximum 69 Number

You are given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

Example 1:
Input: num = 9669
Output: 9969
Explanation: 
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666.
The maximum number is 9969.

Example 2:
Input: num = 9996
Output: 9999
Explanation: Changing the last digit 6 to 9 results in the maximum number.

Example 3:
Input: num = 9999
Output: 9999
Explanation: It is better not to apply any change.
 
Constraints:
1 <= num <= 104
num consists of only 6 and 9 digits.
 */

package leetcodeQuestions;

public class maximum69 {
    
    //Function to make maximum number
    public static int max(int n){
        int r=0;String p="";

        //convert the number to String
        String s=Integer.toString(n);

        //Now iterate through the number from left
        for(int i=0; i<s.length(); i+=1){

            //if it is the first six encountered then
            if(s.charAt(i)=='6'&r!=10) {

                //change it to nine and set the flag variable toh a certain value
                p+="9";
                r=10;
            }

            //else add the number as it is
            else p+=s.charAt(i);
        }

        //Now return the final number as an integer
        return Integer.parseInt(p);
    }

    //Main function
    public static void main(String[] args) {
        int n=6969;
        int res=max(n);
        System.out.println(res);
    }
}
