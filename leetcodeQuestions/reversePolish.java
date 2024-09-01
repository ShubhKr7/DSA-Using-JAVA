package leetcodeQuestions;
import java.util.*;

public class reversePolish {

    public static int solve(String tokens[]){
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        if(b==0) return 0;
                        stack.push((int)(a / b));
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        if(list.contains(3)) System.out.println("Element Exists!");

        return stack.pop();

        // Stack<Integer> st=new Stack<>();
        // for(String val:tokens){
        //     if(val!="+"&&val!="-"&&val!="*"&&val!="/"){
        //     st.push(Integer.parseInt(val)); continue;}
            
        //     int digit1=st.pop();
        //     int digit2=st.pop();
        //     int cal=0;
        //     if(val=="+") cal=digit1+digit2;
        //     else if(val=="-") cal=digit2-digit1;
        //     else if(val=="*") cal=digit1*digit2;
        //     else if(val=="/") cal=digit2/digit1;
        //     st.push(cal);
        // }
        // return st.pop();
    }
    public static void main(String[] args) {
        String tokens[]={"2","1","+","3","*"};
        int res=solve(tokens);
        System.out.println("Result:"+res);
    }
}