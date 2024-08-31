/*
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.

Example 1:
Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.

Example 2:
Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.*/ 
package leetcodeQuestions;
import java.util.*;
public class uglyNumber{

    public static int checkUgly(int n){
        if(n==1) return 1;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        int i=2,z=0;
        while(res.size()<n){
            checkFactors(list, i);
            for(int i1:list) if(i1>5) z=10;
            if(z==10) {z=0;i+=1;list.clear();continue;}
            if((!list.isEmpty())) res.add(i);
            list.clear();
            i+=1;
        }
        return res.get(res.size()-1);
    }

    public static void checkFactors(ArrayList<Integer>list, int n){
        for(int i=2; i<=n; i+=1){
            if(n%i==0)
                if(isPrime(i)) 
                    list.add(i);
        }
    }

    public static boolean isPrime(int n){
        for(int i=2; i<n; i+=1)
        if(n%i==0) return false;
        return true;
    }

    public static void main(String args[]){
        int n=186;
        int res=checkUgly(n);
        System.out.println("Res:"+res);
    }
}