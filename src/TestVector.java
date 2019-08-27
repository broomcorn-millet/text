import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
//Vector是有序的，可以重复的。
public class TestVector {
    public static void main(String[]args){
           new TestVector().test01();
    }

    private void test01() {
        Vector<String> hs=new Vector<String>();
        hs.add("aa");
        hs.add("bb");
        hs.add("dd");
        hs.add("cc");
        hs.add("aa");
        hs.add("dd");
        printSet2(hs);
        System.out.println("---------------------");
        printSet(hs);
    }
  private void printSet(List hs){
        Iterator iterator=hs.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

  }
/*
   此方法将向量对象对应到一个枚举类型。java.util包中的其他类中也都有这类方法，以便于用户获取对应的枚举类型。
   在Enumeration中封装了有关枚举数据集合的方法。
  　　方法 hasMoreElement() 来判断集合中是否还有其他元素。
        方法 nextElement() 来获取下一个元素
 */
    private void printSet2(Vector<String> hs) {
        Enumeration<String> element=hs.elements();
        while(element.hasMoreElements()){
            System.out.println(element.nextElement());
        }
    }
}
