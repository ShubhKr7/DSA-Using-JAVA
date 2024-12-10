/*
 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence

Given a sentence that consists of some words separated by a single space, and a searchWord, check if searchWord is a prefix of any word in sentence.

Return the index of the word in sentence (1-indexed) where searchWord is a prefix of this word. If searchWord is a prefix of more than one word, return the index of the first word (minimum index). 
If there is no such word return -1.

A prefix of a string s is any leading contiguous substring of s.

Example 1:
Input: sentence = "i love eating burger", searchWord = "burg"
Output: 4
Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.

Example 2:
Input: sentence = "this problem is an easy problem", searchWord = "pro"
Output: 2
Explanation: "pro" is prefix of "problem" which is the 2nd and the 6th word in the sentence, but we return 2 as it's the minimal index.

Example 3:
Input: sentence = "i am tired", searchWord = "you"
Output: -1
Explanation: "you" is not a prefix of any word in the sentence.

Constraints:
1 <= sentence.length <= 100
1 <= searchWord.length <= 10
sentence consists of lowercase English letters and spaces.
searchWord consists of lowercase English letters.
 */

package leetcodeQuestions;
public class prefixWord {
    
    //Function to find the word exists or not
    static int prefix(String sentence, String searchWord){

        //Store all the words in an array
        String s[]=sentence.split(" ");

        //Loop thorugh the array
        for(int i=0; i<s.length; i+=1){

            //Take a pointer p
            int p=0;

            //If the current word is smaller than the searchWord then skip this word
            if(searchWord.length()>s[i].length()) continue;

            //Otherwise loop through the searchWord and the current word until the words are exhausted or the characters are same at same index
            while(p<searchWord.length()&&searchWord.charAt(p)==s[i].charAt(p)){

                //If we have reached at the last character of searchWord then return the position of this word
                if(p==searchWord.length()-1){return i+1;}

                //Otherwise update the pointer p
                p+=1;
            }
        }

        //If no such word is found then return -1
        return -1;
    }

    //Main function
    public static void main(String[] args) {
        // String sentence="i am shubhankar tiwari";
        // String searchWord="shubh";

        // String sentence="this problem is an easy problem";
        // String searchWord="pro";

        String sentence="a";
        String searchWord="a";
        System.out.println(prefix(sentence,searchWord));
    }
}
