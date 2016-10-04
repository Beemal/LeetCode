class Interval
{
	static boolean checkPairable (int [] nums,int k)
	{
		if(k<=0) return false;
		
		//额外数组保存余数情况
		int [] counts=new int [k];
		for(int num:nums)
		{
			//初始化余数数组,counts[i]保存的是余数为i的个数
			counts[num%k]++;
		}
		
		
		//整除k的个数若不是偶数，返回false
		if(counts[0]%2!=0)
			return false;
		
		//k是偶数时，查看余数为k/2的个数是否为偶数
		if(k%2==0)
		{
			if(counts[k/2]%2!=0)//如果余数为k的一半的个数不是偶数，直接返回false
				return false;
		}
		for(int i=1;i<=k/2;i++)
		{
			//余数配对
			if(counts[i]!=counts[k-i]) return false;
		}
		return true;
	}
	public static void main(String[] args)
	{
		int [] nums={2,3,4,6};
		System.out.println(checkPairable(nums,5));
	}
	
}

/*
true
*/
