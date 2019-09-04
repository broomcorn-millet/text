package HashMap;

import java.util.HashMap;

public class Demo {
    private  static HashMap<Integer,String> map=new HashMap<Integer,String>(2,0.75f);
    //其中，map初始化为一个长度为2的数组，loadFactor=0.75，threshold=2*0.75=1，也就是说当put第二个key的时候，map就需要进行扩容。

    public static void main(String[]args) throws InterruptedException {
          map.put(5,"c");
        Thread b = new Thread("Thread1") {
            @Override
            public void run() {
                map.put(7, "b");
                System.out.println(map);
            }
        };
        b.start();

        Thread a = new Thread("Thread2") {
            @Override
            public void run() {
                map.put(3, "A");
                System.out.println(map);
            }
        };
        a.start();
        b.join();
        a.join();

        System.out.println(map.size());
    }

}
