import java.util.Arrays;

public class GetClosestBigger{
	
	static public void  main(String [] args)
	{
		int [] a={3,8,3,4,5};
		System.out.println("next to integer ");
		int [] b={2,3,4,8,1};
		int []c=getClosestBigger(a,b);
		for(int i=0;i<c.length;i++)
			System.out.print(c[i]);
		
	}
	
	static int [] getClosestBigger(int []x ,int [] y)
	{
		int r=0;	
		boolean [] isUsed=new boolean [x.length];
		int re[]=new int[x.length];
		for(int i=0;i<isUsed.length;i++)
			isUsed[i]=false;
		
		Arrays.sort(x);
		
		
		for(int i=0,j=0;j<x.length;i++,j++)
		{
			if(isUsed[i]=false)
			{
				if(x[i]==y[j])
				{
					isUsed[i]=true;
					re[r++]=x[i];
					continue;
				}
				else if(x[i]>y[j])
				{
					isUsed[i]=true;
					re[r++]=x[i];
					for(int p=0;p<x.length;p++)
						if(isUsed[p]=false)	
							re[r++]=x[p];
				}
				else
				{
					j--;
					
				}
				
				if(i==4)
					i=0;	
			}
			
		}
		
		return x;
	}
}
