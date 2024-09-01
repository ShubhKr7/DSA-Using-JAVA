package leetcodeQuestions;
import java.util.*;

public class reversePolish {

    public static int solve(String tokens[]){

        Stack<Integer> st=new Stack<>();
        for(String val:tokens){
            if(val!="+"&&val!="-"&&val!="*"&&val!="/"){
            st.push(Integer.parseInt(val)); continue;}
            
            int digit1=st.pop();
            int digit2=st.pop();
            int cal=0;
            if(val=="+") cal=digit1+digit2;
            else if(val=="-") cal=digit2-digit1;
            else if(val=="*") cal=digit1*digit2;
            else if(val=="/") cal=digit2/digit1;
            st.push(cal);
        }
        return st.pop();
    }
    public static void main(String[] args) {
        String tokens[]={"2","1","+","3","*"};
        int res=solve(tokens);
        System.out.println("Result:"+res);
    }
}