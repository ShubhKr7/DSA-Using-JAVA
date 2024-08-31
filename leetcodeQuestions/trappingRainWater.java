/*
 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
 */

package leetcodeQuestions;

public class trappingRainWater {

    public static int calcWater(int []height){
        int left[]=new int[height.length];int right[]=new int[height.length];
        left[0]=height[0]; right[height.length-1]=height[height.length-1];

        //Making an which has highest height from left
        for(int i=1;i<height.length;i+=1)
            left[i]=Math.max(left[i-1],height[i]);
        
        //Making an array which has highest height from right
        for(int i=height.length-2;i>=0;i-=1)
            right[i]=Math.max(right[i+1],height[i]);
        
        //Finding amount of water stored at each index 
        for(int i=0; i<height.length;i+=1){
            int min=Math.min(left[i],right[i]);
            left[i]=min-height[i];
            if(i>0)
            left[i]+=left[i-1];
        }
        return left[left.length-1];
    }

    public static void main(String[] args) {
        int height[]={3,1,2,4,0,1,3,2};
        int res=calcWater(height);
        System.out.println("Res:"+res);
    }
}
