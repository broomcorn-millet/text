package org.annotation.i;

import java.util.ArrayList;
import java.util.List;
//关闭整个类里的编译器警告
@SuppressWarnings(value = "unchecked")
public class SuppressWarningsTest {
    public static void main(String[]args){
        List<> myList=new ArrayList<>();
    }
}
/*
  上述代码编译通过且可以运行，但每行前面的“感叹号”就严重阻碍了我们判断该行是否设置的断点了。这时我们可以在方法前添加 @SuppressWarnings("unused") 去除这些“感叹号”。
   关键字         用途
   deprecation   使用了不赞成使用的类或方法时的警告
   unchecked     执行了未检查的转换时的警告，例如当使用集合时没有用泛型 (Generics) 来指定集合保存的类型。
   fallthrough   当 Switch 程序块直接通往下一种情况而没有 Break 时的警告。
   path          在类路径、源文件路径等中有不存在的路径时的警告。
   serial        当在可序列化的类上缺少 serialVersionUID 定义时的警告。
   finally       任何 finally 子句不能正常完成时的警告。
   all           关于以上所有情况的警告。
 */
