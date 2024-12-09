/*
 2418. Sort the People

You are given an array of strings names, and an array heights that consists of distinct positive integers. 
Both arrays are of length n.

For each index i, names[i] and heights[i] denote the name and height of the ith person.

Return names sorted in descending order by the people's heights.

Example 1:

Input: names = ["Mary","John","Emma"], heights = [180,165,170]
Output: ["Mary","Emma","John"]
Explanation: Mary is the tallest, followed by Emma and John.
Example 2:

Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
Output: ["Bob","Alice","Bob"]
Explanation: The first Bob is the tallest, followed by Alice and the second Bob.

Constraints:

n == names.length == heights.length
1 <= n <= 103
1 <= names[i].length <= 20
1 <= heights[i] <= 105
names[i] consists of lower and upper case English letters.
All the values of heights are distinct.
 */

package leetcodeQuestions;
import java.util.*;
public class sortThePeople {

    //Function to find sort the names
    public static String[] sort(String []names, int []heights){

        //Array to store the sorted names
        String res[]=new String[heights.length];

        //HashMap to store the height and corresponding names
        HashMap<Integer,String>map=new HashMap<>();

        //Putting data into hashmap
        for(int i=0; i<names.length; i+=1) map.put(heights[i], names[i]);

        //Sorting array of heights and taking an index pointer to res array
        Arrays.sort(heights);int z=0;

        //Iterating over the sorted heights array
        for(int i=names.length-1; i>=0; i-=1){

            //Storing the sorted names into res using hashmap
            res[z]=map.get(heights[i]);z+=1;}

        //Returning result
        return res;
    }
    
    //Main function
    public static void main(String[] args) {
        String []names={"Mary","John","Emma"};
        int heights[]={180,165,170};
        String res[]=sort(names,heights);
        for(String i:res) System.out.print(i+" ");
    }
}
