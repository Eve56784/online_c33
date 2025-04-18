package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import userDB.UserDB;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/delete")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        if(idParam == null||idParam.isEmpty()) {
            out.println("<h1>Invalid ID</h1>");
            return;
        }
        try{
            int id = Integer.parseInt(idParam);
            UserDB userDB = new UserDB();
            int result = userDB.deleteUser(id);
            if (result > 0){
                out.println("<h1>Deleted</h1>");
                out.println("<p><a href='http://localhost:8080/postgresql_war/'>Return to HomePage</a></p>");
            }
            else {
                out.println("<h1>Error</h1>");
                out.println("<p><a href='http://localhost:8080/postgresql_war/'>Return to HomePage</a></p>");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
