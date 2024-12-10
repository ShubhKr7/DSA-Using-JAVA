/*
 1652. Defuse the Bomb

You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length of n and a key k.

To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.

If k > 0, replace the ith number with the sum of the next k numbers.
If k < 0, replace the ith number with the sum of the previous k numbers.
If k == 0, replace the ith number with 0.
As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].

Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!

Example 1:
Input: code = [5,7,1,4], k = 3
Output: [12,10,16,13]
Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.

Example 2:
Input: code = [1,2,3,4], k = 0
Output: [0,0,0,0]
Explanation: When k is zero, the numbers are replaced by 0. 

Example 3:
Input: code = [2,4,9,3], k = -2
Output: [12,5,6,13]
Explanation: The decrypted code is [3+9, 2+3, 4+2, 9+4]. Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.

Constraints:
n == code.length
1 <= n <= 100
1 <= code[i] <= 100
-(n - 1) <= k <= n - 1
 */

package leetcodeQuestions;
public class defuseTheBomb {
    
    //Function to find the resulting array
    static int[] defuse(int []code, int k){

        //Create a resulting array
        int res[]=new int[code.length];

        //Loop through the array and set all values to 0
        for(int i=0; i<res.length; i+=1) res[i]=0;

        //If k is 0 then return the resulting array
        if(k==0) return res;

        //If k is greater than 0
        if(k>0){

        //Loop through the array
        for(int i=0; i<code.length; i+=1){
            int sum=0;
            int z=k;

            //Find sum of next k elements
            while(z!=0){

                //If index goes out of bounds then mod it with length of array
                sum+=code[(i+z)%(code.length)];
                z-=1;
            }

            //Store the sum in res
            res[i]=sum;
        }}

        //If k is smaller than 0
        if(k<0){

            //Loop through the array
            for(int i=0; i<code.length; i+=1){

                //Take two variables
                int sum=0; int z=k;

                //Find sum of previous k elements
                while(z<0){

                    //First add the indexes and mod it with length of array to make it in bounds of array and positive now add the length of array to make it positive and if it goes out of bounds mod it again with length of array to make it in bounds
                    sum+=code[(((i+z)%(code.length))+code.length)%code.length]; z+=1;
                }

            //Add the sum to the resulting array 
            res[i]=sum;}
        }

        //Return the resulting array
        return res;
    }

    //Main function
    public static void main(String[] args) {
        // int code[]={5,7,1,4}; int k=3;
        int []code={2,4,9,3}; int k=-2;
        int []res=defuse(code,k);
        for(int i:res)
        System.out.print(i+" ");
    }
}
