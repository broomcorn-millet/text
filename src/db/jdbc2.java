package db;

import java.sql.*;

public class jdbc2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","123456");
        PreparedStatement pstm=con.prepareStatement("SELECT * from user WHERE user=? and password=?");
        pstm.setString(1,"haha");
        pstm.setString(2,"666");
        ResultSet res=pstm.executeQuery();
        System.out.println(pstm.toString());
        while(res.next()){
            System.out.println(res.getString("user")+"      "+res.getString("password"));
        }
        res.close();
        pstm.close();
        con.close();

    }
}
