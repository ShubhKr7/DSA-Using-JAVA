/*
 57. Insert Interval

You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

Constraints:
0 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^5
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 10^5
 */

package leetcodeQuestions;
public class insertInterval{

    //Function to insert new interval into the given intervals
    static int[][] insert(int[][] intervals, int[] newInterval) {
        int i=0;
        int start=newInterval[0];
        int end=newInterval[1];
        int j=0;
        int[][] res=new int[intervals.length+1][2];

        //Insert all the intervals that are before the new interval
        while(i<intervals.length && intervals[i][1]<start){
            res[i]=intervals[i];
            i+=1;
            j+=1;
        }

        //Merge the new interval with the overlapping intervals
        while(i<intervals.length && intervals[i][0]<=end){
            start=Math.min(start,intervals[i][0]);
            end=Math.max(end,intervals[i][1]);
            i+=1;
        }

        //Insert the new merged interval
        res[j][0]=start;
        res[j][1]=end;

        //Insert all the intervals that are after the new interval
        while(i<intervals.length){
            res[j+1]=intervals[i];
            i+=1;
            j+=1;
        }

        //Now remove the extra zeros from the result
        int k=0;
        for(k=res.length-1;k>-1;k-=1){
            if(res[k][0]!=0 || res[k][1]!=0)
                break;
        }

        //If the array contains only zeros then return result array itself
        if(k<0) return res;
        int a[][]=new int[k+1][2];
        for(int l=k;l>-1;l-=1){
            a[l]=res[l];
        }

        //Else return the new array after removing the leading zero value pairs
        return a;
    }

    //Main Function
    public static void main(String[] args) {
        int[][] intervals={{1,5}};
        int[] newInterval={0,3};
        int[][] res=insert(intervals,newInterval);
        for(int i[]:res){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}