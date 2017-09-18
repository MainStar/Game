package GameWeb.Servlets;

import GameServer.Server.Server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("username") == null && req.getParameter("password") == null){
            req.getRequestDispatcher("WEB-INF/pages/pageLogin.html").forward(req, resp);
        }else {
            resp.getWriter().append("User name: " + req.getParameter("username") + "\nPassword: "
                    + req.getParameter("password"));
        }

//        Server server = new Server();
//        server.start();
    }
}