package testProject;

import java.util.*;

class Point implements Comparable <Point>//implements就是接口咯？
{
    int value;//数值
    int type;//点的类型，0为起点，1为止点
    Point(int v,int t)//构造函数，这个点的形式很怪，不要和xy坐标混了
    {
        value=v;
        type=t;
    }

    //实现CompareTo函数，以便排序，是不是这一步用到 Arrays.sort(points)
    public int compareTo(Point p)
    {
        if(this.value==p.value){
            return p.type-this.type;
        }
        else if(this.value>p.value){
            return 1;
        }
        else{
            return -1;
        }
    }

    public static  int getOverlappingCount(Interval [] A)
    {

        int loap=0, count=0;

      //如果Interval组为空或长度为0，返回0
        if(A==null||A.length==0) return loap;

        //保存点的数组的长度是保存Interval的数组的长度的两倍
        Point[] points=new Point[A.length*2];

        for(int i=0;i<A.length;i++){//将Interval里的起止位置转为可排序的点

            points[2*i]=new Point(A[i].start,0);//偶数位置是起点

            points[2*i+1]=new Point(A[i].end,1);//奇数位置是止点

        }  

        Arrays.sort(points);//排序 ,这样点就不是成组出现的了
        System.out.println("sorted array: ");
        for(int i=0;i<points.length;i++)
        	System.out.println(points[i]);

        for(int i=0;i<points.length;i++)
        {       
            if(points[i].type==0)//如果这个点是起点
            {

                count++;// 到起点时，count加一，表示进入区间；当遇到止点时，count减一，表示离开区间。

                if(count > 1)//如果遇到超过一个起点

                {
                    if(loap== 0)
                        loap=2;//头一次的count>1会产生两个和对方有重叠的区间
                    else
                        loap+= 1; 
                } 
            }  

            else//如果这个点是止点
            {           
                count--;       
            }  
        }  
        return loap;
    }


   @Override

   public String toString() {
	
	   return "Point [value=" + value + ", type=" + type + "]";
   }
   
}
