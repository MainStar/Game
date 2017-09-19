package GameWeb.Servlets;

import GameServer.Server.Server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin")
public class ServletAdmin extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("serverStart") == null) {
            req.getRequestDispatcher("WEB-INF/pages/pageAdmin.html").forward(req, resp);
        }else {
            Server server = new Server();
            server.start();
        }
    }
}
