import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String message = req.getParameter("message");

        if(name == null || lastName == null || message == null || name.trim().isEmpty()
                || lastName.trim().isEmpty() || message.trim().isEmpty()) {
            resp.sendRedirect("save-request.jsp");
            return;
        }
        req.setAttribute("name", name);
        req.setAttribute("lastName", lastName);
        req.setAttribute("message", message);

        RequestDispatcher dispatcher = req.getRequestDispatcher("success.jsp");
        dispatcher.forward(req, resp);
    }
}
