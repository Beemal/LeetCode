import java.util.*;
public class Interval{
    int start;
    int end;
    Interval(int a,int b)//构造函数
    {
        start=a;
        end=b;
    } 
    
    static Comparator <Interval> comparator=new Comparator <Interval> ()
	{
		@Override
		public int compare(Interval a, Interval b)
		{
			if(a.start<b.start) return -1;
			else if(a.start>b.start) return 1;
			else
			{
				//start值相同，还要比较end
				if(a.end<b.end) return -1;
				else if(a.end>b.end) return 1;
				else return 0;	
			}
		}
	};

    static  ArrayList <Interval> merge (ArrayList <Interval> intervals)//合并Interval
    {
    	ArrayList <Interval> res=new ArrayList <Interval> ();
    	if(intervals==null|| intervals.isEmpty())
    	return res;//不用再写res=null;因为本来没赋值的话就是null
    	
    	
    		
    		//调用java排序函数
    	    //1. 对集合进行排序，这样就是我们认为的数法，这样就不会出现我自己编程的问题了
    		Collections.sort(intervals,comparator);
    		
    		//2. 处理
    		for(int i=0;i<intervals.size();i++)//这是ArrayList数个数的方法
    		{
    			Interval current=intervals.get(i);//得到当前的Interval进行处理
    			if(res.isEmpty())//放一个在空的里面
    			{
    				res.add(current);
    			}
    			else
    			{
    				//这样定义很清楚处理的是哪个Interval
    				Interval last=res.get(res.size()-1);//得到res的最后一个保存的区间
    				if(last.end>=current.start)//有前后重合的情况
    				{
    					last.end=Math.max(last.end,current.end);//应该是把res里面的最后一个的end值也改了
    				}
    				else
    				{
    					res.add(current);//不重合
    				}
    			}
    		}
    			return res;
    	}
    	
    	  public static void main(String[] args)
    	    {
    	    	
    	    	Interval a=new Interval (1,5);
    	    	Interval b=new Interval (6,10);
    	    	Interval c=new Interval (5,6);
    	    	Interval d=new Interval (15,20);
    	    	ArrayList <Interval> Ori=new ArrayList <Interval>();
    	    	Ori.add(a);
    	    	Ori.add(b);
    	    	Ori.add(c);
    	    	Ori.add(d);
    	    	ArrayList <Interval> Re=Interval.merge(Ori);
    	    	for(int i=0;i<Re.size();i++)
    	    	{
    	    		System.out.println("["+ Re.get(i).start+","+Re.get(i).end+"]");
    	    		
    	    	}
    	    	
    	    }
    
}

/*
[1,10]
[15,20]
*/
