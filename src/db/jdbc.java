package db;

import java.sql.*;

public class jdbc {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement stm=null;
        ResultSet res=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","123456");
                 //stm=con.createStatement();
                //stm.execute("insert into user (user,password) values (6,'三上')");
                //res=stm.executeQuery(" select * from user where user='' or '1=1'    and password='三上'  ");//and的优先级大于or
                stm=con.prepareStatement("select * from user where user=? and password=? ");
                stm.setString(1,"6");
                stm.setString(2,"三上");
                res=stm.executeQuery();
                System.out.println(stm.toString());//把最终执行的sql语句打印出来
                while(res.next()){
//                    int id = res.getInt(1);// 获取第一个列的值 编号id
//                    String ur = res.getString(2);// 获取第二个列的值 图书名称 bookName
//                    String PW = res.getString(3);// 获取第三列的值 图书作者 author
//                    System.out.println("id="+id+" user="+ur
//                            +" passwd="+PW);
                    System.out.print(res.getString("user")+"   ");
                    System.out.println(res.getString("password"));
                    System.out.println("................................................");
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {

        }
        finally {
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
