import java.util.*;
public class Test{
    public static void main(String[] args){
        int []a=twoSum(new int[]{1, 2, 3, 4}, 4);//1+3=4
        System.out.println("下标:"+a[0]);//输出下标1
        System.out.println("下标:"+a[1]);//输出下标2
    }

    static int[] twoSum(int [] A, int target){
        int []res={-1,-1};
        //数组是否符合长度标准
        if(A==null||A.length<2) return res;//这句话每个数组题都要写
        //声明新的哈希表
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        //给新哈希表赋初值
        for(int i=0;i<A.length;i++){
            //扫描一遍，存储值与下标
            hm.put(A[i],i);//键是数组的值，值是数组的下标
        }

        for(int i=0;i<A.length;i++){
            if(hm.containsKey(target-A[i]) && target!=2*A[i]){
                //获取结果的两个下标
                res[0]=i;
                res[1]=hm.get(target-A[i]);//通过键获得值，即数组的下标
                break;
            }
        }
        return res;
    }
}
/*
 下标:0
下标:2
 */
