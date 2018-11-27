package dataBase;

import java.sql.*;

/**
 * @Author: majunsheng
 * @Date: 2018/11/27
 **/
public class test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, "root", "root");
        String sql = "select * from user";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            System.out.println(rs.getString("username"));
        }

    }
}
