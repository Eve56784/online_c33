package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import userDB.UserDB;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/get")
public class GetUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        if (idParam == null || idParam.isEmpty()) {
            out.println("ID parameter is empty");
            return;
        }
        try{
            int id = Integer.parseInt(idParam);
            UserDB userDB = new UserDB();
            User user = userDB.getUserById(id);
            if (user != null) {
                String html = String.format("<html><body>" +
                                "<h1>User info</h1>" +
                                "Username: %s<br>" +
                                "ID: %d<br>" +
                                "Login: %s<br>" +
                                "</body></html>",
                        user.getUsername(), user.getId(), user.getLogin());
                out.println(html);
                out.println("<p><a href='http://localhost:8080/postgresql_war/'>Return to HomePage</a></p>");
            }
            else {
                out.println("<h1>User not found</h1>");
                out.println("<p><a href='http://localhost:8080/postgresql_war/'>Return to HomePage</a></p>");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
