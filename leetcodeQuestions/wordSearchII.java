package leetcodeQuestions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class wordSearchII {


    //This solution works for 63/65 test cases and for last 2 testcases will produce TLE which means this is the right solution for most of the small testcases
    public static List<String> findWords(char[][] mat, String[] words) {
        int res=0,k=0;List<String> result=new ArrayList<>();
        while(k<words.length){
            String s=words[k];
        for(int i=0;i<mat.length;i+=1){
            for(int j=0;j<mat[0].length;j+=1){
                boolean visited[][]=new boolean[mat.length][mat[0].length];
                for(boolean[] z:visited) for(boolean val:z) val=false;
                visited[i][j]=true;
                res=Math.max(res,recur(mat,s,0,i,j,visited));
            }
        }k+=1;
        if(res==1)result.add(s);
        res=0;
        }
         Collections.sort(result);
        return result;
    }
    public static int recur(char [][]mat,String word,int idx,int i,int j, boolean visited[][]){
        if(idx>=word.length()) return 1;
        if(i<0||j<0||i>mat.length-1||j>mat[0].length-1) return 0;
        int res=0;
        if(mat[i][j]==(word.charAt(idx))){
            if(j+1<mat[0].length&&visited[i][j+1]==false){
                visited[i][j]=true;
            res=Math.max(res,recur(mat,word,idx+1,i,j+1,visited));
                visited[i][j]=false;}
            if(i+1<mat.length&&visited[i+1][j]==false){
                visited[i][j]=true;
            res=Math.max(res,recur(mat,word,idx+1,i+1,j,visited));
            visited[i][j]=false;}
            if(j-1>=0&&visited[i][j-1]==false){
                visited[i][j]=true;
            res=Math.max(res,recur(mat,word,idx+1,i,j-1,visited));visited[i][j]=false;}
            if(i-1>=0&&visited[i-1][j]==false){
                visited[i][j]=true;
            res=Math.max(res,recur(mat,word,idx+1,i-1,j,visited));visited[i][j]=false;}
            if(idx==word.length()-1) return 1;
            if(res==1) return res;
        }
        return res;
    }

    
    public static void main(String[] args) {
        // char mat[][]={
        //                 {'x','x','c','d'},
        //                 {'x','x','b','a'}};
        // char mat[][]={{'a','b'},
        //                 {'c','d'}};
        // char mat[][]={{'a','a'},{'a','a'}};
        char mat[][]={{'a','b','c'},
                      {'a','e','d'},
                      {'a','f','g'}};
        
        // System.out.println("Enter the word:");
        String word[]={"abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade","aaaaa"};
        // String []word={"aaaaa"};
        System.out.println(findWords(mat,word));
    }
}
