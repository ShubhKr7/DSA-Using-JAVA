/*
 875. Koko Eating Bananas

Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. 
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23

Constraints:
1 <= piles.length <= 10^4
piles.length <= h <= 10^9
1 <= piles[i] <= 10^9
 */

package leetcodeQuestions;

public class koko{

    //Function to find the minimum eating speed
    public static int minEatingSpeed(int []piles, int h){
        int maxSpeed=0,minSpeed=1,res=0;

        //Finding the maximum eating speed which will be the highest value in the array
        for(int i:piles) maxSpeed=Math.max(i,maxSpeed);

        //Now we are using this formula toh find the mid to avoid overflow conditions
        int midSpeed=minSpeed+(maxSpeed-minSpeed)/2;

        //Looping till we find the needed value or start exeeds last
        while(maxSpeed>=minSpeed){

            //Updating mid value
            midSpeed=minSpeed+(maxSpeed-minSpeed)/2;

            //Calling time function to find the time needed at the required
            int time=Time(midSpeed,piles);

            //The minimum time required will be at least the size of array coz no time is possible lesser than the size of array
            if(time<piles.length) break;

            //Update the required values according to our needs according to binary search requirements
            if(time<=h){res=midSpeed;maxSpeed=midSpeed-1;}
            else minSpeed=midSpeed+1;
        }

        //Returning result
        return res;
    }

    //Function to find the time required to eat all bananas in the array at a particular speed
    static int Time(int midSpeed,int []piles){
        int speed=0;

        //Loop through the array
        for(int i=0; i<piles.length; i+=1){

            //Time required to eat bananas will be the multiple of that number
            int n=piles[i];

            //Adding speed to result
            speed+=n/midSpeed;

            //If there is any remainder then it will take an hour extra so we are adding that extra hour
            if(n%midSpeed!=0) speed+=1;
        }

        //Returning the resulting speed
        return speed;
    }

    //Main function
    public static void main(String[] args) {
        // int piles[]={3,6,7,11}; int h=8;

        // int []piles={30,11,23,4,20}; int h=5;

        // int piles[]={70}; int h=7;

        int piles[]={805306368,805306368,805306368}; int h=1000000000;
        System.out.println(minEatingSpeed(piles,h));
    }
}