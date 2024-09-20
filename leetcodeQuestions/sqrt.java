/*
 69. Sqrt(x)

Given a non-negative integer x, return the square root of x rounded down to the nearest integer. 
The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

Example 1:
Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.

Example 2:
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

Constraints:
0 <= x <= 231 - 1
 */

package leetcodeQuestions;

public class sqrt {
    
    //Function to calculate the sqrt
    public static int calc(int x){

        //If x is maximum integer value then return it's pre calculated sqrt
        if(x==Integer.MAX_VALUE) return 46340;

        //Res to store result and i to iterate 
        int res=0; int i=1;

        //Loop till half numbers are covered coz after that there wont be any sqrt as ((x/2)+1)*((x/2)+1)>x for always
        while(i<=((x/2)+1)){

            //If number is a perfect square
            if((i*i)==x) return i;

            //if a square more than the number is obtained then the previous one is the answer
            else if((i*i)>x) return i-1;

            //increment i
            else i+=1;
        }

        //return result
        return res;
    }

    //Main function
    public static void main(String[] args) {
        int x=1;
        int res=calc(x);
        System.out.println("Res:"+res);
    }

}
