package leetcodeQuestions;

public class addingSpacesToAString {

    static String addSpaces(String s, int []spaces){
        // String res=""; int k=0;

        //This approach is giving TLE
        // for(int i:spaces){
        //     res+=s.substring(k,i)+" ";
        //     k=i;
        // }
        // return res+s.substring(k, s.length());

        //Better Approach
        StringBuilder sb=new StringBuilder();

        sb.append(s.substring(0,spaces[0]));
        int i=1;
        for(; i<spaces.length; i++){
            sb.append(" ");
            sb.append(s.substring(spaces[i-1],spaces[i]));            
        }
        sb.append(" ");
        sb.append(s.substring(spaces[i-1])); 

        return sb.toString();
    }
    

    public static void main(String[] args) {
        // String s="icodeinpython"; int []spaces={1,5,7,9};
        String s="spacing"; int []spaces={0,1,2,3,4,5,6};
        System.out.print(addSpaces(s,spaces));
    }
}
