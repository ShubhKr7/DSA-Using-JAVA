package leetcodeQuestions;
import java.util.*;

public class reversePolish {

    //To solve the given polish notation
    public static int solve(String tokens[]){

        //Stack to store elements
        Stack<Integer> st=new Stack<>();
        for(String val:tokens){
            if(val!="+"&&val!="-"&&val!="*"&&val!="/"){
            st.push(Integer.parseInt(val));
            //if number inserted then continue to next value
            continue;}
            
            //calculating the given operation
            int digit1=st.pop();
            int digit2=st.pop();
            int cal=0;
            if(val=="+") cal=digit1+digit2;
            else if(val=="-") cal=digit2-digit1;
            else if(val=="*") cal=digit1*digit2;
            else if(val=="/") cal=digit2/digit1;
            //Pushing answer into the stack
            st.push(cal);
        }
        //Returning the final result
        return st.pop();
    }

    //Main function
    public static void main(String[] args) {
        //Making an array of strings
        String tokens[]={"2","1","+","3","*"};

        //SOlving the notation
        int res=solve(tokens);

        //Displaying result
        System.out.println("Result:"+res);
    }
}