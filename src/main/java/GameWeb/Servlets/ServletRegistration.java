package GameWeb.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registration")
public class ServletRegistration extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/pages/pageRegistration.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Name: " + req.getParameter("username") + "\nPassword: " + req.getParameter("password")
                + "\nRepassword: " + req.getParameter("repassword"));
        System.out.println("Name: " + req.getParameter("username") + " Password: " + req.getParameter("password"));
    }
}
