package db;

import java.sql.*;

public class jdbc1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","123456");
        Statement stm=con.createStatement();
        stm.execute("insert into user (user,password) VALUES ('haha','666') ");
        ResultSet res=stm.executeQuery("SELECT * from user WHERE user='6'");
        while(res.next()){
            String sr=res.getString("user");
            String ps=res.getString(3);
            System.out.println(sr+" "+ps);
        }
        res.close();
        stm.close();
        con.close();
    }
}
