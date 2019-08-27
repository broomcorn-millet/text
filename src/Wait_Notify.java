import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Wait_Notify{




    //生产者
    static class Producer  implements Runnable {
  private final Vector shareQueue;
  private final int Size;

    public Producer(Vector shareQueue, int size) {
        this.shareQueue = shareQueue;
        Size = size;
    }

    @Override
    public void run() {
     for(int i=0;i<7;i++){
         System.out.println("Prouced"+i);
         try {
             produce(i);
         } catch (InterruptedException e) {
             Logger.getLogger(Producer.class.getName()).log(Level.SEVERE,null,e);
         }
     }

    }
    private void produce(int i) throws InterruptedException {
        while (shareQueue.size()==Size){
            synchronized (shareQueue){
                System.out.println("Queue is full"+Thread.currentThread().getName()+"is waiting<size"+shareQueue.size());
                shareQueue.wait();
            }
        }
        synchronized (shareQueue){
            shareQueue.add(i);
            shareQueue.notifyAll();
        }
    }
}
//消费者
static class Consumer implements Runnable{
     private final Vector sharedQueue;
     private final  int Size;
     public Consumer(Vector sharedQueue, int size){
         this.sharedQueue = sharedQueue;
         Size = size;
     }
    @Override
    public void run() {
        while (true){
            try{
                System.out.println("Consumer:"+consume());
            } catch (InterruptedException e) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE,null,e);
            }
        }
    }

    private int consume() throws InterruptedException {
        while(sharedQueue.isEmpty()){
            synchronized (sharedQueue){
                System.out.println("Queue is empty"+Thread.currentThread().getName()+"is waiting<size:"+sharedQueue.size());
                sharedQueue.wait();
            }}
            synchronized (sharedQueue){
                sharedQueue.notifyAll();
                return (Integer)sharedQueue.remove(0);
            }
        }

}
public static void main(String[]args){
      Vector sharedQueue =new Vector();
      int size=4;
      Thread prodaThread=new Thread(new Producer(sharedQueue,size),"Producer");
      Thread consThread=new Thread(new Consumer(sharedQueue,size),"Consumer");
      prodaThread.start();
      consThread.start();
}



}
