/*
 412. Fizz Buzz

 Given an integer n, return a string array answer (1-indexed) where:
answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i (as a string) if none of the above conditions are true.

Example 1:
Input: n = 3
Output: ["1","2","Fizz"]

Example 2:
Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]

Example 3:
Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

Constraints:
1 <= n <= 10^4
 */

package leetcodeQuestions;
import java.util.ArrayList;
import java.util.List;
public class fizzBuzz {
    
    //Function to find the required result
    static List<String> isFizzBuzz(int n){

        //Create a new arraylist
        List<String> res= new ArrayList<>();

        //Loop from 1 to that number
        for(int i=1; i<=n; i+=1){

            //Use the required ifs
            if(i%3==0&&i%5==0) res.add("FizzBuzz");
            else if(i%3==0) res.add("Fizz");
            else if(i%5==0) res.add("Buzz");

            //Adding the current number as a String
            else res.add(String.valueOf(i));
        }

        //Return the result
        return res;
    }

    //Main Function
    public static void main(String[] args) {
        int n=15;
        List<String> res=new ArrayList<>();
        res=isFizzBuzz(n);
        System.out.print(res);
    }
}
