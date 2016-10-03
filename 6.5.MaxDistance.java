public class Test{
    public static void main(String[] args){
        int a[]={1,2,3,4,0};
        int b= K(a);
        System.out.println(b);
    }

    static int K(int [] A){

        if(A==null) return -1;
        int max=0;
        for(int i=0;i<A.length;i++)
        for(int j=A.length-1;j>i;j--)
        // for(int i=0;i<A.length;i++)//这么写也可以
        //for(int j=i+1;j<A.length;j++)
        {
            if(A[i]<A[j]){
                if(max<j-i)
                max=j-i;
            }
        }
        return max;
    }
}
/*
3
*/
