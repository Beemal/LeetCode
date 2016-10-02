public class Test{
    public static void main(String[] args){
        int a[]={1,2,3,4,5};
        int b[]= rotateK(a,2);
        for(int i=0;i<b.length;i++)
        System.out.println(b[i]);
    }

    static int [] rotateK(int [] A, int k){
        if(A==null|| k>=A.length) return A;

        int []B=new int [A.length];
        //后面k个复制到前面
       System.arraycopy(A,A.length- k, B, 0, k);
        //前面的a.length-1-k个复制到后面
       System.arraycopy(A, 0, B, A.length-k-1, A.length-k);
        return B;
    }
}
/*
4
5
1
2
3
 */
