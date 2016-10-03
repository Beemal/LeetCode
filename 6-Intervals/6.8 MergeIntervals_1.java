import java.util.*;

class Interval{
    int start;
    int end;
    Interval(int a,int b)//构造函数
    {
        start=a;
        end=b;
    }
        
}

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
            return 0;
        }
        else if(this.value>p.value){
            return 1;
        }
        else{
            return -1;
        }
    }
    //实现合并区间功能的函数
    static ArrayList <Interval> merge(Interval [] A)
    {
    	int start=-1, end=-1 ,count=0;
    	ArrayList <Interval> res=new ArrayList <Interval>();//返回值
    	
    	if(A==null)
    	{
    		//输出是null，那么直接返回新区间
    		res=null;
    		 return res;
    	}
    	
    	 Point[] points=new Point[A.length*2];

         for(int i=0;i<A.length;i++){//将Interval里的起止位置转为可排序的点

             points[2*i]=new Point(A[i].start,0);//偶数位置是起点

             points[2*i+1]=new Point(A[i].end,1);//奇数位置是止点

         }  
         
         Arrays.sort(points);//排序 ,这样点就不是成组出现的了
         
       //code here
         for(int i=0;i<points.length;i++)
         {      
        	
        	 if(points[i].type==0)//如果这个点是起点
             {

                 count++;// 到起点时，count加1，表示进入区间；当遇到止点时，count减1，表示离开区间。

                 if(count > 1)//两个起点

                 {
                	 start=Math.min(points[i].value, start);
            
                 } 
                 
                 else
                	 start=points[i].value;
             }  

             else//如果这个点是止点
             {           
                 count--; 
                 
                 if(count==0)//区间结束了
                 {
                	 if(i+1<points.length)//还有下一个区间
                		 
                	 {
                		 if(points[i].value!=points[i+1].value)//下一个区间的起点不等于上一个的终点
                		 {
                		 end=Math.max(points[i].value, end);
                		 res.add( new Interval(start, end));
                		 }
                		 else//起点终点重合
                			 end=points[i].value;
                	 }
                	 
                	 else if(i+1==points.length)//没有下一个区间了
                	 {
                		 end=points[i].value;
                		 res.add( new Interval(start, end));
                	 }
                	 
                 }
                 else//	区间没结束
                 {
                	 end=points[i].value;
                 }
                	
                     
             }                
         }      
        return res;
    }
    
    public static void main(String[] args)
    {
    	
    	Interval a=new Interval (1,5);
    	Interval b=new Interval (6,10);
    	Interval c=new Interval (5,11);
    	Interval d=new Interval (15,20);
    	Interval []  A={a,b,c,d};
    	ArrayList <Interval> Re=Point.merge(A);
    	for(int i=0;i<Re.size();i++)
    	{
    		System.out.println("["+ Re.get(i).start+","+Re.get(i).end+"]");
    	}
    	
    }
    
}

/*
[5,11]
[15,20]
*/
