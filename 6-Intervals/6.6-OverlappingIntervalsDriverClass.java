
public class DriverClass {

	  public static void main(String[] args)
	   {
	        Interval a=new Interval (1,3);
	        Interval b=new Interval (2,10);
	        Interval c=new Interval (3,14);
	        Interval []  A={a,b,c};
	        int re=Point.getOverlappingCount(A);
	        System.out.print(re);
	   }
}
/*
sorted array: 
Point [value=1, type=0]
Point [value=2, type=0]
Point [value=3, type=1]
Point [value=3, type=0]
Point [value=10, type=1]
Point [value=14, type=1]
*/
