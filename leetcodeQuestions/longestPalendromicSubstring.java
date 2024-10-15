package leetcodeQuestions;

public class longestPalendromicSubstring {
    
    //Function to check the longest palindromic substring
    public static String isPalindrome(String s){

        //If string has only 1 character then return the string itself
        if(s.length()==1) return s;

        //Take two pointers x and y as left and right of final substring
        int x=0,y=0,size=0;

        //For even length
        for(int i=1; i<s.length(); i+=1){

            //Take left and right pointer one before the adjacent ith index
            int curr=0,left=i-1,right=i;

            //Loop until the end of string is reached or different characters are found
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                curr+=2;
                left-=1;right+=1;
                if(curr>size){
                    size=curr; x=left+1;y=right-1;
                }
            }
        }

        //For odd length
        for(int i=1; i<s.length(); i+=1){

            //Take 1 element as already in the current and left and right as two adjacent pointer to ith index
            int curr=1,left=i-1,right=i+1;

            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                curr+=2;
                left-=1;right+=1;
                if(curr>size){
                    size=curr; x=left+1;y=right-1;
                }
            }
        }

        //Return the result
        return s.substring(x, y+1);
    }

    //Main function
    public static void main(String[] args) {
        String s="abb";
        System.out.println(isPalindrome(s));
    }
}
