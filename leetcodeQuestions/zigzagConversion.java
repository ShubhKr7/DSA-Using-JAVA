/*
 6. Zigzag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);
 
Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:
Input: s = "A", numRows = 1
Output: "A"

Constraints:
1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */

package leetcodeQuestions;
public class zigzagConversion {

    //Function to create resulting string
    public static String convert(String s, int numRows){

        //Return the original string if matrix numbers or rows increase to length of
        //String or more than that or is exactly 1
        if(numRows==1||numRows>=s.length()) return s;

        //Creating an array to store index of each character and a char array to store each charcater of string
        int num[]=new int[s.length()]; char []arr=s.toCharArray();

        //Taking two pointers one to iterate over s and other to store elements in num
        int z=1,i=0;

        //This while condition ensures the below two while loops execute until end of string is reached
        while(i<s.length()){

            //Store rank from 1 to number of rows provided
            while(i<s.length()&&z<=numRows){
                num[i]=z;
                z+=1;
                i+=1;
            }

            //updating z
            z-=2;

            //Storing rank from end-1 to 1 
            while(i<s.length()&&z>0){
                num[i]=z;
                z-=1;
                i+=1;
            }

            //updating z
            z=2;
        }
        
        //Using bubble sort to sort both the arrays simultaneously
        for(int j=0; j<num.length-1; j+=1){
            for(int k=0; k<num.length-j-1; k+=1){

                //Sorting arrays
                if(num[k]>num[k+1]){

                    //Sorting num array
                    int temp=num[k];
                    num[k]=num[k+1];
                    num[k+1]=temp;
                    
                    //Sorting char array simultaneously
                    char tempChar=arr[k];
                    arr[k]=arr[k+1];
                    arr[k+1]=tempChar;
                }}}

        //Returning the char array as a string
        return new String(arr);
    }
    
    //Main function
    public static void main(String[] args) {
        String s="AB";
        int numRows=1;
        System.out.println(convert(s,numRows));
    }
}
