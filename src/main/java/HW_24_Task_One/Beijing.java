package HW_24_Task_One;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "BeijingServlet", urlPatterns = "/beijing")
public class Beijing extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ZonedDateTime beijingTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai")); //Шанхай тк с Пекином выдавало ошибку "не найдена таймзона"
        resp.setContentType("text/plain");
        resp.getWriter().println("Time in Beijing: " + beijingTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
