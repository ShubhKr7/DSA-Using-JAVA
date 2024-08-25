class zeroAtLast{

    public static int[] sort(int nums[]){
        int j=0;
        for(int i=0;i<nums.length;i+=1){
            if(nums[i]==0) continue;
            else if(nums[i]!=0) 
                nums[j]=nums[i];
                j+=1;
        }
        for(int i=j;i<nums.length;i+=1) nums[i]=0;
        return nums;
    }
    public static void main(String[] args) {
        int nums[]={1,0,0,2,3,0,4};
        int res[]=sort(nums);
        System.out.print("Res:");
        for(int i:res)
        System.out.print(i+" ");
    }
}