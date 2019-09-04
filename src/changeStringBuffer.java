import java.util.HashMap;

public class changeStringBuffer {
    public static void main(String[]args){
     StringBuffer stringBuffer=new StringBuffer("hello");
     StringBuffer stringBuffer1=new StringBuffer("hello");
     chage(stringBuffer,stringBuffer1);
     stringBuffer1=stringBuffer;
        System.out.println(stringBuffer);
        System.out.println(stringBuffer1);
        System.out.println("---------------------------------------");

        int e=128;
        Integer e1=128;
        Integer e2=new Integer(128);
        System.out.println(e==e1);//true 当Integer和int类型数值进行比较的时候,Integer会自动拆箱为int再比较，所以为true
        System.out.println(e == e2);
        Integer i5=127;//ｊａｖａ在编译的时候，被翻译成－>Integer i5=Integer.valueOf(127);
        Integer i6=127;
        System.out.println(i5==i6);//true
        Integer i7=new Integer(127);
        System.out.println(i7==i5);//false
        System.out.println(7>>1);
    }
    public static void chage(StringBuffer s1,StringBuffer s2){
        s1.append("world");
        // StringBuffer s1=new StringBuffer().append("world");
        s2=s1;
        HashMap hashMap=new HashMap();
        hashMap.put(1,2);

    }
}
