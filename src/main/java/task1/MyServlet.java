/*package task1;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "MyServlet", urlPatterns = "/*")
public class MyServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        System.out.println("The app was initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logReq(req);
        resp.getWriter().println("The app got a GET-request");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logReq(req);
        resp.getWriter().println("The app a got POST-request");
    }

    private void logReq(HttpServletRequest req){
        LocalDateTime currentTime = LocalDateTime.now();

        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("Request received at: " + formattedTime + ", Method: " + req.getMethod());
    }
}*/