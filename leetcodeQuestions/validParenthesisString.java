/*
 678. Valid Parenthesis String

 Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "(*)"
Output: true

Example 3:
Input: s = "(*))"
Output: true

Constraints:
1 <= s.length <= 100
s[i] is '(', ')' or '*'.
 */

package leetcodeQuestions;

import java.util.Stack;

public class validParenthesisString {
    
    public static boolean valid(String s){

        //Take two variables to keep track of maxOpen and minOpen brackets
        int min=0,max=0;

        //Loop through the string
        for(int i=0; i<s.length(); i+=1){

            //If it's an open bracket then increase both pointers
            if(s.charAt(i)=='(') {min+=1;max+=1;}

            //If it's a closing bracket then decrease both pointers by one
            else if(s.charAt(i)==')'){min-=1;max-=1;}

            //If it's a * then decrease min by 1 for treating it as a closing bracket and increase max by 1 for treating it as an opening bracket
            else {min-=1;max+=1;}

            //If minimum open brackets become negative then reset it to 0 by treating 1 * as an empty string
            if(min<0) min=0;

            //If maximum open brackets become negative then there are more closing brackets than opening brackets and *'s thus return false'
            if(max<0) return false;
        }

        //Now just check if minimum opening brackets is becoming 0 or not. If not then it means there are less closing brackets than opening brackets and *'s
        return min==0;
    }

    //This solution is not effective as it compensates a star for an open bracket even is the star is behind the open bracket
    //This algo will return true for *( this case though it is a not valid case that is why this algorithm produces wrong answer
    public static boolean check(String s){
        if(s.charAt(0)==')'||s.charAt(s.length()-1)=='(') return false;
        Stack<Character> star=new Stack<>();
        Stack<Character> open=new Stack<>();
        for(int i=0; i<s.length(); i+=1){
            if(s.charAt(i)=='*') star.push(s.charAt(i));
            else if(s.charAt(i)=='(') open.push(s.charAt(i));
            else if(s.charAt(i)==')'){
                if(open.isEmpty()&&star.isEmpty()) return false;
                else if(!open.isEmpty())open.pop();
                else if(!star.isEmpty())star.pop();
                }
        }
        if(open.isEmpty()) {System.out.println("Open is empty");return true;}
        System.out.println("star size:"+star.size()+" open size:"+open.size());
        return open.size()<=star.size();
    }

    //Main Function
    public static void main(String[] args) {
        String s="(()())*(()";
        // System.out.println(valid(s));
        System.out.println(check(s));
    }
}
