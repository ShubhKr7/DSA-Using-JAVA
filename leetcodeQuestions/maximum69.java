package leetcodeQuestions;

public class maximum69 {
    
    public static int max(int n){
        int r=0;String p="";
        String s=Integer.toString(n);
        for(int i=0; i<s.length(); i+=1){
            if(s.charAt(i)=='6'&r!=10) {
                p+="9";
                r=10;
            }
            else p+=s.charAt(i);
        }
        return Integer.parseInt(p);
    }

    public static void main(String[] args) {
        int n=6969;
        int res=max(n);
        System.out.println(res);
    }
}
