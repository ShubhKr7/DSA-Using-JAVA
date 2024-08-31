/*
 Here we have to create a class which follows the following instructions
 1.We have to insert a value. (No duplicates allowed)
 2.Removing a value
 3.Return a random value from the inserted values.

 Here in this code snippet we will not create a separate class but we will
 create functions of that separate class.
 */

package leetcodeQuestions;
import java.util.*;

public class googleQuestion {

    class Question{

    ArrayList<Integer> list;

    Question(){
        list = new ArrayList<>();
    }

    public void insert(int n){
        if(!list.contains(n))
        list.add(n);
    }

    public void remove(int val){
        System.out.println("Value to remove:"+val);
        if(list.contains(val))  list.remove(list.indexOf(val));
    }

    public void random(){
        int r=-1;
        while(!list.contains(r))
        r=(int)Math.floor(Math.random()*100);
        System.out.println("A random value form the list:"+r); 
    }

    public void display(){
        System.out.println("All values in the list are:");
        for(int i:list) System.out.println(i);
    }
}

    public static void main(String[] args) {
        googleQuestion obj = new googleQuestion();
        Question q= obj.new Question(); 

        //Entering 10 random unique values in the ArrayList
        for(int i=1;i<=10;i+=1)
        q.insert((int)Math.floor(Math.random()*100));

        //Displaying whole list
        q.display();

        //Removing some random values from the list
        for(int i=1;i<=10;i+=1)
        q.remove((int)Math.floor(Math.random()*100));

        //New List
        System.out.println("New List is:");
        q.display();

        //Displaying 6 random values from the ArrayList
        for(int i=1;i<=6;i+=1)
        q.random();
    }

}
