/*
 You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1
 */

package leetcodeQuestions;

public class containerWithMostWater {

    public static int calcHeight(int height[]){
        int p=0,q=height.length-1,res=0;
        int water=Math.min(height[p],height[q])*(q-p);
        while(p<q){
            water=Math.min(height[p],height[q])*(q-p);
            System.out.println("water is:"+water);
            res=Math.max(res, water);
            if(height[p]<height[q]) p+=1;
            else q-=1;
        }
        return res;
    }

    public static void main(String[] args) {
        int height[]={2,3,4,5,18,17,6};
        int res= calcHeight(height);
        System.out.println("Res:"+res);
    }
}
