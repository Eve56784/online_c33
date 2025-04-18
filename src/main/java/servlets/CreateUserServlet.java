package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import userDB.UserDB;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/create")
public class CreateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String username = req.getParameter("username");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        if (login == null || login.isEmpty()) {
            out.println("<h1>Invalid login</h1>");
            return;
        }
        User user = new User();
        user.setLogin(login);
        user.setUsername(username);
        UserDB userDB = new UserDB();
        int result = userDB.createUser(user);
        if(result>0)
            out.println("<h1>Success</h1>");
        else
            out.println("<h1>Error</h1>");
    }
}
