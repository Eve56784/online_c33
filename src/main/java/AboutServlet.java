import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

    @WebServlet("/about")
    public class AboutServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            resp.setContentType("text/html");
            resp.getWriter().println("""
            <!DOCTYPE html>
            <html>
            <head>
                <title>О нас</title>
            </head>
            <body>
                <h1>О нашей компании</h1>
                <p>Мы лучшие в своем деле!</p>
                <a href="/webapp-demo/home">На главную</a>
            </body>
            </html>
        """);
        }
    }
