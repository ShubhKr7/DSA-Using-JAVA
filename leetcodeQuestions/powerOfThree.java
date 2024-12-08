/*
 326. Power of Three

 Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.

Example 1:
Input: n = 27
Output: true
Explanation: 27 = 33

Example 2:
Input: n = 0
Output: false
Explanation: There is no x where 3x = 0.

Example 3:
Input: n = -1
Output: false
Explanation: There is no x where 3x = (-1).

Constraints:
-2^31 <= n <= 2^31 - 1

Follow up: Could you solve it without loops/recursion?
 */

package leetcodeQuestions;

public class powerOfThree {
    
    //Bruteforce way
    static boolean isPower(int n){

        //Iterate till the number itself
        for(int i=0; i<n; i+=1){

            //If we have found the number then return true
            if(Math.pow(3,i)==n) return true;

            //If the result is more than n then break the loop
            else if(Math.pow(3,i)>n) break;
        }

        //If we reach out of the loop that means no such number is found then return false
        return false;
    }

    //Optimised way
    static boolean pow(int n){
        if(n<=0) return false;
        else if(n==1) return true;

        //Divide n and check if it's still divisible by 3 or not
        while(n%3==0){

            //Update n
            n/=3;
        }

        //Check if n has become 1 or not
        return n==1;
    }

    //Main Function
    public static void main(String[] args) {
        // int n=27;
        // int n=-1;
        // int n=1;
        // int n=300;
        int n=729;
        System.out.println(isPower(n));
    }
}
