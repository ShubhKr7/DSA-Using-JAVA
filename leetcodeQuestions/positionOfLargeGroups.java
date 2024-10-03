/*
 830. Positions of Large Groups

In a string s of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".

A group is identified by an interval [start, end], where start and end denote the start and end indices (inclusive) of the group. 
In the above example, "xxxx" has the interval [3,6].

A group is considered large if it has 3 or more characters.

Return the intervals of every large group sorted in increasing order by start index.

Example 1:
Input: s = "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the only large group with start index 3 and end index 6.

Example 2:
Input: s = "abc"
Output: []
Explanation: We have groups "a", "b", and "c", none of which are large groups.

Example 3:
Input: s = "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]
Explanation: The large groups are "ddd", "eeee", and "bbb".

Constraints:
1 <= s.length <= 1000
s contains lowercase English letters only.
 */

package leetcodeQuestions;
import java.util.*;
public class positionOfLargeGroups {
    
    //Function to find the number of groups
    public static List<List<Integer>> groups(String s){

        //List of list to store the result
        List<List<Integer>> res=new ArrayList<>();

        //Take two pointers both starting from the initial position and a variable to store length
        int start=0,last=0,len=0;

        //Iterate till end of string is reached
        while(last<s.length()){

            //If the characters are equal then increase length by 1 and update last
            if(s.charAt(start)==s.charAt(last)){
                len+=1;last+=1;
            }

            //Otherwise check if length of previous combination is more than 3
            //Then add it to the result
            else if(s.charAt(start)!=s.charAt(last)){
                if(len>=3){
                ArrayList<Integer>list=new ArrayList<>();
                list.add(start); list.add(last-1);
                 res.add(new ArrayList<>(list));}

                 //And update start pointer to last and make reset length to 0
                 start=last;
                 len=0;
            }
        }

        //Also check if there is a combination of length more than 3 while reaching end of
        //String then add that too into the result
        if((last-start)>3) {
            ArrayList<Integer>list=new ArrayList<>();
            list.add(start); list.add(last-1);
            res.add(new ArrayList<>(list));
        }

        //Return result
        return res;
    }

    public static void main(String[] args) {
        // String s="abcdddeeeeaabbbcd";
        // String s="abbxxxxzzy";
        // String s="aaaaa";
        String s="aa";
        List<List<Integer>>res=groups(s);
        System.out.println(res);
    }
}
