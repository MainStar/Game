package Dao.DataBase;

import Dao.Users.UsersDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static final String url = "jdbc:mysql://localhost:3306/GameData";
    private static final String user = "root";
    private static final String password = "root";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static PreparedStatement preparedStmt;
    private static Statement stmt;
    private static ResultSet rs;

    List<UsersDao> users = new ArrayList<>();

    public void connectDataBase() throws SQLException {
        con = DriverManager.getConnection(url, user, password);
    }

    public List<UsersDao> readTableUsers(){

        try {

            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from users");

            while (rs.next()){

                UsersDao usersDao = new UsersDao();

                int count = rs.getInt("id");
                String name = rs.getString("username");
                String password = rs.getString("password");

                usersDao.setId(count);
                usersDao.setName(name);
                usersDao.setPassword(password);

                users.add(usersDao);

                System.out.println(count);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;

    }

    public List<UsersDao> writeTableUsers(List<UsersDao> usersList) throws SQLException {

        preparedStmt = con.prepareStatement("insert into users (id, username, password) VALUES (?, ?, ?)");

        for (UsersDao el : usersList) {
            preparedStmt.setInt(1, el.getId());
            preparedStmt.setString(2, el.getName());
            preparedStmt.setString(3, el.getPassword());
            preparedStmt.executeUpdate();
        }
        usersList.clear();
        usersList = readTableUsers();
        return usersList;
    }

    public void closeDB() throws SQLException {
        preparedStmt.close();
        stmt.close();
        rs.close();
        con.close();
    }
}
