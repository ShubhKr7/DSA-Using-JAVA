/*
 1647. Minimum Deletions to Make Character Frequencies Unique

 A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string. 
For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.

Example 1:
Input: s = "aab"
Output: 0
Explanation: s is already good.

Example 2:
Input: s = "aaabbbcc"
Output: 2
Explanation: You can delete two 'b's resulting in the good string "aaabcc".
Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".

Example 3:
Input: s = "ceabaacb"
Output: 2
Explanation: You can delete both 'c's resulting in the good string "eabaab".
Note that we only care about characters that are still in the string at the end 
(i.e. frequency of 0 is ignored).
 */

package leetcodeQuestions;
import java.util.HashMap;
import java.util.HashSet;
public class MinimumDeletionToMakeCharacterFrequenciesUnique {
    
    //Function to find unique frequencies
    public static int unique(String s){

        //Minimun Deletions required and a HashMap to store Frequencies
        int min=0; HashMap<Character,Integer> map = new HashMap<>();

        //Storing frequency if each character
        for(int i=0; i<s.length(); i+=1){
            if(map.containsKey(s.charAt(i))) map.put(s.charAt(i), map.get(s.charAt(i))+1);
            else map.put(s.charAt(i), 1);
        }

        //Using hashset to compare frequencies as HashSet takes O(1) to fetch any element
        HashSet<Integer> set = new HashSet<>();

        //Iterating for each frequency
        for(Map.Entry<Character,Integer> entry: map.entrySet()){

            //Taking one frequency at a time
            int n=entry.getValue();

            //Finding if that frequency already exists or not in O(1)
            if(set.contains(n)){

                //Reducing that frequency by 1 till it becomes unique or 0 which means character no longer exists
                while(set.contains(n)&&n!=0){
                    //Reduce freq by 1 and increase min by 1
                    n-=1;min+=1;
                }
            }

        //Storing only unique frequencies in set and avoiding storing 0s as that means a dead character 
        if(n!=0)
        set.add(n);}

        //Returning result
        return min;
    }

    //Main Function
    public static void main(String[] args) {
        String s="ceabaacb";
        int res=unique(s);
        System.out.println("Res:"+res);
    }
}
