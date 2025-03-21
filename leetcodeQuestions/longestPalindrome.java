/*
 409. Longest Palindrome

 Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.

Example 1:
Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:
Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.

Constraints:
1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
 */

package leetcodeQuestions;
import java.util.Arrays;

public class longestPalindrome {
    
    //Function to find the longest palindrome
    //Time complexity is O(n) where n is the length of the string s
    static int longest(String s){

        //Array to store the frequency of each character
        int arr[]=new int [123];
        Arrays.fill(arr,0);

        //Iterating through the string and updating the frequency of each character
        for(int i=0;i<s.length();i+=1){
            if((int)s.charAt(i)>90){
            if(arr[(int)s.charAt(i)]==0)arr[(int)s.charAt(i)]+=1;
            else arr[s.charAt(i)]-=1;}
            else{
                if(arr[(int)s.charAt(i)]==0)arr[(int)s.charAt(i)]+=1;
                else arr[s.charAt(i)]-=1;
            }}
        
        //Finding the length of the longest palindrome
        //Taking 1 extra character to be the center of the palindrome
        //That is why err is initialized to -1
        int err=-1;
        for(int i:arr) {
            System.out.print(i+" ");
            if(i==1) err+=1;}

        //Check if error has more than 1 extra characters so we will remove those many character from the string to make it a palindrome
        return err==-1?s.length():s.length()-err;
    }

    //Main function
    public static void main(String[] args) {
        String s="aaAaaa";
        System.out.println(longest(s));
    }
}
