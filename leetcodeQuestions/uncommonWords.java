/*
 884. Uncommon Words from Two Sentences

A sentence is a string of single-space separated words where each word consists only of lowercase letters.

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

Example 1:
Input: s1 = "this apple is sweet", s2 = "this apple is sour"
Output: ["sweet","sour"]
Explanation:
The word "sweet" appears only in s1, while the word "sour" appears only in s2.

Example 2:
Input: s1 = "apple apple", s2 = "banana"
Output: ["banana"]

Constraints:
1 <= s1.length, s2.length <= 200
s1 and s2 consist of lowercase English letters and spaces.
s1 and s2 do not have leading or trailing spaces.
All the words in s1 and s2 are separated by a single space.
 */

package leetcodeQuestions;
import java.util.*;

public class uncommonWords {

    public static String[] uncommon(String s1, String s2){

        //Spliting words of both strings and storing them into an array
        String a[]=s1.split(" ");
        String b[]=s2.split(" ");
        HashMap<String,Integer> map = new HashMap<>();

        //Adding words of s1 into a hashmap also counting their frequency
        for(int i=0; i<a.length; i+=1){
            if(map.containsKey(a[i])) map.put(a[i], map.get(a[i])+1);
            else map.put(a[i], 1);
        }

        //Adding words of s2 into a hashmap also counting their frequency
        for(int i=0; i<b.length; i+=1){
            if(map.containsKey(b[i])) map.put(b[i], map.get(b[i])+1);
            else map.put(b[i], 1);
        }        

        //Checking which word apears only once
        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String,Integer> entry: map.entrySet())
            if(entry.getValue()==1) list.add(entry.getKey());
            
        //Convert arraylist to an array 
        String res[]=new String[list.size()];
        for(int i=0; i<list.size(); i+=1) res[i]=list.get(i); 

        return res;
    }

    //Main function
    public static void main(String[] args) {
        String a="this apple is sweet";
        String b="this apple is sour";
        String res[]=uncommon(a,b);
        for(String i:res)
        System.out.print(i+" ");
    }
}
