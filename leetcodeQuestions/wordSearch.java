/*
 79. Word Search

 Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

Constraints:
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.

Follow up: Could you use search pruning to make your solution faster with a larger board?
 */

package leetcodeQuestions;
public class wordSearch {

    public static boolean exist(char[][] board, String word) {
        boolean res=false;
        for(int i=0;i<board.length;i+=1){
            for(int j=0;j<board[0].length;j+=1){
                res=recur(board,i,j,word,0,res);
                if(res==true) return true;
            }
        }
        return false;
    }

    static boolean recur(char [][]board, int i, int j, String word, int idx, boolean res){
        if(i<0||j<0||i>=board.length||j>=board[0].length) return false;
        if(idx==word.length()) return true;
        if(board[i][j]==word.charAt(idx)){
            char ch=board[i][j];
            board[i][j]='*';
            res= recur(board,i,j+1,word,idx+1,res); //right
            // board[i][j]=ch;
            res=recur(board,i,j-1,word,idx+1,res); //left
            // board[i][j]=ch;
            res=recur(board,i-1,j,word,idx+1,res); //up
            // board[i][j]=ch;
            res=recur(board,i+1,j,word,idx+1,res); //down
            board[i][j]=ch;
        }
        return false;
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
        String word="eaabcdgfa";
        // String []word={"aaaaa"};
        // System.out.println(findWords(mat,word));
        System.out.println(exist(mat, word));
    }
}
