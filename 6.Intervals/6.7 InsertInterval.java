import java.util.*;
class Interval{
    int start;
    int end;
    Interval(int a,int b)//构造函数
    {
        start=a;
        end=b;
    }
    
    //实现合并新旧区间功能的函数
    static ArrayList <Interval> insert (Interval [] intervals, Interval newInt)
    {
    	ArrayList <Interval> res=new ArrayList <Interval>();//返回值
    	
    	if(intervals==null)
    		
    	{
    		//输出是null，那么直接返回新区间
    		res.add(newInt);//好感动，ArrayList.add()这么容易
    		return res;
    	}
    	
    	int i=0;
    	int n=intervals.length;//数组.length统计数组长度
    	
    	//新区间的起点大于前面的几个原有区间的终点
    	while(i<n&&newInt.start>intervals[i].end)
 
    	{
    		res.add(intervals[i]);	
    		i++;
    	}
    	
    	//存在重叠的区间，即越过了前面的几个小区间后，新区间的终点大于后面这个区间的起点，有重叠部分了
    	while(i<n&&newInt.end>=intervals[i].start)
    	{
    		
    		newInt.end=Math.max(newInt.end,intervals[i].end);//取较大值为终点
    		newInt.start=Math.min(newInt.start,intervals[i].start);//取较小值为起点
    		i++;
    	}
    	//加上合并后的新区间
    	res.add(newInt);
    	
    	
    	//加上剩余的部分，如果有的话
        while(i<n)
        {
        	res.add(intervals[i]);
        	i++;
        }
        return res;
    }
    
    public static void main(String[] args)
    {
    	
    	Interval a=new Interval (1,3);
    	Interval b=new Interval (6,10);
    	Interval c=new Interval (11,14);
    	Interval []  A={a,b,c};
    	Interval B=new Interval (4,6);
    	ArrayList <Interval> Re=insert(A, B);
    	for(int i=0;i<Re.size();i++)
    	{
    		System.out.println(Re.get(i));
    	}
    	
    }

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}

}

/*
Interval [start=1, end=3]
Interval [start=4, end=10]
Interval [start=11, end=14]

*/
