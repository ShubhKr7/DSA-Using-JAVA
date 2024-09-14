/*
347. Top K Frequent Elements. 
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]
 */


package leetcodeQuestions;
import java.util.*;

public class topKFrequentElements {
    
    //A function to find top k frequent elements
    public static int[] solve(int nums[], int k){

        //Stroing frequency in a HashMap
        HashMap<Integer,Integer> map = new HashMap<>();

        //Storing result in an array
        int res[]=new int[k];

        //Finding frequency of each element
        for(int i:nums){
            if(map.get(i)!=null){
                map.put(i,map.get(i)+1);
                continue;
            }
            map.put(i,1);
        }

        //Storing frequencies in an array list
        ArrayList<Integer> list= new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            list.add(entry.getValue());
        }

        //Sorting the ArrayList in ascending order
        Collections.sort(list); int z=0;

        //Finding top frequenct elements from last of arraylist
        while(z!=k){

            //Taking frequencies from last
            int l=list.get(list.size()-(z+1));

            //Finding the key corresponding to that frequency and storing it in res
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()==l){
            res[z]=entry.getKey();z+=1;}
        }}

        //Returning result
        return res;
    }

    //Main function
    public static void main(String[] args) {
        int nums[]={1}; int k=1;
        int res[]=solve(nums,k);
        System.out.print("Res:");
        for(int i: res) System.out.print(i+" ");
    }
}
