package leetcodeQuestions;
import java.util.*;

public class longestConsecutive {
    
    public static int solve(int []nums){
        if(nums.length==0) return 0;
        int res=0,max=nums[0],n=0;
        HashMap<Integer,Boolean> list=new HashMap<>();
        for(int i:nums) list.put(i, false);
        System.out.println(list.size());
        for(int i=0;i<nums.length;i+=1){
            max=nums[i];
            while(list.containsKey(max))  { 
                max+=1;n+=1;
            System.out.println("max and n:"+max+" "+n);}
                res=Math.max(n, res);
                n=0;
            }
        return res;
    }

    public static void main(String[] args) {
        int nums[]={0,0,-1};
        int res=solve(nums);
        System.out.println("Res:"+res);
    }
}
