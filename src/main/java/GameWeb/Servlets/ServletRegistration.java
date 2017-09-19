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

@WebServlet(urlPatterns = "/registration")
public class ServletRegistration extends HttpServlet {

    //Переменная для принятия ответа от проверки по авторизации
    private String autorization;
    //Переменная для проверки регистрации и авторизации
    AutorizationRegistration auto = new AutorizationRegistration();
    //Объект конструктора
    UsersDao user = new UsersDao();

    List<UsersDao> userList = new ArrayList<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("username") ==null && req.getParameter("password") == null){
            req.getRequestDispatcher("WEB-INF/pages/pageRegistration.html").forward(req, resp);
        }else {

            String name = req.getParameter("username");
            String password = req.getParameter("password");
            String repassword = req.getParameter("repassword");

            if (password.equals(repassword)) {

                user.setName(name);
                user.setPassword(password);

                userList.add(user);

                try {

                    autorization = auto.registration(userList);

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (autorization.equals("true")) {
                    resp.getWriter().append("Login: " + name + "\nPassword: " + password);
                } else {
                    resp.getWriter().append("Шлепок ты уже есть в системе!!)");
                }
            }else {
                resp.getWriter().append("ЛОЛ введи повтор пароля верно!!!");
            }
        }
    }
}
