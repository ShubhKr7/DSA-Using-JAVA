package leetcodeQuestions;
public class scoreOfAString {
    
    //Function to find score
    public static int score(String s){

        //Variable to store res and and a pointer from start
        int res=0; int j=0;

        //Loop through the string from second element to end
        for(int i=1; i<s.length(); i+=1){

            //Store the addition of absolute difference
            res+=(Math.abs(s.charAt(j)-s.charAt(i)));j+=1;}

        //Return result
        return res;
    }

    //Main function
    public static void main(String[] args) {
        String s="hello";
        System.out.println("Score:"+score(s));
    }
}
