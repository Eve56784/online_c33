import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html");
        resp.getWriter().println("""
            <!DOCTYPE html>
            <html>
            <head>
                <title>Главная</title>
            </head>
            <body>
                <h1>Добро пожаловать!</h1>
                <p>Перейдите на <a href="/webapp-demo/about">страницу "О нас"</a></p>
                <p>Или посмотрите <a href="/webapp-demo/contacts">контакты</a></p>
            </body>
            </html>
        """);
    }
}
