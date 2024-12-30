/*
231. Power of Two

Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.

Example 1:
Input: n = 1
Output: true
Explanation: 20 = 1

Example 2:
Input: n = 16
Output: true
Explanation: 24 = 16

Example 3:
Input: n = 3
Output: false

Constraints:
-2^31 <= n <= 2^31 - 1

Follow up: Could you solve it without loops/recursion?
 */

package leetcodeQuestions;

class powerOfTwo{

    //Function to find power of two 
    public static boolean isPowerOfTwo(int n) {

        //If the number is negative return false
        if(n<0) return false;

        //Check if the number is in power any power of 2
        for(int i=0; i<31; i+=1){

        //If number is in power of two then return true
        if(Math.pow(2,i)==n) return true;

        //If number exceedes then return false
        else if(Math.pow(2,i)>n) return false;}

    //Return false if loop exits
      return false;
    }
  
    //Main Function
    public static void main(String []args){
      int n=100;
      System.out.print(isPowerOfTwo(n));
    }
}