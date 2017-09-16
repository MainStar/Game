package GameServer.ServerAction;

import Dao.DataBase.DataBase;
import Dao.Users.UsersDao;

import java.sql.SQLException;
import java.util.List;

public class AutorizationRegistration {

    DataBase dataBase = new DataBase();

    public String registration(List<UsersDao> usersList) throws SQLException {

        dataBase.connectDataBase();
        List<UsersDao> daoList = dataBase.writeTableUsers(usersList);
        dataBase.closeDB();

        return check(usersList, daoList);
    }

    public String autorization (List<UsersDao> usersList) throws SQLException {

        dataBase.connectDataBase();
        List<UsersDao> daoList = dataBase.readTableUsers();
        dataBase.closeDB();

        return check(usersList, daoList);

    }

    public String check(List<UsersDao> usersList, List<UsersDao> daoList){


        for (UsersDao elFromDB : daoList){
            for (UsersDao elFromUser : usersList){
                if (elFromDB.getName().equals(elFromUser.getName())
                        && elFromDB.getName().equals(elFromUser.getPassword())){
                    return "true";
                }
            }
        }

        return "false";
    }
}
