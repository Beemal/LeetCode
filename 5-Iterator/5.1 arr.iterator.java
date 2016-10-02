import java.util.*;
public class Test
{
    public static void main(String[] args)
    {
        ArrayList< String > arr = new ArrayList<String>();
        arr.add("apple");
        arr.add("banana");
        arr.add("orange");
        Iterator <String> it = arr.iterator();     
        while(it.hasNext() ){
        System.out.println( it.next() );
        }
        
    }
}
/*
apple
banana
orange
*/
