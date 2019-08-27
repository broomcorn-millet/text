import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*迭代器应用　Iterator是Java迭代器最简单的实现，为List设计的ListIterator具有更多的功能，
 它可以从两个方向遍历List，也可以从List中插入和删除元素。*/
public class Iteratordemo {
    public static void main(String[]args){
        List list=new ArrayList();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        for(Iterator iter=list.iterator();iter.hasNext();){
            String str=(String)iter.next();
            System.out.println(str);
        }
    }
}
