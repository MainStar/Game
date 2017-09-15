package GameServer.Servlets;

import GameServer.Dao.UsersDao;
import GameServer.DataBase.DataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/check")
public class ServletCheck extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(name + " " + password);

        DataBase readTableUsers = new DataBase();

        List<UsersDao> users = readTableUsers.readTableUsers();
        for (UsersDao el : users){
            if (el.getName().equals(name) && el.getPassword().equals(password)){
                resp.getWriter().append("ID: " + el.getId() + "\nLogin: " + el.getName() + "\nPassword: " + el.getPassword());
            }
        }
    }
}
