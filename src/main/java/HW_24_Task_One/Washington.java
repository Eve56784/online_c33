package HW_24_Task_One;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Washington extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ZonedDateTime washingtonTime = ZonedDateTime.now(ZoneId.of("America/New_York")); //а же ошибка что и с пекином
        resp.setContentType("text/plain");
        resp.getWriter().println("Time in Washington: " + washingtonTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
