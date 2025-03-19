package HW_24_Task_One;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "MinskServlet", urlPatterns = "/minsk")
public class Minsk extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ZonedDateTime minskTime = ZonedDateTime.now(ZoneId.of("Europe/Minsk"));
        resp.setContentType("text/plain");
        resp.getWriter().println("Time in Minsk:" + minskTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}