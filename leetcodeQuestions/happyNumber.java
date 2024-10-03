/*
 202. Happy Number

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:
Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

Example 2:
Input: n = 2
Output: false

Constraints:
1 <= n <= 2^31 - 1
 */

package leetcodeQuestions;
import java.util.HashSet;
public class happyNumber {

    //Function to find if the number is a happy number or not
    public static boolean isHappy(int n){
        HashSet<Integer>set=new HashSet<>();

        //Iterate till n becomes 0
        while(n!=0){

            //If this number is already visited then there is an infinite loop and return false
            if(set.contains(n)) return false;

            //If n is 1 then it is a happy number
            if(n==1) return true;

            //Otherwise add that number to the set
            set.add(n); int sum=0;

            //Find the sum of square of digits
            for(int i=n; i>0; i/=10)
                sum+=(Math.pow(i%10,2));
            
            //Set new number to n
            n=sum;
        }

        //return true
        return true;
    }
    
    //Main function
    public static void main(String[] args) {
        int n=2;
        System.out.println(isHappy(n));
    }
}
