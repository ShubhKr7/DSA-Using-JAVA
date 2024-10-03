/*
 599. Minimum Index Sum of Two Lists

Given two arrays of strings list1 and list2, find the common strings with the least index sum.

A common string is a string that appeared in both list1 and list2.

A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.

Return all the common strings with the least index sum. Return the answer in any order.

Example 1:
Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
Explanation: The only common string is "Shogun".

Example 2:
Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
Output: ["Shogun"]
Explanation: The common string with the least index sum is "Shogun" with index sum = (0 + 1) = 1.

Example 3:
Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
Output: ["sad","happy"]
Explanation: There are three common strings:
"happy" with index sum = (0 + 1) = 1.
"sad" with index sum = (1 + 0) = 1.
"good" with index sum = (2 + 2) = 4.
The strings with the least index sum are "sad" and "happy".

Constraints:
1 <= list1.length, list2.length <= 1000
1 <= list1[i].length, list2[i].length <= 30
list1[i] and list2[i] consist of spaces ' ' and English letters.
All the strings of list1 are unique.
All the strings of list2 are unique.
There is at least a common string between list1 and list2.
 */

package leetcodeQuestions;
import java.util.*;
public class minimumIndexSum {

    //Function to find the minimum index sum strings
    public static String[] min(String []list1, String []list2){

        //Using a hashmap to store index of elements of list1 and arraylist to store result
        HashMap<String,Integer>map=new HashMap<>();
        ArrayList<String>list=new ArrayList<>();

        //Using a min variable to store minimum sum
        int z=0,min=Integer.MAX_VALUE;

        //Put values into the hashmap
        for(String i:list1) {map.put(i,z);z+=1;}

        //Iterate over the list2 
        for(int i=0; i<list2.length; i+=1){

            //If current element exists in list1
            if(map.containsKey(list2[i])){

                //If new sum is new minimum
                if(i+map.get(list2[i])<min){

                    //Remove any previous added sums
                    list.clear();

                    //Add this new sum element to the list
                    list.add(list2[i]); min=i+map.get(list2[i]);
                }

                //If current sum is equal to minimum sum then add the current element
                else if(i+map.get(list2[i])==min) list.add(list2[i]);
            }}
        
        //Return arraylist as an array of string
        return list.toArray(new String[0]);
    }
    
    //Main function
    public static void main(String[] args) {
        // String []s1={"Shogun","Tapioca Express","Burger King","KFC"};
        // String []s2={"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        // String []s1={"happy","sad","good"};
        // String s2[]={"sad","happy","good"};
        String []s1={"Shogun","Tapioca Express","Burger King","KFC"};
        String []s2={"KFC","Shogun","Burger King"};
        String []res=min(s1,s2);
        for(String i:res)
        System.out.print(i+" ");
    }
}
