package myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {
    private String url = "jdbc:postgresql://127.0.0.1:5432/test";
    private String username = "feng";
    private String password = "111111";
    private Connection conn = null;

    public Connection getConn() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            conn = DriverManager.getConnection(url, username, password);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet query(Connection conn, String sql) {
        PreparedStatement pStatement = null;
        ResultSet rst = null;
        try {
            pStatement = conn.prepareStatement(sql);
            rst = pStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rst;
    }

    public boolean queryUpdate(Connection conn, String sql) {
        PreparedStatement pStatement = null;
        int rs = 0;
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (rs > 0 ) {
            return true;
        }
        return  false;
    }

    public static void main(String[] args) throws SQLException {
        Application app = new Application();
        Connection myconn = app.getConn();
        app.queryUpdate(myconn, "create table people (id SERIAL primary key, name varchar(20), gender varchar(10))");
        app.queryUpdate(myconn, "insert into people(name,gender) values('smoon', 'man')");
        ResultSet rst = app.query(myconn, "select * from people");
        while (rst.next()) {
            int id = rst.getInt("id");
            String name = rst.getString("name");
            String gender = rst.getString("gender");
            System.out.println("id: " + id + " name: " + name + " gender: " + gender);
        }
        app.queryUpdate(myconn, "drop table people");
        myconn.close();
    }
}
