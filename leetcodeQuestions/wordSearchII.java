package leetcodeQuestions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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
                for(boolean[] z:visited) for(int l=0;l<z.length;l+=1) z[l]=false;
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

    //There is another solution which is by implementing the trie data structure and it goes like this
    static class TrieNode{
        TrieNode links[]=new TrieNode[26];
        String word;
    }

    static TrieNode buildTrie(String []words){
        TrieNode root=new TrieNode();
        for(String word:words){
            TrieNode curr=root;
            for(char ch:word.toCharArray()){
                if(curr.links[ch-'a']==null) curr.links[ch-'a']=new TrieNode();
                curr=curr.links[ch-'a'];
            }
            curr.word=word;
        }
        return root;
    }

    static List<String> possible(char[][]mat, String []words){
        TrieNode root=buildTrie(words);
        HashSet<String> set=new HashSet<>();

        for(int i=0;i<mat.length;i+=1){
            for(int j=0;j<mat[0].length;j+=1){
                dfs(i,j,root,mat,set);
            }
        }
        List<String> res= new ArrayList<String>(set);
        Collections.sort(res);
        return res;
    }

    static void dfs(int i, int j, TrieNode root, char [][]mat, HashSet<String> set){
        if(i<0||j<0||i>mat.length-1||j>mat[0].length-1) return;
        char ch=mat[i][j];
        if(ch=='#'||root.links[ch-'a']==null) return;
        root=root.links[ch-'a'];
        if(root.word!=null) set.add(root.word);
        mat[i][j]='#';
        dfs(i,j+1,root,mat,set); //left
        dfs(i, j-1, root, mat, set); //right
        dfs(i-1, j, root, mat, set); //up
        dfs(i+1, j, root, mat, set); //down
        mat[i][j]=ch;
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
        // System.out.println(findWords(mat,word));
        System.out.println(possible(mat, word));
    }
}
