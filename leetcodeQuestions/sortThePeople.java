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
