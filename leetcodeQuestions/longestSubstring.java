package leetcodeQuestions;

import java.util.HashMap;

public class longestSubstring {
    
    //Function to find the length of longest unique substring
    public static int longest(String s){

        //Take two pointers one to store max length and other to track left end of window
        int max=0,start=0;

        //Hashmap to store index of windows with respect to each character
		HashMap<Character,Integer> has = new HashMap<>();

        //Iterate over the string
		for(int i=0; i<s.length(); i+=1) {

            //If the map already contains the element and it is within the window then shift the left end of the window to that character to start over
            if(has.containsKey(s.charAt(i))&&has.get(s.charAt(i))>=start) 
                start=has.get(s.charAt(i))+1;

            //calculate the max length of the window
            max=Math.max(max,i-start+1);

            //And put the character into the hashtable with new indexing
            has.put(s.charAt(i),i);
		}

        //Return the result
		return max;
    }

    //Main function
    public static void main(String[] args) {
        String s="abcabcdb";
        System.out.println(longest(s));
    }
}

