import java.util.*;
public class Test{

    //哈希表hm初始化
     static HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();

     public static void main(String[] args)
        {

            hm.put(1,1);
            hm.put(2,1);
            hm.put(3,1);
            save(4);
            int sum=7;
            if(test(sum))
            System.out.println("存在两数之和等于"+sum);
        }

    //以下函数实现插入一个整数到一个整数集合里
    public static void save(int input){
        int originalCount=0;
        if(hm.containsKey(input)){//如果input的这个值已经在哈希表中了
            //则读取该key的个数
            originalCount=hm.get(input);//get() 的作用是获取key对应的value
        }
        hm.put(input,originalCount+1);//将这个新整数插入这个哈希表
    }

  //以下函数检验是否存在两个数和为输出值
    public static  boolean test(int target){
         boolean re=false;

        //将哈希表的key值存入迭代器
        Iterator<Integer> it=hm.keySet().iterator(); //iterator=迭代器

        while(it.hasNext()){
            int val=it.next();
            if(hm.containsKey(target-val))//如果哈希表里存在两个数之和为输出值
            {
                boolean isDouble= (target==val*2);//target是否等于两倍的某key
                //如果某数两倍为target值，那么只有该数出现两次或两次以上，才能返回true
                if(isDouble==false)
                    re=true;
                if((isDouble==true) &&(hm.get(val)>=2)) 
                    re=true;
            }
        }
        return re;
    }
}

/*
存在两数之和等于7
*/
