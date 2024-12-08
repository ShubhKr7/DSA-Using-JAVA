/*
 344. Reverse String

 Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

Constraints:
1 <= s.length <= 10^5
s[i] is a printable ascii character.
 */

package leetcodeQuestions;

public class reverseString {
    
    //Function to reverse the array
    static void rev(char []s){

        //Take a pointer at the end of the array
        int l=s.length-1;

        //Loop through the array from start
        for(int i=0; i<l; i+=1){

            //Store current element in a variable
            char t=s[i];

            //Store last element at the current element position
            s[i]=s[l];

            //Store the current element at the last variable position
            s[l]=t;

            //Decrement the pointer from the last
            l-=1;
        }
    }

    //Main function
    public static void main(String[] args) {
        // char []s={'h','e','l','l','o'};
        // char []s={'h'};
        char s[]={'h','e'};
        System.out.println("Before:");
        for(char i:s)
        System.out.print(i+" ");
        System.out.println("\nAfter:");
        rev(s);
        for(char i:s)
        System.out.print(i+" ");
    }
}
