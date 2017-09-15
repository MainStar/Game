package GameServer.DataBase;

import GameServer.Dao.UsersDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static final String url = "jdbc:mysql://localhost:3306/GameData";
    private static final String user = "root";
    private static final String password = "root";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    List<UsersDao> users = new ArrayList<>();

    public List<UsersDao> readTableUsers(){

        try {
            con = DriverManager.getConnection(url, user, password);

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
}
