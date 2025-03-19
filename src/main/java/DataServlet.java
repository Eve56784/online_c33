import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DataServlet", urlPatterns = "/upload")
public class DataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = request.getReader().lines()
                .collect(java.util.stream.Collectors.joining());

        response.setContentType("text/plain");
        response.getWriter().println("Received data: " + data);
    }
}