package leetcodeQuestions;

import java.util.*;

public class uncommonWords {

    public static String[] uncommon(String s1, String s2){

        String a[]=s1.split(" ");
        String b[]=s2.split(" ");
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<a.length; i+=1){
            if(map.containsKey(a[i])) map.put(a[i], map.get(a[i])+1);
            else map.put(a[i], 1);
        }

        for(int i=0; i<b.length; i+=1){
            if(map.containsKey(b[i])) map.put(b[i], map.get(b[i])+1);
            else map.put(b[i], 1);
        }        

        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String,Integer> entry: map.entrySet())
            if(entry.getValue()==1) list.add(entry.getKey());
            
        String res[]=new String[list.size()];
        for(int i=0; i<list.size(); i+=1) res[i]=list.get(i); 

        return res;
    }

    public static void main(String[] args) {
        String a="this apple is sweet";
        String b="this apple is sour";
        String res[]=uncommon(a,b);
        for(String i:res)
        System.out.print(i+" ");
    }
}
