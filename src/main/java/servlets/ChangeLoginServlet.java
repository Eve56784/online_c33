package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import userDB.UserDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/change-login")
public class ChangeLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");
        String newLogin = req.getParameter("login");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        if(idParam == null || newLogin == null) {
            out.println("<h1>Invalid login or id</h1>");
            return;
        }
        try{
            int id = Integer.parseInt(idParam);
            UserDB userDB = new UserDB();
            int result = userDB.changeUserLogin(id, newLogin);
            if (result > 0){
                out.println("<h1>Success</h1>");
                out.println("<p><a href='http://localhost:8080/postgresql_war/'>Return to HomePage</a></p>");
            }
            else {
                out.println("<h1>Error</h1>");
                out.println("<p><a href='http://localhost:8080/postgresql_war/'>Return to HomePage</a></p>");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
