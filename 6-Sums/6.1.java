import java.util.*;
public class Test{
    public static void main(String[] args){
        System.out.println(hasSum(new int[]{1, 2, 3, 4}, 4));
    }
    static boolean hasSum(int [] A, int target){
        boolean res=false;
        if(A==null||A.length<2) return res;
        Arrays.sort(A);
        int i=0;
        int j=A.length-1;
        while(i<j){
            if(A[i]+A[j]==target){
                res=true;
                break;
            }
            else if(A[i]+A[j]>target){
                j--;//目标值过小，则向前移动尾部指针，减小两数和
            }
            else{
                i++;//目标值过大，则向后移动首部指针，增加两数和
            }
        }
        return res;
    }
}

/*

true
*/
