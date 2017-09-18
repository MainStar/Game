package GameWeb.Servlets;

import Dao.Users.UsersDao;
import GameServer.ServerAction.AutorizationRegistration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/check")
public class ServletCheck extends HttpServlet {

    private String autorozation;
    UsersDao usersDao = new UsersDao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("username") ==null && req.getParameter("password") == null){
            req.getRequestDispatcher("WEB-INF/pages/pageRegistration.html").forward(req, resp);
        }else {
            resp.getWriter().append(req.getParameter("username") + req.getParameter("password"));
        }

    }

    //    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("username");
//        String password = req.getParameter("password");
//
//        usersDao.setName(name);
//        usersDao.setPassword(password);
//
//        List<UsersDao> usersList = new ArrayList<>();
//        usersList.add(usersDao);
//
//        System.out.println(name + " " + password);
//
//        AutorizationRegistration auto = new AutorizationRegistration();
//        try {
//
//            autorozation = auto.autorization(usersList);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        if (autorozation.equals("true")){
//            resp.getWriter().append("Login: " + name + "\nPassword: " + password);
//        }else {
//            resp.getWriter().append("Эй ЛОЛ, ты не туда щимишься!)");
//        }
//    }
}
