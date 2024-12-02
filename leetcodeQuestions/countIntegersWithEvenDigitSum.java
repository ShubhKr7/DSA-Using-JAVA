/*
 2180. Count Integers With Even Digit Sum

 Given a positive integer num, return the number of positive integers less than or equal to num whose digit sums are even.

The digit sum of a positive integer is the sum of all its digits.

Example 1:
Input: num = 4
Output: 2
Explanation:
The only integers less than or equal to 4 whose digit sums are even are 2 and 4.    

Example 2:
Input: num = 30
Output: 14
Explanation:
The 14 integers less than or equal to 30 whose digit sums are even are
2, 4, 6, 8, 11, 13, 15, 17, 19, 20, 22, 24, 26, and 28.

Constraints:
1 <= num <= 1000
 */

package leetcodeQuestions;

public class countIntegersWithEvenDigitSum {
    
    //Function to find the number of even digit sum numbers
    static int sum(int n){
        int sum=0,res=0;

        //Loop from number to 1
        while(n>0){

            //Take a fresh sum variable
            sum=0;
            int k=n;

            //Find sum of digits of current number
            while(k>0){
                sum+=(k%10);
                k/=10;
            }

            //If sum is even then add it to result variable
            if(sum%2==0) res+=1;

            //Update the number itself
            n-=1;
        }

        //Returning result
        return res;
    }

    //Main function
    public static void main(String[] args) {
        int num=101;
        System.out.println(sum(num));
    }
}
