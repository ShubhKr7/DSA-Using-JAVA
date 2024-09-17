/*
 58. Length of Last Word

 Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
 */

package leetcodeQuestions;

public class lengthOfLastWord {
    
    //Function to calculate length of last word
    public static int len(String s){

        //If null or empty string is passed then return 0
        if(s.equals("")||s.equals(" ")) return 0;

        //Res to store result
        int res=0;

        //Trim any leading and trailing spaces
        s=s.trim();

        //l will hold index of last character
        int l=s.length()-1;

        //Iterating till whitespace is encountered or end (Start) of string is reached
        while(l>=0&&s.charAt(l)!=' '){
            res+=1; l-=1;
        }

        //Return res
        return res;
    }

    //Main function
    public static void main(String[] args) {
        // String s="Hello World";
        // String s="luffy is still joyboy";
        // String s="   fly me   to   the moon  ";
        // String s="                                 k";
        String s=" ";
        int res=len(s);
        System.out.println("Res:"+res);
    }
}
