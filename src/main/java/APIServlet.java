import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ApiServlet", urlPatterns = "/api/data")
public class APIServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String key = request.getParameter("key");
        String value = request.getParameter("value");

        response.setContentType("application/json");
        response.getWriter().println(
                "{ \"status\": \"OK\", \"received\": { \"" + key + "\": \"" + value + "\" } }"
        );
    }
}