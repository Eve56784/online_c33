import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/contacts")
public class ContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("""
            <!DOCTYPE html>
            <html>
            <head>
                <title>Контакты</title>
            </head>
            <body>
                <h1>Свяжитесь с нами</h1>
                <p>Email: contact@example.com</p>
                <p>Телефон: +7 (999) 123-45-67</p>
                <a href="/webapp-demo/home">На главную</a>
            </body>
            </html>
        """);
    }
}