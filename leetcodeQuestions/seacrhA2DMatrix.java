package leetcodeQuestions;

public class seacrhA2DMatrix {
    
    public static boolean search(int [][]matrix, int target){
        boolean res=false;
        for(int i=0;i<matrix.length; i+=1){
            if(matrix[i][matrix[0].length-1]<target) continue;
            int n=0;
            while(n<matrix[0].length){
                if(matrix[i][n]==target) return true;
                n+=1;
            }}
        return res;
    }

    public static void main(String[] args) {
        int nums[][]={{1,3,5,7},{10,11,16,-10},{23,30,34,60}}; int target = -10;
        boolean res = search(nums,target);
        System.out.println("Res:"+res);
    }
}
