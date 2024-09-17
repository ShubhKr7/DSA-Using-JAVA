/*
28. Find the Index of the First Occurrence in a String

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */

package leetcodeQuestions;

public class firstIndexOfAString {
 
    //Function to calculate 
    public static int str(String haystack, String needle){

        //If empty string is passed then return 0
        if(haystack.equals(" ")||needle.equals(" ")) return 0;
         int z=0;

         //Iterate over the haystack string
        for(int i=0; i<haystack.length(); i+=1){

            //If both the characters in needle and haystack are equal
            if(haystack.charAt(i)==(needle.charAt(z))) {

                //Increase needle index by 1
                z+=1; 

                //check if needle is exhausted or not
                if(z==needle.length()) 
                
                //return the difference of indexes of needle and haystack
                return i-z+1;}
            
            else {

                //make haystack index behind the used needle index so that fresh start can be done
                i=i-z;z=0;
            }
            
        }

        //If needle does not exist then return -1
        return -1;
    }
    
    //Main function
    public static void main(String[] args) {
        String haystack="mississippi";
        String needle="issip";
        int res=str(haystack,needle);
        System.out.println("Res:"+res);
    }
}
