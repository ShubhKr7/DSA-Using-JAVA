/*
 387. First Unique Character in a String

Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0
Explanation:
The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1
 */

package leetcodeQuestions;
import java.util.*;
public class firstUniqueCharacter {
    
    public static int unique(String s){

        //Checking boundary conditions
        if(s.length()==0||s.equals(" ")) return 0;
        else if(s.length()==1) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int res=-1;
        int l=0;

        //Storing frequency of each element in hashmap
        while(l<s.length()){
            if(map.containsKey(s.charAt(l))) map.put(s.charAt(l), map.get(s.charAt(l))+1);
            else map.put(s.charAt(l), 1);
            l+=1;
        }

        //Traversing map to find first unique element
        for(int i=0; i<s.length(); i+=1){
            int value=map.get(s.charAt(i));
            if(value==1) return i;
        }

        //Return res
        return res;
    }

    //Main function
    public static void main(String[] args) {
        // String s="leetcode";
        // String s="loveleetcode";
        // String s="aabb";
        // String s="     q";
        String s="a";
        int res=unique(s);
        System.out.println("Res:"+res);
    }
}
