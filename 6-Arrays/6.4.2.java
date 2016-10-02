import java.util.*;
public class Test{
    public static void main(String[] args){
        int a[]={1,2,3,4,5};
        rotateK(a,2);
        for(int i=0;i<a.length;i++)
        System.out.println(a[i]);
    }

    static int [] rotateK(int [] A, int k){
        if(A==null|| k>=A.length) return A;
        reverse(A,0,A.length-1);//反转整个数组
        reverse(A,0,k-1);//反转前k个数
        reverse(A,k,A.length-1);//反转剩下的数
        return A;
    }

    //辅助函数，反转从start到end的数
    static  void reverse (int [] A,int start,int end){
        while(start<end){
            //交换A[start]和A[end]两个数
            int temp=A[start];
            A[start]=A[end];
            A[end]=temp;
            start++;
            end--;
        }
    }
}
/*
4
5
1
2
3
 */
