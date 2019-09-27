package copyTo;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;
/*
使用ThreadPool线程池（线程池大小为3）对一组数组[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
每个线程只允许随机取出1个，取出后删除直到数组为空，取出的结果重新放到另一数组中。
 */
public class copy {
    volatile static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    static int[] data = new int[arr.length];
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));
        Runnable target = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (this) {
                        if (arr.length > 0) {
                            //List list=Arrays.asList(arr); 数组转化为链表进行操作
                            int index = (int) (Math.random() * arr.length);
//                            System.out.println(arr[index]);
                            data[arr.length-1] = arr[index];
                            //把最后一个元素替代指定的元素
                            arr[index] = arr[arr.length - 1];
                            arr = Arrays.copyOf(arr, arr.length - 1);
                            try {
                                Thread.sleep(10L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            break;
                        }


                    }
                }
            };
        };
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.shutdown();
        Thread.sleep(1000l);
        for (int j = 0; j < data.length; j++) {
            System.out.print(data[j] + " ");
        }
    }

    // public synchronized void read(int )
}
