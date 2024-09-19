package leetcodeQuestions;
public class plusOne{

    //Function to calculate the required
    public static int[] plus(int []digits){

        //l to store length of resulting array
        int l=1;

        //Finding the length of resulting array 
        for(int i:digits){

            //If any non 9 number is there then resulting array will be of same length as digits coz extra space is required in cases
            //like 99, 999, 99999 etc.
            if(i!=9) {
                l=digits.length; break;
            }

            //else increase the count by 1
            else l+=1;
        }

        //a variable to store the length of original array
        int p=digits.length-1;

        //resulting array
        int []arr=new int [l];

        //Take carry as 1 and sum as 0
        int c=1,sum=0;

        //Iterate for resulting array
        for(int i=l-1; i>=0; i-=1){

            //update sum till valid
            if(p>=0) sum=digits[p]+c;

            //if sum is of 2 digits then reduce it to 1 digit and take an extra carry
            if(sum>9){
                arr[i]=sum%10;
                c=1;
            }

            //else take carry as 0
            else{
                arr[i]=sum; c=0;
            }

            //Reduce p
            p-=1;
        }

        //If any carry is left then there will be an extra space as well in the array so put it in first place
        if(c==1) arr[0]=1; 
        
        //Return result
        return arr;
    }

    //Main function
    public static void main(String[] args) {
        // int digits[]={7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
        int []digits={0};
        // int digits[]={9,0};
        int res[]=plus(digits);
        for(int i:res)
        System.out.print(i+" ");
    }
}