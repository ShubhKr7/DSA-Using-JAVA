/*
 1903. Largest Odd Number in String

You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.

A substring is a contiguous sequence of characters within a string.

Example 1:
Input: num = "52"
Output: "5"
Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.

Example 2:
Input: num = "4206"
Output: ""
Explanation: There are no odd numbers in "4206".

Example 3:
Input: num = "35427"
Output: "35427"
Explanation: "35427" is already an odd number.
 */

package leetcodeQuestions;
public class largestOddNumberInAString {
    
    //A function to find the largest Odd Number
    public static String largest(String s){
        if(s=="") return "";

        //Iterating for each Character from last
        for(int i=s.length()-1; i>=0; i-=1){

            //Checking ASCII value of each character and subtracting it with 48 (ASCII value of 0) and finding it is odd or not
            if((((int)s.charAt(i))-48)%2!=0) 
            
            //Largest number will be the entire number from that number to start
            return s.substring(0, i+1);
        }

        //Else return null
        return "";
    }

    //Main Function
    public static void main(String[] args) {
        String num="7777888888";
        String res=largest(num);
        System.out.println("Res:"+res);
    }
}
